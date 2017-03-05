/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import gnu.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author axkiller
 */
public class ConnectListener implements Runnable, SerialPortEventListener{
    SerialPort serialPort;
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbserial-A9007UX1", // Mac OS X
                        "/dev/ttyACM0", // Raspberry Pi
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	private BufferedReader input;
	/** The output stream to the port */
	public static OutputStream output;
        CommPortIdentifier portId;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
        static String msg = "2";
	public void initialize() throws Exception{
                // the next line is for Raspberry Pi and 
                // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
                System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

		//First, Find an instance of serial port as set in PORT_NAMES.
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			throw new Exception();
			
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);
                        output = serialPort.getOutputStream();
			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			// open the streams
			//input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			//output.write(msg.getBytes());
                        //System.out.println(msg);
                        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
                        //input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
                        e.printStackTrace();
		}
                
	}
        public void setColor(String color) throws Exception{
                
             

		try {
		
			output.write(color.getBytes());
                        System.out.println(color.getBytes());
                        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();
                        //input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			// add event listeners
			
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
                        e.printStackTrace();
		}
             
                
	        
        }
    @Override
    public void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
                          
                               
                           
				String inputLine=input.readLine();
				System.out.println(inputLine);
                                
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
    }

    @Override
    public void run() {
        while(true){
            try {
                initialize();
            } catch (Exception ex) {
                System.out.println("No hay");
            }
        }
    }
    
}
