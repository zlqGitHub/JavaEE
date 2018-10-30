package nuc.sw.dangdang.action;

import java.io.*;
import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;  //ͨ�������ļ�������
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String execute() throws IOException {
		System.out.println(upload);
		System.out.println(uploadFileName);
		System.out.println(uploadContentType);
		System.out.println(savePath);
		
		FileInputStream fis = new FileInputStream(upload);  //����ʱ���ϴ��ļ�����ʱ�ļ�
		FileOutputStream fos = new FileOutputStream(savePath+'/'+UUID.randomUUID()+uploadFileName); //���ʱ�ӱ����ļ���λ��
		//UUID.randomUUID()�������UUIDΨһ��
		byte[] buffer = new byte[1024];  //����
		
		int len = 0;
		
		while((len =fis.read(buffer)) > 0) {
			fos.write(buffer,0,len);
		}

		fis.close();    //�ر��ļ���
		fos.close();
		return "uploadOK";
	}
	
	

}
