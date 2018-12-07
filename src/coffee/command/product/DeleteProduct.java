package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class DeleteProduct implements CommandProcess {

	public DeleteProduct() {
		// TODO Auto-generated constructor stub
		System.out.println("상품 리스트 삭제 객체");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int x = 0;
		String go = "";
		String pName = request.getParameter("pName");
		System.out.println("pName 값 가지고 왔니" + pName);
		ProductDataBean bean = ProductDataBean.getINSTANCE();
		x = bean.deleteProduct(pName);
		System.out.println("x : " + x);
		request.setAttribute("deleteProductName", x);
		return "/ajaxCome/test.jsp";
	}

}
