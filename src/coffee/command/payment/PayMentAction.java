package coffee.command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coffee.bean2.PayMentDataBean;
import coffee.commad.inter.CommandProcess;

public class PayMentAction implements CommandProcess {

	public PayMentAction() {
		// TODO Auto-generated constructor stub
		System.out.println("결제");
	}

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		PayMentDataBean bean = PayMentDataBean.getINSTANCE();
		int ptUsed = 0;
		try {
			ptUsed = Integer.parseInt(request.getParameter("ptUsed"));
		} catch (Exception e) {
			e.printStackTrace();
			ptUsed = 0;
		}
		int pMoney = Integer.parseInt(request.getParameter("pMoney"));
		String cId = request.getParameter("cId");
		int pointMoney = Integer.parseInt(request.getParameter("pointMoney"));
		System.out.println("값 넘어오니 = " + ptUsed + " ," + pMoney + " ," + cId + " ," + pointMoney);
		int x = bean.payMentInsertAction(ptUsed, pMoney, cId, pointMoney);
		request.setAttribute("paymentSignal", x);
		return "/ajaxCome/test.jsp";
	}

}
