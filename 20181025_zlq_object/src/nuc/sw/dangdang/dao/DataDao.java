package nuc.sw.dangdang.dao;

import java.sql.*;
import java.util.*;

import nuc.sw.dangdang.conn.Conn;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.entity.MyBorrow;
import nuc.sw.dangdang.entity.MyInfo;
import nuc.sw.dangdang.entity.Student;
import nuc.sw.dangdang.entity.User;

public class DataDao {
	//***********************ѧ��ע��*************************
	//1����ѧ�����ݱ��в�ѯ�Ƿ��и�ѧ��,�Ƿ����ע������
	public int stu_select(Student stu) {
		ResultSet rs = null;
		int i = 0;
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.getConn();
			PreparedStatement pst = null;
			String select = "select * from student_no where student_no = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, stu.getStudent_no());
			rs = pst.executeQuery();
//			System.out.println(rs);
			if(rs.next()) {   //�����ѯ��i++
				i++;
			}
//			System.out.println(i);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
		return i;
	}
	
	//��ע����в�ѯ������ѧ���Ƿ��Ѿ�ע���
	public int regist_select(Student stu) {
		ResultSet rs = null;
		int i = 0;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.getConn();
//			System.out.println(conn);
			PreparedStatement pst =null;
			String select = "select * from student where student_no = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, stu.getStudent_no());
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
	
	//3��ע��д����Ϣ
	public int stu_insert(Student stu,String path) {
		int rs = 0;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.getConn();
//			System.out.println(conn);
			PreparedStatement pst =null;
			String insert = "insert into student(student_no,name,password,sex,age,telphone,department,icon) values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(insert);
			pst.setString(1, stu.getStudent_no());
			pst.setString(2, stu.getName());
			pst.setString(3, stu.getPassword());
			pst.setString(4, stu.getSex());
//			System.out.println(stu.getSex());
			pst.setInt(5, stu.getAge());
			pst.setString(6, stu.getTelphone());
			pst.setString(7, stu.getDepartment());
			pst.setString(8, path);
			
			rs = pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	//*********************ѧ����¼*******************
	//�ж��˺š������Ƿ���ȷ
	public int login_select(User user) {
		ResultSet rs = null;
		int i = 0;
		try {
			Conn dbc = new Conn();   
			Connection conn = dbc.getConn();
//			System.out.println(conn);
			PreparedStatement pst =null;
			String select = "select * from student where student_no = ? and password = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, user.getStudent_no());
			pst.setString(2, user.getPassword());
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
	
	//**********************��ѯ�鼮����**************************
	//1����ѯ�����鼮
	public List<Book> books_select() {
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.getConn();
			PreparedStatement pst =null;
			String books_select = "select * from books";
			pst = conn.prepareStatement(books_select);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getInt(1));
				book.setBook_name(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setIcon(rs.getString(5));
				book.setIntroduction(rs.getString(6));
				book.setType(rs.getString(7));
				book.setNum(rs.getInt(8));
				list.add(book);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//2��������type��ѯ�鼮
		public List<Book> books_type_select(String type) {
			ResultSet rs = null;
//			System.out.println("ss"+type);
			List<Book> list = new ArrayList<Book>();
			try {
				Conn dbc = new Conn();
				Connection conn = dbc.getConn();
				PreparedStatement pst =null;
				String books_type_select = "select * from books where type = ?";
				pst = conn.prepareStatement(books_type_select);
				pst.setString(1, type);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					Book book = new Book();
					book.setBook_id(rs.getInt(1));
					book.setBook_name(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPublisher(rs.getString(4));
					book.setIcon(rs.getString(5));
					book.setIntroduction(rs.getString(6));
					book.setType(rs.getString(7));
					book.setNum(rs.getInt(8));
					list.add(book);
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		//3��������book_name��ѯ�鼮
				public List<Book> book_name_select(String book_name) {
					ResultSet rs = null;
					List<Book> list = new ArrayList<Book>();
					try {
						Conn dbc = new Conn();
						Connection conn = dbc.getConn();
						PreparedStatement pst =null;
						//ģ����ѯ��ͨ���ؼ��ֲ�ѯ
						String books_select = "select * from books where book_name LIKE ?";
						pst = conn.prepareStatement(books_select);
						pst.setString(1, "%"+book_name+"%");
						rs = pst.executeQuery();
						
						while(rs.next()) {
							Book book = new Book();
							book.setBook_id(rs.getInt(1));
							book.setBook_name(rs.getString(2));
							book.setAuthor(rs.getString(3));
							book.setPublisher(rs.getString(4));
							book.setIcon(rs.getString(5));
							book.setIntroduction(rs.getString(6));
							book.setType(rs.getString(7));
							book.setNum(rs.getInt(8));
							list.add(book);
						}
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return list;
				}
				
				
	//4����book_idȥ��
	public List<Book> book_id_select(int id){
		ResultSet rs = null;
		List<Book> aBookList = new ArrayList<Book>();
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.getConn();
			PreparedStatement pst = null;
			String book_id_select = "select * from books where book_id = ?";
			pst = conn.prepareStatement(book_id_select);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getInt(1));
				book.setBook_name(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setIcon(rs.getString(5));
				book.setIntroduction(rs.getString(6));
				book.setType(rs.getString(7));
				book.setNum(rs.getInt(8));
				aBookList.add(book);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return aBookList;	
		
	}
	
	
	
	
	//*********************�ҵ���Ϣ��ѯ*************************
	//1���ҵĸ�����Ϣ
	public List<MyInfo> myInfo_select(int student_no){
		ResultSet rs = null;
		List<MyInfo> list = new ArrayList<MyInfo>();
		try {
			Conn dbc = new Conn();
			Connection conn = dbc.getConn();
			PreparedStatement pst =null;
			String myInfo_select = "select * from student where student_no = ?";
			pst = conn.prepareStatement(myInfo_select);
			pst.setInt(1, student_no);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				MyInfo myI = new MyInfo();
				myI.setId(rs.getInt(1));
				myI.setStudent_no(rs.getInt(2));
				myI.setPassword(rs.getString(3));
				myI.setName(rs.getString(4));
				myI.setSex(rs.getString(5));
				myI.setAge(rs.getInt(6));
				myI.setTelphone(rs.getString(7));
				myI.setDepartment(rs.getString(8));
				myI.setIcon(rs.getString(9));
				list.add(myI);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//2���ҵĽ������
		public List<MyBorrow> myBorrow_select(int student_no){
			ResultSet rs = null;
			List<MyBorrow> list = new ArrayList<MyBorrow>();
			try {
				Conn dbc = new Conn();
				Connection conn = dbc.getConn();
				PreparedStatement pst =null;
				String borrow_select = "select * from book_borrow_info where student_no = ?";
				pst = conn.prepareStatement(borrow_select);
				pst.setInt(1, student_no);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					MyBorrow myB = new MyBorrow();
					myB.setStudent_no(rs.getInt(1));
					myB.setBook_id(rs.getInt(2));
					myB.setBook_name(rs.getString(3));
					myB.setType(rs.getString(4));
					myB.setTelphone(rs.getString(5));
					myB.setData(rs.getString(6));
					list.add(myB);
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
