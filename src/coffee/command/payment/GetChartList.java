package coffee.command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import coffee.bean.ProductDataBean;
import coffee.commad.inter.CommandProcess;

public class GetChartList implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");		
		ProductDataBean pl = ProductDataBean.getINSTANCE();
		
		JSONArray jsonArray1 = new JSONArray();
		jsonArray1 = pl.checkMonthSum();
		request.setAttribute("mlist", jsonArray1);
		
		
		return "/ajaxCome/test.jsp";
		
	}

}
