package coffee.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coffee.bean2.PayMent;
import coffee.bean2.PayMentDataBean;
import coffee.commad.inter.CommandProcess;

public class ShowPointList implements CommandProcess {

	public ShowPointList() {
		// TODO Auto-generated constructor stub
		System.out.println("고객 포인트 리스트");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String cId = request.getParameter("cId");
		System.out.println("cId : " + cId);
		ArrayList<PayMent> list = new ArrayList<PayMent>();
		PayMentDataBean bean = PayMentDataBean.getINSTANCE();
		list = bean.getPointList(cId);
		System.out.println("list : " + list.toString());
//		request.setAttribute("clientInformationList", list);
		HttpSession session = request.getSession();
		session.setAttribute("clientInformationList", list);
		return "/clt/clientChartView.jsp";
	}

}
