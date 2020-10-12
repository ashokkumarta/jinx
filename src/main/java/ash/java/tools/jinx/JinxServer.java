package ash.java.tools.jinx;

import java.io.IOException;
import java.net.ServerSocket;

public class JinxServer extends JinxBase {

	public void start() {

		try {

			ServerSocket serverConnect = new ServerSocket(DEFALT_PORT);
			System.out.println("Server started.\nListening for connections on port : " + DEFALT_PORT + " ...\n");

			while (true) {
				JinxClient jClient = new JinxClient(serverConnect.accept());

				Thread thread = new Thread(jClient);
				thread.start();
			}

		} catch (IOException e) {
			System.err.println("Server Connection error : " + e.getMessage());
		}
	}

}
