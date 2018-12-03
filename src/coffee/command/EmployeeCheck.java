package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class EmployeeCheck implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		EmployeeDataBean bean = EmployeeDataBean.getINSTANCE();
		int signal = bean.employeeUserCheck(id);
		System.out.println("사원 check : " + signal);

		request.setAttribute("employeeUserCheck", signal);

		return "/ajaxCome/test.jsp";
	}

}
