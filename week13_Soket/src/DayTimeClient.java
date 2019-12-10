import java.io.*;
import java.net.*; // contains Socket-related classes
import java.util.*; // java.util.Scanner
public class DayTimeClient {
	public static void main(String[] args) {
		try { // Creates a stream socket and connects it to the port on the host.
			Socket s = new Socket("localhost", 8189);
			// Socket(String host, int port) throws UnknownHostException, IOException
			System.out.println(s.getInetAddress() + " " + s.getPort()) ;
			System.out.println(s.getLocalAddress().getHostAddress() + " " + s.getLocalPort());

			//2¡Ÿ

			try {
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);
				while ( in.hasNextLine() ) {
					String line = in.nextLine();
					System.out.println(line);

					//3¡Ò

				}
			}finally { s.close(); }
		} // void close() throws IOException; Closes this socket.
		catch ( IOException e ) { e.printStackTrace(); }
		// UnknownHostException is a subclass of IOException
	}
}
