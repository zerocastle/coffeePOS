package coffee.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Product;
import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class getProductCoffee implements CommandProcess {
	ArrayList<Product> coffeeList = null;
	ProductDataBean productBean = null;

	public getProductCoffee() {
		// TODO Auto-generated constructor stub
		System.out.println("커피 프로덕 찍히냐??");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("커피프로덕 여기까지 나옴?");
		productBean = ProductDataBean.getINSTANCE();
		coffeeList = productBean.getCoffeeList();
		System.out.println("커피 리스트 : " + coffeeList.toString());
		request.getSession().setAttribute("getCoffeeList", coffeeList);

		return "/productList/coffee.jsp";
	}

}
