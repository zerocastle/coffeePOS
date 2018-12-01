package coffee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ClientDataBean {

	private static ClientDataBean instance = new ClientDataBean();

	private ClientDataBean() {

	}

	public static ClientDataBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}

	public int userCheck(String cId, String cPhone) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		String query = "select * from client where cId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbePhone = rs.getString("cPhone");
				if (dbePhone.equals(cPhone)) {
					x = 1; // 로그인성공
				} else
					x = -1; // 로그인 실패
			} else
				x = 0; // 그런회원 없음

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return x;
	}

	public ArrayList<Client> clientList() {
		// TODO Auto-generated method stub
		int counter = 1; // 일딴 보류
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from client";
		ArrayList<Client> client = new ArrayList<Client>();
		Client object = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				object = new Client();
				String cId = rs.getString("cId");
				String cPhone = rs.getString("cPhone");
				String cName = rs.getString("cName");
				int point = rs.getInt("cPoint");
				int totalPoint = rs.getInt("totalPoint");

				object.setcId(cId);
				object.setcPhone(cPhone);
				object.setcName(cName);
				object.setcPoint(point);
				object.setTotalPoint(totalPoint);

				client.add(object);
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
		return client;
	}

}
