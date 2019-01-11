package nuc.ee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import nuc.ee.model.Admin;
import nuc.ee.util.Conn;

public class AdminDao {
	
	public List<Admin> select_admin(){
		ResultSet rs = null;
		List<Admin> adList = new ArrayList<Admin>();
		
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			String books_select = "select * from admin";
			pst = conn.prepareStatement(books_select);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Admin ad = new Admin();
				ad.setId(rs.getInt(1));
				ad.setAdmin(rs.getString(2));
				ad.setPass(rs.getString(3));
				adList.add(ad);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return adList;
	}

}
