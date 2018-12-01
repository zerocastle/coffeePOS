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

public class ManagerListRefresh implements CommandProcess {
	ArrayList<Client> client = null;
	ClientDataBean bean = null;
	public ManagerListRefresh() {
		// TODO Auto-generated constructor stub
		System.out.println("들어오냐??");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		bean = ClientDataBean.getInstance();
		client = bean.clientList(); // arrayLIst가  담긴 객체
		System.out.println("찍혀줘");
		//json 파일 만들어주자 ...
		JSONObject personInfo = new JSONObject();
		JSONArray clientList = new JSONArray();
		
		for(int i = 0; i < client.size(); i++) {
			clientList.add(client.get(i).getcId());
			clientList.add(client.get(i).getcPhone());
			clientList.add(client.get(i).getcName());
			clientList.add(client.get(i).getcPoint());
			clientList.add(client.get(i).getTotalPoint());
			personInfo.put("clientList", clientList);
			
		}

		try {
			String Folder = "/mng/data";
			ServletContext context = request.getServletContext();
			String realPath = context.getRealPath(Folder);
			System.out.println("realPath : " + realPath);
			System.out.println("context : " + context);
			System.out.println("result : " + realPath + "\\list.json");
			FileWriter file = new FileWriter(realPath+"\\list.json"); // 상대경로 될까 
			FileWriter file2 = new FileWriter("c:\\\\test.json");
			file.write(personInfo.toJSONString()); // json String 으로 변환하여 써둔다는것다
			file2.write(personInfo.toJSONString());
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("잘 전달이 되었니.." + personInfo);
		return "/mng/mangerEmployeeView.jsp";
		
	}

}
