/*File Name: Server.java
 Group Number : 7
 Group Members : Sayali Nagwekar, Ajay Parameshwaran
 Course: ITMD 566
 * 
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{//Start of Server class
	public static int count=0;

	public static void main(String[] args)
	{//Start of Main class
		// TODO Auto-generated method stub
		
			ServerSocket serverSocket = null;//Initializing the Server Socket
			Socket so = null;
			try 
			{
				serverSocket = new ServerSocket(9999);
			}
			catch (IOException e) {
	            e.printStackTrace();

	        }
			while(true){
		try
		{
			so=serverSocket.accept();
			clientcount();
		}
		catch (IOException e) {
            e.printStackTrace();

        }
        new Echo(so).start();
			}
	}//End of Main class
	//Method to count the number of clients
	private static void clientcount() 
	{
		count++;		
	}

}//End of Server class

