package com.po;

public class ShowInView {

	String id;
	String goodsName;
	String manuf;
	String version;
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getManuf() {
		return manuf;
	}

	public void setManuf(String manuf) {
		this.manuf = manuf;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	@Override
	public String toString() {
		return "ShowInView [id=" + id + ", goodsName=" + goodsName + ", manuf="
				+ manuf + ", version=" + version + ", num=" + num + ", inTime="
				+ inTime + ", inCompany=" + inCompany + ", inName=" + inName
				+ "]";
	}
}
