package coffee.command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

public class PayMentAction implements CommandProcess {

	public PayMentAction() {
		// TODO Auto-generated constructor stub
		System.out.println("결제");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
