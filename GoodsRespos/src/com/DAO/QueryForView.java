package com.DAO;

import java.util.List;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public interface QueryForView {

	/*
	 * �ڶ�ҳ����ѯ��Ʒ��Ϣ
	 * ֻ��һ��goods���ܺò�
	 * */
	List<Goods> queryForGoods(Goods g, int page) throws Exception;
	
	/*
	 * ����ҳ����ѯ��������¼
	 * ������sql��������ͼ���ӣ���ͼ�� showinview
	 * */
	List<ShowInView> queryForInView(ShowInView s, int page) throws Exception;
	
	/*
	 * ����ҳ����ѯ���г����¼
	 * ������ͬ������ͼ�Ѿ�����,��ͼ�� showoutview
	 * */
	List<ShowOutView> queryForOutView(ShowOutView s, int page) throws Exception;
}
