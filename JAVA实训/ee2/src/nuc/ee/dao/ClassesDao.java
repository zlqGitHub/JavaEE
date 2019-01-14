package nuc.ee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nuc.ee.model.*;
import nuc.ee.util.*;

public class ClassesDao {
	Conn dbc=new Conn();
	Connection conn=dbc.conn();
	
	public List<Classes> selectListAll(){
		List<Classes> list = new ArrayList<Classes>();
		String sql = "select * from classes";
		ResultSet rs = null;
		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Classes record = new Classes();
				record.setClassname(rs.getString("classname"));
				record.setEn(rs.getString("en"));
				record.setTd(rs.getString("td"));
				record.setUserid(rs.getInt("userid"));
				record.setTeachername(rs.getString("teachername"));
				record.setNamelist(this.selectNameListByUserid(record.getUserid()));				
				list.add(record);			    		    			    						    
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public NameList selectNameListByUserid(int userid) {
		NameList record = new NameList();
		ResultSet rs = null;
		String sql = "select * from namelist where userid=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			rs = pst.executeQuery();
			if(rs.next()) {				
				record.setChange(rs.getInt("number"));;
				record.setTd(rs.getString("td"));
				record.setUserid(rs.getInt("userid"));
				record.setUsername(rs.getString("username"));
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return record;
	}
	
	
	
	
	public void updateClass(int userid, String en, String td, String classname) {
		String sql = "insert into classes(userid,td,en,classname) values(?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, userid);
			pst.setString(2, td);
			pst.setString(3, en);
			pst.setString(4, classname);
			int rs = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
