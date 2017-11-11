package com.DAO;

import com.po.Goods;
import com.po.InResposRecord;
import com.po.OutResposRecord;

public interface AddRespos {

	/*
	 * 第五页：我要入库
	 * 入库首先要填写一系列框框
	 * 
	 * 先判断id是不是在商品中
	 * 
	 * 若在商品中，则商品表中num+1，然后在入库表中在insert
	 * 否则    先insert商品表，再在insert入库表
	 * */
	
	/*
	 * 先判断id是不是在商品中
	 * */
	Boolean isExistGoods(String id) throws Exception;
	
	/*
	 * 添加商品
	 * */
	void addForGoods(Goods g) throws Exception;
	
	/*
	 * 添加入库记录
	 * */
	void addForRecord(InResposRecord r) throws Exception;
	
	/*
	 * 添加出库信息
	 * */
	void addForOutRecord(OutResposRecord orr) throws Exception;
	
	/*
	 * update
	 * 
	 * num+1,让我先想想怎么写，愁啊TMD
	 * update goods set num = (select mid.num from (
	 * select num from goods where id = 1)mid) + 5 where id = 1;
	 * */
	void updateForNum(Goods g) throws Exception;
	
	/*
	 * 当商品中num=0时，从商品库中删除
	 * */
	void deleteGoods(String id) throws Exception;
}








