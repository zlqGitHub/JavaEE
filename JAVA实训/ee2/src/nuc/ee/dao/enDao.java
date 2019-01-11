package nuc.ee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import nuc.ee.model.*;
import nuc.ee.util.*;
public class enDao {
	public List<En> inIt(String en){			//查找方法
		List<En> enlist=new ArrayList<En>();
		ResultSet rs=null;
		try{
		   	 Conn conn=new Conn();
			 Connection dbc=conn.conn();
			 String sql_select=null;
			 if("ena".equals(en)) {
				 sql_select="select * from ena";
			 }
			 if("enb".equals(en)) {
				 sql_select="select * from enb";
			 }
			 if("enc".equals(en)) {
				 sql_select="select * from enc";
			 }
			 PreparedStatement pst=dbc.prepareStatement(sql_select);
			 rs=pst.executeQuery();
			 while(rs.next()){
			 En en1 = new En();
			 en1.setState(rs.getString("state"));
			 en1.setTd(rs.getString("td"));
			 enlist.add(en1);
			 }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return enlist;
	}
	public int DeleteEn(String en, String td) {			//删除方法
		int re = 0;
		try {
			Conn abc=new Conn();
			Connection conn=abc.conn();
			String sql_delete=null;
			if("ena".equals(en)) {
				sql_delete="delete from ena where td=?";
			}
			if("enb".equals(en)) {
				sql_delete="delete from enb where td=?";
			}
			if("enc".equals(en)) {
				sql_delete="delete from enc where td=?";
			}
			PreparedStatement pst=conn.prepareStatement(sql_delete);
			pst.setString(1, td);
			re=pst.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return re;
	}
	public int addEn(String en,String td, String state) {	//添加方法
		int re=0;
		try{
			Conn dbc=new Conn();
			Connection conn=dbc.conn();
			String sql_insert=null;
			if("ena".equals(en)) {
				sql_insert="insert into ena(td,state) values(?,?)";
			}
			if("enb".equals(en)) {
				sql_insert="insert into enb(td,state) values(?,?)";
			}
			if("enc".equals(en)) {
				sql_insert="insert into enc(td,state) values(?,?)";
			}
			PreparedStatement pst=conn.prepareStatement(sql_insert);
			pst.setString(1, td);
			pst.setString(2, state);
			re=pst.executeUpdate();
			}
		catch(Exception e){
			System.out.println(e);
		}
		return re;
	}
	public int updateEn(String en ,String td,String state){ 			//修改
		int rs=0;
		try{
			Conn dbc=new Conn();	
			Connection conn=dbc.conn();
			String sql_update=null;
			if("ena".equals(en)) {
				sql_update="update ena set state=? where td=?";
			}
			if("enb".equals(en)) {
				sql_update="update enb set state=? where td=?";
			}
			if("enc".equals(en)) {
				sql_update="update enc set state=? where td=?";
			}
			PreparedStatement pst=conn.prepareStatement(sql_update);
			pst.setString(1, state);
			pst.setString(2, td);
			rs=pst.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs;
	}
	
}
