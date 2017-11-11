package com.DAO;

import java.util.List;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public interface QueryForView {

	/*
	 * 第二页：查询商品信息
	 * 只有一个goods表，很好查
	 * */
	List<Goods> queryForGoods(Goods g, int page) throws Exception;
	
	/*
	 * 第三页：查询所有入库记录
	 * 两个表，sql中已用视图连接，视图名 showinview
	 * */
	List<ShowInView> queryForInView(ShowInView s, int page) throws Exception;
	
	/*
	 * 第四页：查询所有出库记录
	 * 两个表，同样用视图已经连接,视图名 showoutview
	 * */
	List<ShowOutView> queryForOutView(ShowOutView s, int page) throws Exception;
}
