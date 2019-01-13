package nuc.ee.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import nuc.ee.model.Company;
import nuc.ee.model.GignUp;
import nuc.ee.model.User;
import nuc.ee.model.UserLogin;
import nuc.ee.util.Conn;

public class UserDao {	
	//在注册表中查询，看该学号是否已经注册过
	public int regist_select(User u) {
		ResultSet rs = null;
		int i = 0;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.conn();
//				System.out.println(conn);
			PreparedStatement pst =null;
			String select = "select * from user where userid = ?";
			pst = conn.prepareStatement(select);
			pst.setInt(1, u.getUserid());
			rs = pst.executeQuery();
			if(rs.next()) {
				i++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	//3、注册写入信息
	public int user_insert(User u) {
		int rs = 0;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			String insert = "insert into user(userid,password,username,sex,age,telphone,department) values(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(insert);
			pst.setInt(1, u.getUserid());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getUsername());
			pst.setString(4, u.getSex());
//				System.out.println(stu.getSex());
			pst.setInt(5, u.getAge());
			pst.setString(6, u.getTelphone());
			pst.setString(7, u.getDepartment());
			
			rs = pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//登录判断
	//判断账号、密码是否正确
	public User login_select(UserLogin u) {
		ResultSet rs = null;
		User user = new User();
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.conn();
//					System.out.println(conn);
			PreparedStatement pst =null;
			String select = "select * from user where userid = ? and password = ?";
			pst = conn.prepareStatement(select);
			pst.setInt(1, u.getUserid());
			pst.setString(2, u.getPassword());
			rs = pst.executeQuery();
			if(rs.next()) {
				user.setUserid(rs.getInt(2));
				user.setUsername(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	//将报名信息写入表中
	public int insert_user(GignUp gp,int num,String time){
		UserDao uDao = new UserDao();
		int rs = 0;
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			//删除报名信息
			uDao.delete_user(gp.getUserid());
			//将新记录插入表中
			String insert_info = "insert into namelist (td,userid,username,number,date) values(?,?,?,?,?)";
			pst = conn.prepareStatement(insert_info);
			pst.setString(1, gp.getTd());
			pst.setInt(2, gp.getUserid());
			pst.setString(3, gp.getUsername());
			pst.setInt(4, num);
			pst.setString(5, time);
			rs = pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//删除报名表中的信息
	public void delete_user(int userid){
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			//先将原记录其删除
			String delete_info = "delete from namelist where userid = ?";
			pst = conn.prepareStatement(delete_info);
			pst.setInt(1, userid);
			int rs = pst.executeUpdate();
			System.out.println("rs="+rs);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//查询该注册者还有几次报名机会
	public int get_change(int userid){
		int change = 0;
		ResultSet rs = null;
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			
			String insert_info = "select * from namelist where userid = ?";
			pst = conn.prepareStatement(insert_info);
			pst.setInt(1, userid);		
			rs = pst.executeQuery();
			
			if(rs.next()) {
				change = rs.getInt(5);
//				change--;
			}
			else {
				change = 3;
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		System.out.println("3."+change);
		return change;
	}
	
	//用户登录成功后获取公司的信息
	public List<Company> get_company(){
		List<Company> comList = new ArrayList<Company>();
		ResultSet rs = null;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.conn();
			PreparedStatement pst =null;
			String select = "select * from company";
			pst = conn.prepareStatement(select);
			rs = pst.executeQuery();
			while(rs.next()) {
				Company com = new Company();
				com.setId(rs.getInt(1));
				com.setName(rs.getString(2));
				com.setIcon(rs.getString(3));
				com.setIntroduce(rs.getString(4));
				comList.add(com);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return comList;
	}


}
