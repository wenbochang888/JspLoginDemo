package com.test;

import com.DAO.QueryForView;
import com.DAO.QueryForViewImp;
import com.po.ShowOutView;

public class Main {
	public static void main(String[] args) throws Exception {
		
		QueryForView qfv = new QueryForViewImp();
		System.out.println(qfv.queryForOutView(new ShowOutView(), 1));
	}
}








