package nuc.sw.dangdang.Action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import nuc.sw.dangdang.entity.CalEntity;

public class Cal3Action implements Action, ModelDriven<CalEntity> {
	private CalEntity model = new CalEntity();

	@Override
	public CalEntity getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		double num1 = Double.parseDouble(getModel().getNum1());
		double num2 = Double.parseDouble(getModel().getNum2());
		double result = getModel().getResult();
		String tip = getModel().getTip();
		switch(getModel().getOp()) {
			case "+":
				result = num1 + num2; break;
			case "-":
				result = num1 - num2; break;
			case "*":
				result = num1 * num2; break;
			case "/":
				if(num2 == 0) {
					tip="除数不能为0，请重新输入！";
					break;
				}
				result = num1 / num2; break;
		}
		
		ActionContext.getContext().getSession().put("tip", tip);
		ActionContext.getContext().getSession().put("result", result);
		return SUCCESS;
	}

}
