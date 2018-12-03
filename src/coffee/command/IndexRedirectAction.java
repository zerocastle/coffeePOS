package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

public class IndexRedirectAction implements CommandProcess {

	public IndexRedirectAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return "/index.jsp";
	}

}
