package echoserver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;

public class Server {
	private Inet4Address IP;
	private ServerSocket server;
	private Socket rwStream;
	public String message;
	private BufferedReader Input;
	private BufferedWriter Output;
	private InputStreamReader In;
	private OutputStreamWriter Out;
	
	public Server(Inet4Address I)
	{
		byte[] ipAddr = new byte[]{127,0,0,1};
		try {
			IP = (Inet4Address) Inet4Address.getByAddress(ipAddr);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(I == null)
				server = new ServerSocket(1200,3,IP);
			else
				server = new ServerSocket(1200,3,I);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void accept()
	{
		try {
			rwStream = server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		try {
			server.close();
			rwStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ServerSocket getSocket()
	{
		return server;
	}
	
	public Socket getRWSocket()
	{
		return rwStream;
	}
	
	public void setInputStream(InputStream I)
	{
		In = new InputStreamReader(I);
		Input = new BufferedReader(In);
		
		return;
	}
	
	public void setOutputStream(OutputStream O)
	{	
		Out = new OutputStreamWriter(O);
		Output = new BufferedWriter(Out);
		
		return;
	}
	
	public String Read()
	{
		try {
			message = Input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}
	
	public void Write(String msg)
	{
		try {
			Output.write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}
}
