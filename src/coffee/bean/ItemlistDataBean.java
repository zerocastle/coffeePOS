package coffee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

	public int addList(String pName, int pPrice) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "insert into itemlist(pName,pPrice) values(?,?)";
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			x = pstmt.executeUpdate();
			if (x > 0) {
				x = 1; // 추가
			} else
				x = 0; // 추가실패

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return x;
	}
	
	public ArrayList<Itemlist> getCounterList() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select pName , pPrice from itemlist";
		ArrayList<Itemlist> itemList = new ArrayList<Itemlist>();
		Itemlist object = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				object = new Itemlist();
				object.setpName(rs.getString("pName"));
				object.setPrice(rs.getInt("pPrice"));
				itemList.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return itemList;
	}

}
