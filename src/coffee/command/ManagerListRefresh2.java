package coffee.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import coffee.bean.Client;
import coffee.bean.ClientDataBean;
import coffee.commad.inter.CommandProcess;

public class ManagerListRefresh2 implements CommandProcess {
	ArrayList<Client> client = null;
	ClientDataBean bean = null;

	public ManagerListRefresh2() {
		// TODO Auto-generated constructor stub
		System.out.println("들어오냐??");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		bean = ClientDataBean.getInstance();
		client = bean.clientList(); // arrayLIst가 담긴 객체
		System.out.println("찍혀줘");

		// 일딴 이걸로 바꾸자
		request.setAttribute("clientList", client);
		System.out.println("객체" + client);
		return "/ele/mangerEmployeeView.jsp";

	}

}