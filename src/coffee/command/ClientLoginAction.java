package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ClientLoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		ClientDataBean client = ClientDataBean.getInstance();

		int x = client.userCheck(id, pw);
		request.setAttribute("ClientLoginACtion", x);
		return "/ajaxCome/test.jsp";
	}

}
