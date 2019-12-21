import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;

public class ServerFrame extends JFrame {
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane;

	public ServerFrame(){
		setTitle("Server");
		setSize(600,400);
		scrollPane = new JScrollPane(textArea);
		add(scrollPane,BorderLayout.CENTER);
		try{
			this.setVisible(true);
			ServerSocket s = new ServerSocket(8189);

			Socket incoming = s.accept();
			InetAddress ClientAddress = incoming.getInetAddress();
			textArea.append("Conneted from : " + ClientAddress.getHostAddress() + "\n");
			try{
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream,true);
				while(in.hasNextLine()){
					String receive_str = in.nextLine();
					if(receive_str.equalsIgnoreCase("BYE")) {
						textArea.append("Disconnected");
						break;
					}
					textArea.append("Read : " + receive_str + "\n");
					String send_str = "Hi! " + receive_str;
					textArea.append("Write : " + send_str + "\n");
					out.println(send_str);
				}
			}
			finally{
				incoming.close();
			}
		}
		catch(IOException e){
			textArea.append("Disconnected.");
			e.printStackTrace();
		}
	}
}
