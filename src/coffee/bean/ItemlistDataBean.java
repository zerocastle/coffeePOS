package coffee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ItemlistDataBean {
	private static ItemlistDataBean INSTANCE = new ItemlistDataBean();

	private ItemlistDataBean() {
		// TODO Auto-generated constructor stub
	}

	public static ItemlistDataBean getINSTANCE() {
		return INSTANCE;
	}

	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}

	public void addList(String pName , int pPrice) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	
	}

}
