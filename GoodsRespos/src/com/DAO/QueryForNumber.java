package com.DAO;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public interface QueryForNumber {
	
	/**
	 * ͳ�Ƴ�������Ʒ������
	 */
	int queryForOutNumber(ShowOutView so) throws Exception;
	
	/**
	 * ͳ�������Ʒ������
	 */
	int queryForInNumber(ShowInView sv) throws Exception;
	
	/**
	 * ͳ����Ʒ����
	 */
	int queryForGoodsNumber(Goods g) throws Exception;
}













