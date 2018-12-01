package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ClientInsert implements CommandProcess {

	public ClientInsert() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String cId = request.getParameter("id");
		String cPhone = request.getParameter("pw");
		String cName = request.getParameter("name");
		int signal = 0;
		ClientDataBean bean = ClientDataBean.getInstance();
		signal = bean.insertClient(cId, cPhone, cName);
		if (signal > 0) {
			array.add(signal);
			array.add(cId);
			array.add(cPhone);
			array.add(cName);
			personInfo.put("name", array);
			request.setAttribute("insertMember", personInfo);
			go = go + "/ajaxCome/test.jsp";
		} else {
			go = go + "/ele/managerClientView.jsp";
		}
		System.out.println("insertMember : " + personInfo.toString());
		return go;

	}

}
