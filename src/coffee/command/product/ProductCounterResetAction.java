package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.commad.inter.CommandProcess;

public class ProductCounterResetAction implements CommandProcess {

	
	public ProductCounterResetAction() {
		// TODO Auto-generated constructor stub
		
		System.out.println("카운터 뷰 리셋 객체");
	}
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		ProductCounterAction.please.clear();
		ProductCounterAction.totalAmount = 0;
		HttpSession session = (HttpSession) request.getSession();
		session.removeAttribute("counterList");

		return "/coffeePOS/index.jsp";
	}

}
