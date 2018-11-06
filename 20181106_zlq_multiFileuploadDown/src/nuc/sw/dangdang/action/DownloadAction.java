package nuc.sw.dangdang.action;

import java.io.*;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownloadAction extends ActionSupport {
	private String inputPath;
	private String contentType;
	private String downFileName;
		
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}

	public InputStream getTargetFile() throws FileNotFoundException {
		InputStream is = new FileInputStream(inputPath);
		return is;
	}
}
