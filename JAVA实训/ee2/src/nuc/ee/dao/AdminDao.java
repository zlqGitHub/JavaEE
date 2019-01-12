package nuc.ee.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import nuc.ee.model.Course;
import nuc.ee.util.Conn;

public class AdminDao {
	
	//�жϹ����Ƿ��ܵ�¼
	public int select_admin(String name,String pass){
		int i = 0;
		ResultSet rs = null;
		
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			String books_select = "select * from admin where username = ? and password = ?";
			pst = conn.prepareStatement(books_select);
			pst.setString(1, name);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				i = 1;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	//���¿γ���Ϣ
	public List<Course> update_course(){
		List<Course> csList = new ArrayList<Course>();
		ResultSet rs = null;
		
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			String books_select = "select * from ena union all select * from enb union all select * from enc";
			pst = conn.prepareStatement(books_select);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setTd(rs.getString(2));
				c.setIntroduce(rs.getString(3));
				c.setDetails(rs.getString(4));
				c.setImg(rs.getString(5));
				c.setStatus(rs.getString(6));
				csList.add(c);
			}
			
			//ȥ���رյĿγ�
			for(int i=0;i<csList.size();i++) {
				if(csList.get(i).getStatus().equals("�ر�")) {
					csList.remove(i);	
				}
			}
			
			
			for(int i=0;i<csList.size();i++) {
				
				for(int j=i+1;j<csList.size();j++) {
					if(csList.get(i).getTd().equals(csList.get(j).getTd())) {
						csList.remove(j);
						System.out.println("a");
						j--;
					}
					
				}
				
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return csList;
	}
	
	
	//�����º������д��course����
	public int insert_course(List<Course> csList){
		int rs = 0;
		
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			//���Ƚ����������ɾ��
			String delete_course = "delete from course";
			pst = conn.prepareStatement(delete_course);
			rs = pst.executeUpdate();
			//��������д�����
			for(int i=0;i<csList.size();i++) {
				String insert_course = "insert into course(td,introduce,details,img) value(?,?,?,?)";
				pst = conn.prepareStatement(insert_course);
				pst.setString(1, csList.get(i).getTd());
				pst.setString(2, csList.get(i).getIntroduce());
				pst.setString(3, csList.get(i).getDetails());
				pst.setString(4, csList.get(i).getImg());
				
				rs = pst.executeUpdate();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	

}
