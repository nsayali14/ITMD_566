/*File Name: Client.java
 Group Number : 7
 Group Members : Sayali Nagwekar, Ajay Parameshwaran
 Course: ITMD 566
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

//Start of Client class
public class Client {

	public static void main(String[] args) throws  IOException 
	{//Start of Main class
		// TODO Auto-generated method stub
		Socket client = new Socket("localhost",9999);//initializing the socket
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));//Initializing the BufferReader and reading the input 
		PrintWriter print = new PrintWriter(client.getOutputStream(),true);//Initializing the PrintWriter and sending the output data
		
		//Initializing the variables
		Scanner sc = new Scanner(System.in);
		String response=null;
		String echoS = null;
		
		do
		{//Start of do loop
			System.out.println("1. Please enter the string"
					+ "\n2. Please enter the mathematical operations"
					+ "\n3. Number of clients");
			echoS = sc.nextLine();
			print.println(echoS);
			if(!echoS.equals("Exit"))
			{//Start of if loop
				response = reader.readLine();
				System.out.println(response);
			}//End of if loop
		}//End of do loop
		while(!echoS.equals("Exit"));
		sc.close();
		client.close();
	}//End of Main class


}//End of Client class


