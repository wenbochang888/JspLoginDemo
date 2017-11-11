package com.po;

public class ShowOutTime {

	private String year;
	private int num;

	@Override
	public String toString() {
		return "ShowOutTime [year=" + year + ", num=" + num + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
