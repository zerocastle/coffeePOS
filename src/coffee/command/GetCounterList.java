package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Itemlist;
import coffee.bean.ItemlistDataBean;
import coffee.commad.inter.CommandProcess;

public class GetCounterList implements CommandProcess{
	
	public GetCounterList() {
		// TODO Auto-generated constructor stub
		System.out.println("카운터 리스트 받아 오는 곳");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		ArrayList<Itemlist> list = null;
		Itemlist object = null;
		ItemlistDataBean bean = ItemlistDataBean.getINSTANCE();
		String go = "";
		list = bean.getCounterList();
		
		request.setAttribute("itemList", list);
		
		go = go + "/ele/counterView.jsp";
		
		return go;
	}

}
