package coffee.bean2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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

	private Timestamp getDate() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select now()";
		Timestamp now = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				now = rs.getTimestamp(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return now;

	}

	public int payMentInsertAction(int ptUsed, int pMoney, String cId, int pointMoney) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("결제 인서트 부분");
		Random r = new Random();
		int random = r.nextInt(10000);
		String pCode = "c" + random;
		Timestamp pDate = getDate();

		String query = "insert into payment values(?,?,?,?,?)";
		int x = 0;
		try {

			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setTimestamp(2, pDate);
			pstmt.setInt(3, ptUsed);
			pstmt.setInt(4, pMoney);
			pstmt.setString(5, cId);
			x = pstmt.executeUpdate();

			System.out.println("결제 행 : " + x);
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
			this.pointListAction(pCode, cId, pointMoney); // 호출 인서트
			this.updateUserPoint(cId, pMoney, ptUsed, pointMoney); // 클라이언트 업데이트
		}

		return x;

	}

	public void pointListAction(String pCode, String cId, int pointMoney) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("고객 포인트 인서트 부분");
		String query = "insert into pointlist values(?,?,?)";
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pCode);
			pstmt.setString(2, cId);
			pstmt.setInt(3, pointMoney);
			x = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	}

	public void updateUserPoint(String cId, int pMoney, int ptUsed, int pointMoney) {
		// TODO Auto-generated method stub
		System.out.println("업데이트 유저 들어오니??");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int[] array = getPointTotalPayMentMoney(cId); // select 해온다 .
		int cPointTemp = array[0]; // 포인트 금액
		int totalPointTemp = array[1]; // 총 주문 금액

		int cPoint = pointMoney + (cPointTemp - ptUsed);
		int totalPoint = totalPointTemp + pMoney;
		System.out.println("업데이트 : cPoint = " + cPoint);
		System.out.println("업데이트 : totalPoint = " + totalPoint);
		String query = "update client set cPoint=?,totalPoint=? where cId=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cPoint);
			pstmt.setInt(2, totalPoint);
			pstmt.setString(3, cId);
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		System.out.println("업데이트 끝냈니");
	}

	// 포인트 머니 , 총 주문 금액 넘겨주는 역활
	private int[] getPointTotalPayMentMoney(String cId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select cPoint,totalPoint from client where cId = ?";
		int[] forwardInt = new int[2];
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			int index = 0;
			while (rs.next()) {
				forwardInt[0] = rs.getInt(1);
				forwardInt[1] = rs.getInt(2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		System.out.println("넘어가는 인트갑 :" + Arrays.toString(forwardInt));
		return forwardInt;

	}

	public int updatePercent(float percentP) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "update category set percentP =?";
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setFloat(1, percentP);
			x = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
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

	// 포인트 리스트 불러오기
	public ArrayList<PayMent> getPointList(String cId) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		PayMent object = null;
		ArrayList<PayMent> payMent = new ArrayList<PayMent>();

		String query = "select pCode,pDate,pMoney,ptUsed from payment where cId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String pCode = rs.getString("pCode");
				Timestamp pDate = rs.getTimestamp("pDate");
				int pMoney = rs.getInt("pMoney");
				int ptUsed = rs.getInt("ptUsed");
				object = new PayMent();
				object.setpCOde(pCode);
				object.setpDate(pDate);
				object.setpMoney(pMoney);
				object.setPtUsed(ptUsed);

				payMent.add(object);

//				payMent.add()
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
		return payMent;

	}

}
