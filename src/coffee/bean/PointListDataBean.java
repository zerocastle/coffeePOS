package coffee.bean;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PointListDataBean {
	private static PointListDataBean INSTANCE = new PointListDataBean();

	private PointListDataBean() {
		// TODO Auto-generated constructor stub
	}

	private Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}
	
	

}
