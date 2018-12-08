package coffee.bean2;

import java.sql.Timestamp;

public class PayMent {
	public PayMent() {
		// TODO Auto-generated constructor stub
	}

	private String pCOde;
	private Timestamp pDate;
	private int ptUsed;
	private int pMoney;
	private String cId;

	public String getpCOde() {
		return pCOde;
	}

	public void setpCOde(String pCOde) {
		this.pCOde = pCOde;
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

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public PayMent(String pCOde, Timestamp pDate, int ptUsed, int pMoney, String cId) {
		super();
		this.pCOde = pCOde;
		this.pDate = pDate;
		this.ptUsed = ptUsed;
		this.pMoney = pMoney;
		this.cId = cId;
	}

}
