package coffee.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmployeeDataBean {

	private static EmployeeDataBean INSTANCE = new EmployeeDataBean();

	private EmployeeDataBean() {
		// TODO Auto-generated constructor stub
	}

	public static EmployeeDataBean getINSTANCE() {
		return INSTANCE;
	}

	private Connection getConnection() throws Exception {
		// TODO Auto-generated method stub

		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

		return ds.getConnection();
	}

	public int userCheck(String eNum, String ePhone) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		String query = "select * from employee where eNum = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbePhone = rs.getString("ePhone");
				String rank = rs.getString("rank");
				if (dbePhone.equals(ePhone) && (rank.equals("0"))) {
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

	// 관리자 로그인
	public int managerCheck(String eNum, String ePhone) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		String query = "select * from employee where eNum = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbePhone = rs.getString("ePhone");
				String rank = rs.getString("rank");
				if (dbePhone.equals(ePhone) && (rank.equals("1"))) {
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

	// 사원 리스트
	public ArrayList<Employee> employeeList() {
		// TODO Auto-generated method stub
		int counter = 1; // 일딴 보류
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from employee";
		ArrayList<Employee> ele = new ArrayList<Employee>();
		Employee object = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				object = new Employee();
				String eNum = rs.getString("eNum");
				String ePhone = rs.getString("ePhone");
				String eName = rs.getString("eName");
				int ePay = rs.getInt("ePay");
				String rankTemp = rs.getString("rank");
				String rank = "";
				if (Integer.parseInt(rankTemp) == 0) {
					rank = rank + "사원";
				} else
					rank = rank + "관리자";
				object.seteNum(eNum);
				object.setePhone(ePhone);
				object.seteName(eNum);
				object.setePay(ePay);
				object.setRank(rank);

				ele.add(object);
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
		return ele;
	}

	// 사원 등록
	public int insertEmployee(String eNum, String ePhone, String eName, int ePay) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		String defaultRank = "0";
		String query = "insert into employee(eNum,ePhone,eName,ePay,rank) values(?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			pstmt.setString(2, ePhone);
			pstmt.setString(3, eName);
			pstmt.setInt(4, ePay);
			pstmt.setString(5, defaultRank);
			x = pstmt.executeUpdate();
			if (x > 0) {
				x = 1;
			} else
				x = 0;

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

	// 사원 삭제
	public int deleteEmployee(String eNum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		String query = "delete from employee where eNum = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			x = pstmt.executeUpdate();
			if (x > 0) {
				x = 1;
			} else
				x = 0;

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
	
	//사원 있는지 확인
	public int employeeUserCheck(String eNum) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		int x = -1;
		System.out.println("enum" + eNum);
		String query = "select * from employee where eNum=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			set = pstmt.executeQuery();
			if(set.next()) {
				x = 1; //현제 아이디 값이 있음
			}else
				x = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

	}
	
	public int employeeModify(String eNum , String ePhone) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		int x = 0;
		String query = "update employee set ePhone = ? where cId = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, eNum);
			pstmt.setString(2, ePhone);
			x = pstmt.executeUpdate();

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
				if (set != null) {
					set.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return x;

	}

}
