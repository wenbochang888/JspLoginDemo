package com.DAO;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public interface QueryForNumber {
	
	/**
	 * 统计出库中商品的数量
	 */
	int queryForOutNumber(ShowOutView so) throws Exception;
	
	/**
	 * 统计入库商品的数量
	 */
	int queryForInNumber(ShowInView sv) throws Exception;
	
	/**
	 * 统计商品数量
	 */
	int queryForGoodsNumber(Goods g) throws Exception;
}













