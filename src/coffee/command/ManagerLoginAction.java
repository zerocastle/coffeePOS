package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class ManagerLoginAction implements CommandProcess {

	public ManagerLoginAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		System.out.println("id" + id);
		System.out.println("pw" + pw);

		EmployeeDataBean employee = EmployeeDataBean.getINSTANCE();
		int loginType = employee.userCheck(id, pw);
		int result = employee.managerCheck(id, pw);

		if (result == 1) {
			request.getSession().setAttribute("loginSession2", id);
			request.setAttribute("loginType", 1);
		}

		return "/ajaxCome/test.jsp";
	}

}
