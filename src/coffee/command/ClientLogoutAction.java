package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.commad.inter.CommandProcess;

public class ClientLogoutAction implements CommandProcess{
	
	public ClientLogoutAction() {
		// TODO Auto-generated constructor stub
		System.out.println("사용자 로그아웃 부분");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		session.removeAttribute("clientLogincId");
		return "";
	}
	
	

}
