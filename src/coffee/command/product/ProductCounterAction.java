package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

public class ProductCounterAction implements CommandProcess {

	public ProductCounterAction() {
		// TODO Auto-generated constructor stub
		
		System.out.println("프로덕 카운터 액션 처리");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
