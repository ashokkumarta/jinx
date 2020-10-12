package ash.java.tools.jinx.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;

import ash.java.tools.jinx.JinxBase;

public abstract class HandlerBase extends JinxBase implements IHandler {

	protected PrintWriter out;
	protected BufferedOutputStream dataOut;
	protected File file;
	protected String statusMsg;

	public HandlerBase(PrintWriter out, BufferedOutputStream dataOut, String fileName) {
		this(out, dataOut, fileName, OK_STATUS);
	}
	
	public HandlerBase(PrintWriter out, BufferedOutputStream dataOut, String fileName, String statusMsg) {
		this(out, dataOut, new File(WEB_ROOT, fileName), statusMsg);
	}

	public HandlerBase(PrintWriter out, BufferedOutputStream dataOut, File file, String statusMsg) {
		this.out = out;
		this.dataOut = dataOut;
		this.file = file;
		this.statusMsg = statusMsg;
	}

	protected void handleHeader() throws IOException {
		out.println(statusMsg);
		out.println(SERVER_MESSAGE);
		out.println("Date: " + new Date());
		out.println("Content-type: " + getContentType());
		out.println("Content-length: " + getFileLength());
		out.println(); // blank line between headers and content, very important !
		out.flush(); // flush character output stream buffer
		
	}
	
	protected void handleBody() throws IOException {
		
		byte[] fileData = readFileData();;
		dataOut.write(fileData, 0, getFileLength());
		dataOut.flush();
		
	}

	@Override
	public void handle() {
		try {
			
			handleHeader();
			
			handleBody();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private int getFileLength() {
		return (int) file.length();
	}

	protected byte[] readFileData() throws IOException {

		int fileLength = getFileLength();

		FileInputStream fileIn = null;
		byte[] fileData = new byte[fileLength];

		try {
			fileIn = new FileInputStream(file);
			fileIn.read(fileData);
		} finally {
			if (fileIn != null)
				fileIn.close();
		}

		return fileData;
	}

	protected String getContentType() throws IOException {
		return Files.probeContentType(file.toPath());
	}

}
