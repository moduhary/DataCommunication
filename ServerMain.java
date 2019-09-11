package echoserver1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server echo = new Server(null);
		String msg = null;
		
		InputStream read1 = null;	
		OutputStream write1 = null;
		
		System.out.printf("Server is listening on port %d\n", echo.getSocket().getLocalPort());
		
		echo.accept();
		
		System.out.println("Client connected.");
		
		try {
			read1 = echo.getRWSocket().getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			write1 = echo.getRWSocket().getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		echo.setInputStream(read1);
		echo.setOutputStream(write1);
		
		while(true)
		{	
			msg = echo.Read();
			
			System.out.printf("Message: %s",msg);
			
			if(msg == "Q\n")
			{
				
				try {
					read1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					write1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				echo.close();
				
				break;
			}
			else
			{
				echo.Write(msg.substring(0,msg.length()-1));
				continue;
			}
		}
		
		return;
	}

}
