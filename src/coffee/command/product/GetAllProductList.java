package coffee.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.bean.Product;
import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class GetAllProductList implements CommandProcess {

	public GetAllProductList() {
		// TODO Auto-generated constructor stub
		System.out.println("상품 전체를 들고오는 클래스 ");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		ArrayList<Product> productList = null;
		ProductDataBean bean = ProductDataBean.getINSTANCE();
		productList = bean.getAllProduct();

		HttpSession session = request.getSession();

		session.setAttribute("allProductList", productList);

		return "/mng/managerMenu.jsp";
	}

}
