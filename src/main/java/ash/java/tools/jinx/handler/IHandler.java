package ash.java.tools.jinx.handler;

public interface IHandler  {

	public static final String SERVER_MESSAGE = "Server: A simple HTTP Server implementation in Java. Author: ashokkumar.ta@gmail.com Version: 0.0.1-SNAPSHOT";
	
	public static final String FILE_NOT_FOUND = "404.html";
	public static final String FILE_NOT_FOUND_STATUS = "HTTP/1.1 404 File Not Found";
	public static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	public static final String METHOD_NOT_SUPPORTED_STATUS = "HTTP/1.1 501 Not Implemented";
	public static final String OK_STATUS = "HTTP/1.1 200 OK";
	
	public void handle();

}
