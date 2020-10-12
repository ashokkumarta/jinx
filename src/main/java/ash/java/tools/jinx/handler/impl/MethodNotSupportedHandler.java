package ash.java.tools.jinx.handler.impl;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import ash.java.tools.jinx.handler.HandlerBase;

public class MethodNotSupportedHandler extends HandlerBase {
	
	public MethodNotSupportedHandler(PrintWriter out, BufferedOutputStream dataOut) {

		super(out, dataOut, METHOD_NOT_SUPPORTED, METHOD_NOT_SUPPORTED_STATUS);
	}

}
