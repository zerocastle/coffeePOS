package coffee.bean;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PayMentDataBean {
	private static PayMentDataBean INSTANCE = new PayMentDataBean();

	public PayMentDataBean() {
		// TODO Auto-generated constructor stub
	}

	public static PayMentDataBean getINSTANCE() {
		return INSTANCE;
	}
	
	private Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}
	
	public void payMentInsertAction() {
		// TODO Auto-generated method stub
		
		

	}

}
