package nuc.ee.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

}
