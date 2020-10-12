package ash.java.tools.jinx.handler.impl;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

import ash.java.tools.jinx.handler.HandlerBase;

public class FileNotFoundHandler extends HandlerBase {

	public FileNotFoundHandler(PrintWriter out, BufferedOutputStream dataOut) {

		super(out, dataOut, FILE_NOT_FOUND, FILE_NOT_FOUND_STATUS);
	}

}
