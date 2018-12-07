package nuc.sw.dangdang.action;

import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;

@SuppressWarnings("serial")
public class BookIdSelectAction extends ActionSupport implements ModelDriven<Object>{
	private int id;
	DataDao dao = new DataDao();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	List<Book> abookList = new ArrayList<Book>();

	public List<Book> getAbookList() {
		return abookList;
	}

	public void setAbookList(List<Book> abookList) {
		this.abookList = abookList;
	}

	public String BookIdSelectMethod() {
//		System.out.println("aa"+id);
		abookList = dao.book_id_select(id);
//		System.out.println(abookList);
		
		return "bookIdSelectOK";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
