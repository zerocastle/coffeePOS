package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.commad.inter.CommandProcess;

public class Logout implements CommandProcess {
	/*
	 * (non-Javadoc)
	 * @see coffee.commad.inter.CommandProcess#requestPro(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * 로그 아웃
	 */

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		return "/index.jsp";
	}

}
