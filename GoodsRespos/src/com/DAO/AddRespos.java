package com.DAO;

import com.po.Goods;
import com.po.InResposRecord;
import com.po.OutResposRecord;

public interface AddRespos {

	/*
	 * ����ҳ����Ҫ���
	 * �������Ҫ��дһϵ�п��
	 * 
	 * ���ж�id�ǲ�������Ʒ��
	 * 
	 * ������Ʒ�У�����Ʒ����num+1��Ȼ������������insert
	 * ����    ��insert��Ʒ������insert����
	 * */
	
	/*
	 * ���ж�id�ǲ�������Ʒ��
	 * */
	Boolean isExistGoods(String id) throws Exception;
	
	/*
	 * �����Ʒ
	 * */
	void addForGoods(Goods g) throws Exception;
	
	/*
	 * �������¼
	 * */
	void addForRecord(InResposRecord r) throws Exception;
	
	/*
	 * ��ӳ�����Ϣ
	 * */
	void addForOutRecord(OutResposRecord orr) throws Exception;
	
	/*
	 * update
	 * 
	 * num+1,������������ôд���TMD
	 * update goods set num = (select mid.num from (
	 * select num from goods where id = 1)mid) + 5 where id = 1;
	 * */
	void updateForNum(Goods g) throws Exception;
	
	/*
	 * ����Ʒ��num=0ʱ������Ʒ����ɾ��
	 * */
	void deleteGoods(String id) throws Exception;
}








