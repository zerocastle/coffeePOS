package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.bean.Employee;
import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class EmployeeModify implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String eNum = request.getParameter("eNum");
		String ePhone = request.getParameter("ePhone");
		System.out.println("modify 아이디 : " + eNum);
		System.out.println("modify 번호 : " + ePhone);
		int signal = 0;
		EmployeeDataBean bean = EmployeeDataBean.getINSTANCE();
		signal = bean.employeeModify(eNum, ePhone);
		System.out.println("modify signal : " + signal);

		array.add(signal);
		array.add(eNum);
		array.add(ePhone);
		personInfo.put("name", array);
		request.setAttribute("employeeModify", personInfo);
		go = go + "/ajaxCome/test.jsp";
		System.out.println("modifyMember : " + personInfo.toString());
		return go;
	}

}
