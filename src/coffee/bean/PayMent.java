package coffee.bean;

import java.sql.Timestamp;

public class PayMent {
	public PayMent() {
		// TODO Auto-generated constructor stub
	}

	private String pCode;
	private Timestamp pDate;
	private int ptUsed;
	private int pMoney;
	private int pBonus;
	private String cId;
	private String eNum;

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public int getPtUsed() {
		return ptUsed;
	}

	public void setPtUsed(int ptUsed) {
		this.ptUsed = ptUsed;
	}

	public int getpMoney() {
		return pMoney;
	}

	public void setpMoney(int pMoney) {
		this.pMoney = pMoney;
	}

	public int getpBonus() {
		return pBonus;
	}

	public void setpBonus(int pBonus) {
		this.pBonus = pBonus;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String geteNum() {
		return eNum;
	}

	public void seteNum(String eNum) {
		this.eNum = eNum;
	}

}
