import java.io.*;
import java.net.*;
import java.util.*;
public class EchoServer {
	public static void main(String[] args ) {
		try {
			ServerSocket s = new ServerSocket(8189);
			// Creates a server socket, bound to the specified port.
			// should avoid the conflict with the well-known ports
			// ServerSocket wait for a connection from a client at 8189
			Socket incoming = s.accept( );
			// Listens for a connection to be made to this socket and accepts it.
			// This method blocks the current thread until the connection is made
			InetAddress clientAddress = incoming.getInetAddress() ;
			System.out.printf("Request from %s[%s] has been accepted!\n",
					clientAddress.getHostName(), clientAddress.getHostAddress()) ;
			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
				out.println( "Hello! Enter BYE to exit." );
				// echo client input
				boolean done = false;
				while ( !done && in.hasNextLine() ) {
					String line = in.nextLine(); // read a line of text from the client
					out.println("Echo: " + line); // echo it back to the client
					if ( line.trim().equals("BYE") ) done = true;
				}
			}
			finally { incoming.close(); }
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}