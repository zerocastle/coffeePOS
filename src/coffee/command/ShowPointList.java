package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.commad.inter.CommandProcess;

public class ShowPointList implements CommandProcess{
	
	public ShowPointList() {
		// TODO Auto-generated constructor stub
		System.out.println("고객 포인트 리스트");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
