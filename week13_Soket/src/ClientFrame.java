import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class ClientFrame extends JFrame {
	Socket s = null;
	DataInputStream read;
	DataOutputStream write;
	String send_str = "", recv_str = "";

	public ClientFrame() {
		setTitle("Client");
		setSize(600, 400);
		JPanel buttonPanel = new JPanel();
		JTextArea textArea = new JTextArea(10, 40);

		JButton connect = new JButton("Connect");
		connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				textArea.append("Try to connect 127.0.0.1\n");
				try {
					s = new Socket("localhost", 8189);
					read = new DataInputStream(s.getInputStream());
					write = new DataOutputStream(s.getOutputStream());														
					textArea.append("Connection Established\n");	
				}catch(IOException e) {
					textArea.append("Connect Failed\n");
					e.printStackTrace();
				}
			}
		});
		buttonPanel.add(connect);

		JButton disconnect = new JButton("Disconnect");
		disconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				writing = new BufferedWriter(new OutputStreamWriter(write));
				try {
					writing.write("BYE");
					writing.flush();
					s.close();
					textArea.append("Disconnected\n");
				} catch (IOException e) {
					e.printStackTrace();
					textArea.append("Disconnect Failed\n");
				}

			}
		});
		buttonPanel.add(disconnect);
		
		textField = new JTextField(" ", 10);
		buttonPanel.add(textField);
			
		JButton send = new JButton("Send");
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				reading = new BufferedReader(new InputStreamReader(read));
				writing = new BufferedWriter(new OutputStreamWriter(write));
				send_str = textField.getText();

				textArea.append("Send : " + send_str + "\n");
				textArea.setVisible(true);
				try{
					writing.write(send_str+"\n");
					writing.flush();
					recv_str = reading.readLine();
					textArea.append("Receive : " + recv_str +"\n");
				}
				catch(Exception e){
				}
			}
		});
		buttonPanel.add(send);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		        textField.setText("");
			}
		});
		buttonPanel.add(clear);
		
		JButton quit = new JButton(" Quit ");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){	
				System.exit(0);
			}
		});
		buttonPanel.add(quit);
		
		add(buttonPanel, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private JTextField textField;
	private BufferedReader reading;
	private BufferedWriter writing;

}
