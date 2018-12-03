package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class EmployeeDelete implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String eNum = request.getParameter("id");
		System.out.println("delete 아이디 : " + eNum);
		int signal = 0;
		EmployeeDataBean bean = EmployeeDataBean.getINSTANCE();
		signal = bean.deleteEmployee(eNum);
		System.out.println("delete signal : " + signal);
		if (signal > 0) {
			array.add(signal);
			array.add(eNum);
			personInfo.put("name", array);
			request.setAttribute("deleteMember", personInfo);
			go = go + "/ajaxCome/test.jsp";
		} else {
			go = go + "/mng/managerEmployeeView.jsp";
		}
		System.out.println("사원 삭제 : " + personInfo.toString());
		return go;
	}

}
