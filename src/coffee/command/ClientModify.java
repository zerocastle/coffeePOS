package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ClientModify implements CommandProcess {

	public ClientModify() {
		
		System.out.println("고객 수정");

	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String cId = request.getParameter("id");
		String cPhone = request.getParameter("phone");
		System.out.println("modify 아이디 : " + cId);
		System.out.println("modify 번호 : " + cPhone);
		int signal = 0;
		ClientDataBean bean = ClientDataBean.getInstance();
		signal = bean.clientModify(cId, cPhone);
		System.out.println("modify signal : " + signal);
		if (signal > 0) {
			array.add(signal);
			array.add(cId);
			array.add(cPhone);
			personInfo.put("name", array);
			request.setAttribute("clientModify", personInfo);
			go = go + "/ajaxCome/test.jsp";
		} else {
			go = go + "/ele/managerClientView.jsp";
			System.out.println("aa");
		}
		System.out.println("modifyMember : " + personInfo.toString());
		return go;
	}
}
