/*File Name: Echo.java
 Group Number : 7
 Group Members : Sayali Nagwekar, Ajay Parameshwaran
 Course: ITMD 566
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Echo extends Thread 
{//Start of Echo class
    protected Socket socket;
    
    //Constructor
    public Echo(Socket clientSocket) 
    {//Start of Echo Constructor
        this.socket = clientSocket;
    }//End of Echo Constructor
			
public void Connection()
{//Start of Connection Method
	System.out.println("Client Connected");
	BufferedReader br;
	//Reading the data from BufferReader and printing it
	try 
	{
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
	while (true) 
	{
		String string = br.readLine();
		if (string.equalsIgnoreCase("Exit")) 
		{
			pw.println("Byeeeeee....");
			break;
		}

		if (string.equalsIgnoreCase("Count number of clients"))
		{
			pw.println("Clients connected to server are: "+Server.count);
		}else if(string.contains("+")||string.contains("-")||string.contains("/")||
				string.contains("%")||string.contains("//")||string.contains("/"))
		{
			Operations(string,pw);
		}
		else 
		{
			pw.println("Server Running:" + string);
		}
	}
	} 
	catch (IOException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally
	  {    
		    try
		    {
		        System.out.println("Connection closed");
		        if (socket!=null)
		        {
		        	socket.close();
		        System.out.println("Socket Closed");
		        }

		        }
		    catch(IOException ie)
		    {
		        System.out.println("Error.....");
		    }
		    }
}//End of Connection method


public static void Operations(String string, PrintWriter print)
{//Start of Operations method
	
	//Initializing of variables to separate the string
	int result, op1, op2;
	StringTokenizer st;
	st = new StringTokenizer(string);
	op1 = Integer.parseInt(st.nextToken());
	String operation = st.nextToken();
	op2 = Integer.parseInt(st.nextToken());

	if (string.contains("+")) {
		result = op1 + op2;
		

		print.println("Result: " + result);
	} else if (string.contains("*")) {
		
		
		
		result = Math.floorDiv(op1, op2);
		print.println("Result: " + result);
	} else if (string.contains("-")) {
		
		result = op1 % op2;
		print.println("Result: " + result);
	} else if (string.contains("/")) {
		
		result = op1 * op2;
		print.println("Result: " + result);
	} else if (string.contains("//")) {
		
		result = op1 - op2;
		print.println("Result: " + result);
	} else if (string.contains("%")) {
		
					result = op1 / op2;
		print.println("Result : " + result);
	} 
}//End of Operations method
}//End of Echo class
