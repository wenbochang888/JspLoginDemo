package com.po;

public class ShowOutView {

	String id;
	String goodsName = null;
	String manuf;
	String version;
	String outTime = null;
	String outCompany;
	String outName;
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
		return "ShowOutView [id=" + id + ", goodsName=" + goodsName
				+ ", manuf=" + manuf + ", version=" + version + ", outTime="
				+ outTime + ", outCompany=" + outCompany + ", outName="
				+ outName + ", num=" + num + "]";
	}
}
