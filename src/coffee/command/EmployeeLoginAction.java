package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class EmployeeLoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stud
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("들어온 아이디는 " + id);
		EmployeeDataBean employee = EmployeeDataBean.getINSTANCE();
		int loginType = employee.userCheck(id, pw);
		if(loginType == 1) {
			request.getSession().setAttribute("loginSession", id);
			request.setAttribute("loginType",1);
		}
		System.out.println("loginType : " + loginType);
		

		return "/ajaxCome/test.jsp"; //일딴 이 자식은 이렇게 넘기자 
	}

}
