package ash.java.tools.jinx;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import ash.java.tools.jinx.handler.IHandler;
import ash.java.tools.jinx.handler.impl.FileNotFoundHandler;
import ash.java.tools.jinx.handler.impl.GETHandler;
import ash.java.tools.jinx.handler.impl.HEADHandler;
import ash.java.tools.jinx.handler.impl.MethodNotSupportedHandler;

public class JinxClient extends JinxBase implements Runnable {

	private Socket connect;

	public JinxClient(Socket c) {
		connect = c;
	}

	@Override
	public void run() {
		
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedOutputStream dataOut = null;
		String fileRequested = null;

		try {
			in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			out = new PrintWriter(connect.getOutputStream());
			dataOut = new BufferedOutputStream(connect.getOutputStream());

			String input = in.readLine();
			StringTokenizer parse = new StringTokenizer(input);
			String method = parse.nextToken().toUpperCase(); 
			fileRequested = parse.nextToken().toLowerCase();
			if (fileRequested.endsWith("/")) {
				fileRequested += DEFAULT_FILE;
			}
			
			IHandler handler;

			File file = new File(WEB_ROOT, fileRequested);
			if(!file.exists() || file.isDirectory()) { 
				handler = new FileNotFoundHandler(out, dataOut);
				handler.handle();
			} else if ("GET".equals(method)) {
				
				handler = new GETHandler(out, dataOut, fileRequested);
				handler.handle();
			} else if ("HEAD".equals(method)) {
				
				handler = new HEADHandler(out, dataOut, fileRequested);
				handler.handle();
			} else {
				
				handler = new MethodNotSupportedHandler(out, dataOut);
				handler.handle();
			}
			

		} catch (IOException ioe) {
			System.err.println("Server error : " + ioe);
		} finally {
			try {
				in.close();
				out.close();
				dataOut.close();
				connect.close(); // we close socket connection
			} catch (Exception e) {
				System.err.println("Error closing stream : " + e.getMessage());
			}

		}

	}
}
