package client;

import java.net.InetAddress;
import java.rmi.Naming;
import java.util.List;

import server.IServerForum;
import server.ISubjectDiscussion;

public class mainClient {
	
	private static List<ISubjectDiscussion> listSubject;

	public static void main(String[] args) {
		try {
			String serverAddress = "//" + InetAddress.getLocalHost().getHostAddress() + ":1099/ServerForum";
			//String serverAddress = "//192.168.137.1:1099/ServerForum";
			IServerForum chatServer = (IServerForum) Naming.lookup(serverAddress);
			System.out.println("Connexion OK");
			listSubject = chatServer.remoteListSubject();
			//MainWindow window = new MainWindow(listSubject);
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Ca marche pas");
		}
	}

}
