package coffee.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ClientDelete implements CommandProcess {

	public ClientDelete() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String go = "";
		JSONObject personInfo = new JSONObject();
		JSONArray array = new JSONArray();
		String cId = request.getParameter("id");
		System.out.println("delete 아이디 : " + cId);
		int signal = 0;
		ClientDataBean bean = ClientDataBean.getInstance();
		signal = bean.deleteMember(cId);
		System.out.println("delete signal : " + signal);
		if (signal > 0) {
			array.add(signal);
			array.add(cId);
			personInfo.put("name", array);
			request.setAttribute("deleteMember", personInfo);
			go = go + "/ajaxCome/test.jsp";
		} else {
			go = go + "/ele/managerClientView.jsp";
		}
		System.out.println("insertMember : " + personInfo.toString());
		return go;

	}

}
