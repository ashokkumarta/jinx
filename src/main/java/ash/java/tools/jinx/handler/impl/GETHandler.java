package ash.java.tools.jinx.handler.impl;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

import ash.java.tools.jinx.handler.HandlerBase;

public class GETHandler extends HandlerBase {

	public GETHandler(PrintWriter out, BufferedOutputStream dataOut, String fileRequested) {

		super(out, dataOut, fileRequested);
	}

}
