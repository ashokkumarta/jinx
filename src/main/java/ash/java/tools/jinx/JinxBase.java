package ash.java.tools.jinx;

import java.io.File;
import ash.java.tools.JBase;

public abstract class JinxBase extends JBase {

	public static final int DEFALT_PORT = 8080;
	public static final String DEFAULT_FILE = "index.html";

	public static final File WEB_ROOT = new File(".");
	
	public static void main(String args[]) {
		new JinxServer().start();
	}
	
}
