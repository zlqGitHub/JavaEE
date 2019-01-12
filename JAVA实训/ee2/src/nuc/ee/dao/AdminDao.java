package nuc.ee.dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import nuc.ee.model.Course;
import nuc.ee.util.Conn;

public class AdminDao {
	
	//判断管理是否能登录
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
	
	//更新课程信息
	@SuppressWarnings("unlikely-arg-type")
	public List<Course> update_course(){
		List<Course> csList = new ArrayList<Course>();
		List<Course> csList2 = new ArrayList<Course>();
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
				csList.add(c);
			}
			
			
			for(int i=0;i<csList.size();i++) {
				for(int j=i+1;j<csList.size();j++) {
					if(csList.get(i).getTd().equals(csList.get(j).getId())) {
						csList.remove(j);
						j--;
					}
				}
				csList2.add(csList.get(i));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return csList2;
	}
	
	

}
