package nuc.sw.dangdang.action;

import java.io.*;
import java.net.URLEncoder;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")

//�����Ϻ���ļ�
public class DownloadAction extends ActionSupport {
	private String inputPath;
	private String contentType;
	private String downFileName;
		
	public String getInputPath() {
		return inputPath;
	}
//��������
	public void setInputPath(String inputPath) throws UnsupportedEncodingException {
		this.inputPath = new String(inputPath.getBytes("iso-8859-1"),"utf-8");
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDownFileName() throws UnsupportedEncodingException {
		return URLEncoder.encode(downFileName, "utf-8");
	}

	public void setDownFileName(String downFileName) throws UnsupportedEncodingException {
		this.downFileName = new String(downFileName.getBytes("iso-8859-1"),"utf-8");
	}
//�޸�ʹ�����غ���ļ�����ȷ
	public InputStream getTargetFile() throws FileNotFoundException {
		InputStream is = new FileInputStream(inputPath);
		return is;
	}
}
