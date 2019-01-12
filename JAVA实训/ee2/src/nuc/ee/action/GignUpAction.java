package nuc.ee.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.ee.model.GignUp;

@SuppressWarnings("serial")
public class GignUpAction extends ActionSupport implements ModelDriven<GignUp>{
	GignUp gu = new GignUp();
	
	public String execute() {
		
		return "success";
	}
		
	@Override
	public GignUp getModel() {
		// TODO Auto-generated method stub
		return gu;
	}

}
