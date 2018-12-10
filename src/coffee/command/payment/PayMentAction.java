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
		int pMoney = 0;
		int pointMoney = 0;
		int totalMoney = 0;

		String ptUsedTemp = request.getParameter("ptUsed");
		String pMoneyTemp = request.getParameter("pMoney");
		String pointMoneyTemp = request.getParameter("pointMoney");
		String totalMoneyTemp = request.getParameter("totalMoney");
		
		System.out.println("exception : " + ptUsedTemp);
		System.out.println("exception : " + pMoneyTemp);
		System.out.println("exception pMoneyTemp : " + pMoneyTemp);
		System.out.println("exception totalMoneyTemp : " + totalMoneyTemp);

		if (ptUsedTemp.equals("")) {
			ptUsed = 0;
		} else
			ptUsed = Integer.parseInt(request.getParameter("ptUsed"));

		if (pMoneyTemp.equals("")) {
			pMoney = 0;
		} else
			pMoney = Integer.parseInt(request.getParameter("pMoney"));

		if (pointMoneyTemp.equals("")) {
			pointMoney = 0;
		} else
			pointMoney = Integer.parseInt(request.getParameter("pointMoney"));
		String cId = request.getParameter("cId");
		System.out.println("exception : " + cId);
		if (cId.equals("")) {
			ptUsed = 0;
			pointMoney = 0;
			totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
			pMoney = totalMoney;
			// 비회원이 구매 했을때 total money에서 끌고와 결제한다.
		}
		System.out.println("값 넘어오니 =====> " + ptUsed + " ," + pMoney + " ," + cId + " ," + pointMoney);
		int x = bean.payMentInsertAction(ptUsed, pMoney, cId, pointMoney);
		request.setAttribute("paymentSignal", x);
		return "/ajaxCome/test.jsp";
	}

}
