package coffee.command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean2.PayMentDataBean;
import coffee.commad.inter.CommandProcess;

public class UpdatePercentAction implements CommandProcess{
	
	public UpdatePercentAction() {
		// TODO Auto-generated constructor stub
		System.out.println("적립률 관리");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		PayMentDataBean bean = PayMentDataBean.getINSTANCE();
		float percentP = Float.parseFloat(request.getParameter("percentP"));
		int signal = bean.updatePercent(percentP);
		
		request.setAttribute("percentP", signal);
		JSONObject object =  new JSONObject();
		JSONArray array = new JSONArray();
		
		array.add(percentP);
		array.add(signal);
		
		object.put("percentP", array);
		return "/ajaxCome/test.jsp";
	}
	
	

}
