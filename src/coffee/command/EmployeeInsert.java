package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.Employee;
import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class EmployeeInsert implements CommandProcess {

	public EmployeeInsert() {
		// TODO Auto-generated constructor stub
		System.out.println("사원등록 객체");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String eNum = request.getParameter("id");
		String ePhone = request.getParameter("pw");
		String eName = request.getParameter("name");
		String ePayTemp = request.getParameter("pay");
		int ePay = 0;
		System.out.println("ePay : " + ePayTemp);
		try {
			ePay = Integer.parseInt(ePayTemp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		int signal = 0;
		EmployeeDataBean bean = EmployeeDataBean.getINSTANCE();
		Employee ele = new Employee();
		signal = bean.insertEmployee(eNum, ePhone, eName, ePay);
		if (signal > 0) {
			array.add(signal);
			array.add(eNum);
			array.add(ePhone);
			array.add(eName);
			personInfo.put("name", array);
			request.setAttribute("insertEmployee", personInfo);
			go = go + "/ajaxCome/test.jsp";
		} else {
			go = go + "/mng/managerEmployee.jsp";
		}
		System.out.println("직원 삽입 : " + personInfo.toString());
		return go;
	}

}
