package com.client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class ClientListThread extends Thread  {
	
	static final String HOST = "localhost";
  	static final int PORT = 5002;
  	static Socket sc;
	
	public void run() {
		
		try {
			
			sc = new Socket(HOST, PORT);
			
			DataOutputStream out = new  DataOutputStream(sc.getOutputStream());
			ObjectOutputStream outObject = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream inObject = new ObjectInputStream(sc.getInputStream());
			
			LinkedList<String> names = new LinkedList<String>();
			
			names.add("Estela");
			names.add("Michelle");
			names.add("Mike");
			names.add("Eduardo");
			names.add("Ana");
			names.add("Juanito");
			names.add("Maria");
			names.add("Ancelmo");
			names.add("Caro");
			names.add("Pedrito");
			names.add("Zaide");
			names.add("Wiliam");
			names.add("Elisa");
									
			System.out.println("Original List: ");
			System.out.println(names);
			
			out.writeInt(1);
			outObject.writeObject(names);
			
			System.out.println("\nOrdered List:");
			Object orderedNameList = inObject.readObject();
			System.out.println(orderedNameList + "\n");
			
			sc.close();
			
		}
		
		catch (Exception e){
			
			System.out.println("Error " + e.getMessage());
			
		}
	}
}