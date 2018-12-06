package coffee.command.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean.Itemlist;
import coffee.bean.ItemlistDataBean;
import coffee.commad.inter.CommandProcess;

public class CoffeeAddList implements CommandProcess {

	public CoffeeAddList() {
		// TODO Auto-generated constructor stub
		System.out.println("커피추가 리스트");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pName = request.getParameter("pName");
		int pPrice = Integer.parseInt(request.getParameter("pPrice"));
		Itemlist itemlist = null;
		ItemlistDataBean dataBean = ItemlistDataBean.getINSTANCE();
		int signal = dataBean.addList(pName, pPrice);
		String go = "";
		
		if(signal == 1) {
			request.setAttribute("itemAdd", signal);
			go = go + "/ajaxCome/test.jsp";
		}
		
		return go;
	}

}
