package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ClientCheck implements CommandProcess {

	public ClientCheck() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		ClientDataBean bean = ClientDataBean.getInstance();
		int signal = bean.clientUserCheck(id);
		System.out.println("클라이언트 check : " + signal);
		request.setAttribute("clientUserCheck", signal);

		return "/ajaxCome/test.jsp";
	}

}
