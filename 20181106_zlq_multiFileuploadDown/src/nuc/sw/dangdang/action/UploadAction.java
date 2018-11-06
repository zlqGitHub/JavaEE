package nuc.sw.dangdang.action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.entity.FileItem;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport{
	private List<FileItem> fileItems = new ArrayList<FileItem>();  //封装文件的集合

	public List<FileItem> getFileItems() {  
		return fileItems;
	}
	public void setFileItems(List<FileItem> fileItems) {
		this.fileItems = fileItems;
	}

	private String title;
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;
	private String savePath;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public String execute() throws IOException {
		FileItem fileItem;   // 定义一个模型
		for(int i=0;i<getUpload().size();i++) {
			fileItem = new FileItem();
			String realPath = savePath+'/'+UUID.randomUUID()+uploadFileName.get(i);
			FileInputStream fis = new FileInputStream(getUpload().get(i));
			FileOutputStream fos = new FileOutputStream(realPath);
			
			fileItem.setFilePath(realPath);
			fileItem.setFileName(uploadFileName.get(i));
			fileItem.setContentType(uploadContentType.get(i));
			
			fileItems.add(fileItem);
			byte[] buffer = new byte[1024];
			
			int len = 0;
			
			while((len = fis.read(buffer)) > 0) {
				fos.write(buffer,0,len);
			}
			fis.close();
			fos.close();
			
			//便于下载
			//getUploadFileName().set(i, savePath+'/'+UUID.randomUUID()+uploadFileName.get(i));

		}
		
		
		return "uploadOK";
	}
	
	

}
