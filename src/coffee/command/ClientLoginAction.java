package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

public class ClientLoginAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String id = request.getParameter("cId");
		String pw = request.getParameter("cPw");
		
		
		return "/clt/loginView.jsp";
	}

}
