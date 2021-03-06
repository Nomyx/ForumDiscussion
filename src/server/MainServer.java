package server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainServer {
	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
		}
		catch (Exception e){
			System.out.println(new Object(){}.getClass().getEnclosingClass().getName() + ": <ERROR>[1] Exception / Port already use");
		}
		try {
			ServerForum server = new ServerForum();
//			String serverAddress = "//192.168.137.1:1099/ServerForum"; 
			String serverAddress = "//"+ InetAddress.getLocalHost().getHostAddress() +":1099/ServerForum";
			Naming.rebind(serverAddress, server);
			System.out.println(new Object(){}.getClass().getEnclosingClass().getName() + ": <OK> Server ready at " + serverAddress);
		}
		catch (MalformedURLException e){
			System.out.println(new Object(){}.getClass().getEnclosingClass().getName() + ": <ERROR>[2] MalformedURLException"); 
			e.printStackTrace();
		}
		catch (RemoteException e){
			System.out.println(new Object(){}.getClass().getEnclosingClass().getName() + ": <ERROR>[3] RemoteException"); 
			e.printStackTrace();
		}
		catch (UnknownHostException e){
			System.out.println(new Object(){}.getClass().getEnclosingClass().getName() + ": <ERROR>[4] UnknownHostException"); 
			e.printStackTrace();
		}
	}

}
