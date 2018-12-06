package coffee.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Product;
import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class GetProductBread implements CommandProcess {
	ArrayList<Product> breadList = null;
	ProductDataBean productBean = null;
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("커피프로덕 여기까지 나옴?");
		productBean = ProductDataBean.getINSTANCE();
		breadList = productBean.getBreadList();
		System.out.println("빵 리스트 : " + breadList.toString());
		request.getSession().setAttribute("getBreadList", breadList);

		return "/productList/bread.jsp ";
	}

}
