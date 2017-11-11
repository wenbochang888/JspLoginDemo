package com.po;

public class InResposRecord {

	String id;
	String inTime;
	String inCompany;
	String inName;
	int num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getInCompany() {
		return inCompany;
	}

	public void setInCompany(String inCompany) {
		this.inCompany = inCompany;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "InResposRecord [id=" + id + ", inTime=" + inTime
				+ ", inCompany=" + inCompany + ", inName=" + inName + ", num="
				+ num + "]";
	}
}
