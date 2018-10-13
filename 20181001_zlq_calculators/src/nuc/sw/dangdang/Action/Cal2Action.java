package nuc.sw.dangdang.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import nuc.sw.dangdang.entity.CalEntity;

@SuppressWarnings("serial")
public class Cal2Action extends ActionSupport{
	private CalEntity cal;

	public CalEntity getCal() {
		return cal;
	}

	public void setCal(CalEntity cal) {
		this.cal = cal;
	}
	
	public String execute () throws Exception{
		double num1 = Double.parseDouble(cal.getNum1());
		double num2 = Double.parseDouble(cal.getNum2());
		double result = cal.getResult();
		switch(cal.getOp()) {
			case "+":
				result = num1 + num2; break;
			case "-":
				result = num1 - num2; break;
			case "*":
				result = num1 * num2; break;
			case "/":
				if(num2 == 0) {
					break;
					
				}
				result = num1 / num2; break;
		}
		ActionContext.getContext().getSession().put("op", cal.getOp());
		ActionContext.getContext().getSession().put("result", result);
		return SUCCESS;
		
	}
	
}
