package nuc.ee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import nuc.ee.model.Course;
import nuc.ee.model.GignUp;
import nuc.ee.util.Conn;

public class UserDao {
	
	//将报名信息写入表中
		public int insert_course(GignUp gp,String date){
			int rs = 0;
			
			try {
				Conn dbc = new Conn();
				Connection conn = dbc.conn();
				PreparedStatement pst =null;

				String insert_info = "insert into namelist(td,userid,username,change,date) value(?,?,?,?,?)";
				pst = conn.prepareStatement(insert_info);
				pst.setString(1, gp.getTd());
				pst.setInt(2, gp.getUserid());
				pst.setString(3, gp.getUsername());
				pst.setInt(4, gp.getChange());
				pst.setString(5, gp.getDate());
				rs = pst.executeUpdate();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return rs;
		}

}
