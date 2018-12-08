package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class GetPercent implements CommandProcess {

	public GetPercent() {
		// TODO Auto-generated constructor stub
		System.out.println("퍼센트 들고오자 ");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		ProductDataBean bean = ProductDataBean.getINSTANCE();

		float f = bean.getPercent();

		System.out.println("f : " + f);
		request.setAttribute("getPercent", f);
		return "/ajaxCome/test.jsp";
	}

}
