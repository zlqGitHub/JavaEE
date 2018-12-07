package nuc.sw.dangdang.action;

import java.io.File;

import java.io.*;
import java.util.UUID;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Student;

@SuppressWarnings("serial")
public class RegistAction extends ActionSupport implements ModelDriven<Student>{
	
	DataDao dao = new DataDao();
	private Student stu = new Student();
	private String error;
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;  //ͨ�������ļ�������

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public String RegistMethod() throws IOException {
//		System.out.println(stu.getUpload());
//		System.out.println("upload:"+upload);
//		System.out.println("uploadFileName:"+uploadFileName);
//		System.out.println("uploadContentType:"+uploadContentType);
//		System.out.println("savePath:"+savePath);
		
		FileInputStream fis = new FileInputStream(stu.getUpload());  //����ʱ���ϴ��ļ�����ʱ�ļ�
		UUID uuid = UUID.randomUUID();   //����UUID�����
		FileOutputStream fos = new FileOutputStream(savePath+'/'+uuid+uploadFileName); //���ʱ�ӱ����ļ���λ��
		String path = "headerImg/"+uuid+uploadFileName;
//		System.out.println(path);

		byte[] buffer = new byte[1024];  //����
				
		int len = 0;
		
		while((len =fis.read(buffer)) > 0) {
			fos.write(buffer,0,len);
		}
		
		fis.close();    //�ر��ļ���
		fos.close();
		
		int i = dao.stu_select(stu);
		int j = dao.regist_select(stu);
		if(i == 1 && j !=1) {
			dao.stu_insert(stu,path);
//			System.out.println(stu.getIcon());
			ActionContext.getContext().getSession().put("success", "ע��ɹ�");
			return "registOK";
		}
		else if(j == 1) {
			error = "��ѧ����ע�ᣡ";
			return "registRepeat";
		}
		else {
			error = "�������б���ѧ��Чѧ�ţ�";
			return "registFail";
		}
		
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}
	

}
