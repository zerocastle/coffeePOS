package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class SearchClientAction implements CommandProcess {

	public SearchClientAction() {
		// TODO Auto-generated constructor stub
		System.out.println("고객 검색하는 부분");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String str[] = null;
		String cId = request.getParameter("cId");
		ClientDataBean bean = ClientDataBean.getInstance();
		str = bean.searchcId(cId);
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();

		for (int i = 0; i < str.length; i++) {
			array.add(str[i]);
		}
		object.put("cId", array);
		request.setAttribute("clientSearchCounter", object);
		System.out.println("고객 검색 json : " + object.toString());
		return "/ajaxCome/test.jsp";
	}

}
