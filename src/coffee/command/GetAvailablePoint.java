package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class GetAvailablePoint implements CommandProcess {

	public GetAvailablePoint() {
		// TODO Auto-generated constructor stub
		System.out.println("사용 가능 한 포인트 들고오기 ");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		ClientDataBean bean = ClientDataBean.getInstance();
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		String cId = request.getParameter("cId");
		int point = bean.getAvailablePoint(cId);
		array.add(point);
		object.put("availablePoint", array);
		request.setAttribute("availablePoint", object);
		return "/ajaxCome/test.jsp";
	}

}
