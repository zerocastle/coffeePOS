package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Employee;
import coffee.bean.EmployeeDataBean;
import coffee.commad.inter.CommandProcess;

public class getEmployeeListAction implements CommandProcess {
	ArrayList<Employee> employee = null;
	EmployeeDataBean bean = null;

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		bean = EmployeeDataBean.getINSTANCE();
		employee = bean.employeeList();

		request.setAttribute("eleList", employee);

		return "/mng/managerEmployeeView.jsp";
	}

}
