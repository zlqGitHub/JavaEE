package nuc.sw.dangdang.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.dao.DataDao;
import nuc.sw.dangdang.entity.Book;
import nuc.sw.dangdang.entity.MyBorrow;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport implements ModelDriven<MyBorrow> {
	MyBorrow mb = new MyBorrow();
	DataDao dao = new DataDao();
	public String tip;   //错误提示
	public String bookname;
	public String error;
	public MyBorrow getMb() {
		return mb;
	}

	public void setMb(MyBorrow mb) {
		this.mb = mb;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String OrderMethod() {
		int i = dao.isBorrowBook(mb.getStudent_no(), mb.getBook_id());
		List<Book> book = dao.book_id_select(mb.getBook_id());
//		System.out.println(mb.getBook_id());
//		System.out.println(book.iterator().next().getNum());     //书籍的数量
		int num = book.iterator().next().getNum();
		if(num == 0) {
			tip = "true";
//			System.out.println(tip);
			bookname = mb.getBook_name();
			error = "借阅失败！库存为0！";
			return "orderFail";
		}
		else if(i != 1) {
			dao.orderBorrow(mb);    //将借书信息插入数据库
			num = num - 1;
			dao.changeNum(mb.getBook_id(), num);
			return "orderOK";
		}
		else {
			tip = "true";
//			System.out.println(tip);
			bookname = mb.getBook_name();
			error = "借阅失败！";
			return "orderFail";
		}
	}

	@Override
	public MyBorrow getModel() {
		// TODO Auto-generated method stub
		return mb;
	}

}
