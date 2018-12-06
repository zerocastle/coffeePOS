package coffee.command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class ProductCounterAction implements CommandProcess {
//	public static ArrayList<Product> COUNTERVIEW = new ArrayList<Product>();
//	public Product product = null;
	public static ArrayList<String[]> please = new ArrayList<String[]>();
	public static int totalAmount = 0;

	public ProductCounterAction() {
		// TODO Auto-generated constructor stub

		System.out.println("프로덕 카운터 액션 처리");
//		product = new Product();
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pName = request.getParameter("pName");
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		String[] str = new String[3];

		ProductDataBean bean = ProductDataBean.getINSTANCE();
		str = bean.getCounterViewList(pName); 

		for (int i = 0; i < str.length; i++) {
			System.out.println("str : " + str[i]);
		}

		please.add(str);
		HttpSession session = request.getSession();
		session.setAttribute("counterList", please);
		return "/ele/counterView.jsp";
	}

}
