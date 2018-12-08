package coffee.bean2;

public class PointList {

	private String pCode;
	private String cId;
	private int pointMoney;

	public PointList() {
		// TODO Auto-generated constructor stub
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(int String) {
		this.pCode = pCode;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public int getPointMoney() {
		return pointMoney;
	}

	public void setPointMoney(int pointMoney) {
		this.pointMoney = pointMoney;
	}

	public PointList(String pCode, String cId, int pointMoney) {
		super();
		this.pCode = pCode;
		this.cId = cId;
		this.pointMoney = pointMoney;
	}

}
