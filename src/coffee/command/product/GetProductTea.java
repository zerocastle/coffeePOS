package coffee.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Product;
import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class GetProductTea implements CommandProcess {
	ArrayList<Product> teaList = null;
	ProductDataBean productBean = null;

	public GetProductTea() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("커피프로덕 여기까지 나옴?");
		productBean = ProductDataBean.getINSTANCE();
		teaList = productBean.getTeaList();
		System.out.println("티 리스트 : " + teaList.toString());
		request.getSession().setAttribute("getTeaList", teaList);

		return "/productList/Tea.jsp";
	}
}
