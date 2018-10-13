package nuc.sw.dangdang.Action;

import com.opensymphony.xwork2.ActionContext;

public class Cal1Action {
	private String num1;
	private String num2;
	private String op;
	private double result;
	private String tip;
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String execute() {
		double number1 = Double.parseDouble(num1);
		double number2 = Double.parseDouble(num2);
		switch(op) {
			case "+":
				result = number1 + number2; break;
			case "-":
				result = number1 - number2; break;
			case "*":
				result = number1 * number2; break;
			case "/":
				if(number2 == 0) {
					tip="除数不能为0，请重新输入！";
					break;
					
				}
				result = number1 / number2; break;
		}
		ActionContext.getContext().getSession().put("op", op);
		ActionContext.getContext().getSession().put("result", result);
		return "success";
		
	}

}
