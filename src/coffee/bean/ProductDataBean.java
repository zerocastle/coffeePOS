package coffee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDataBean {
	private static ProductDataBean INSTANCE = new ProductDataBean();

	private ProductDataBean() {
		// TODO Auto-generated constructor stub
	}

	public static ProductDataBean getINSTANCE() {
		return INSTANCE;
	}

	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}

	public ArrayList<Product> getCoffeeList() {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Product> productList = new ArrayList<Product>();
		Product product = null;
		String query = "select * from product where ct_code='cf'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				String pCode = rs.getString("pCode");
				String pName = rs.getString("pName");
				String pPath = rs.getString("pPath");
				int pPrice = rs.getInt("pPrice");
				String ct_code = rs.getString("ct_code");

				product.setpCode(pCode);
				product.setpName(pName);
				product.setpPath(pPath);
				product.setpPrice(pPrice);
				product.setCt_code(ct_code);

				productList.add(product);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		System.out.println("프로덕 커피 리스트 " + productList.toString() );
		return productList;

	}

}
