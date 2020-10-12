package ash.java.tools.jinx.handler.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import ash.java.tools.jinx.handler.HandlerBase;

public class HEADHandler extends HandlerBase {

	public HEADHandler(PrintWriter out, BufferedOutputStream dataOut, String fileRequested) {

		super(out, dataOut, fileRequested);
	}
	
	@Override
	public void handle() {
		try {
			
			handleHeader();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
