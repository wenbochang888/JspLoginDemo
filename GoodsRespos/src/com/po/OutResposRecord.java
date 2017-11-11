package com.po;

public class OutResposRecord {

	String id;
	String outTime;
	String outCompany;
	String outName;
	int num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getOutCompany() {
		return outCompany;
	}

	public void setOutCompany(String outCompany) {
		this.outCompany = outCompany;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "OutResposRecord [id=" + id + ", outTime=" + outTime
				+ ", outCompany=" + outCompany + ", outName=" + outName
				+ ", num=" + num + "]";
	}
}
