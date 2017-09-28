package com.dao;

import java.util.List;

import com.po.Customer;

public interface CustomerDAO {
	
	/*
	 * ��ȡ������Ϣ
	 * */
	public List<Customer> getAllInformation() throws Exception;
	
	/*
	 * �����Ϣ�������Ϊ����save,����add
	 * */
	public void save(Customer customer) throws Exception;
	 
	/*
	 * ��ȡ������Ϣ
	 * */
	public Customer getSigner(String Sno) throws Exception;
	
	/*
	 * ɾ����Ϣ
	 * */
	public void delete(String Sno) throws Exception;
	
	/*
	 * ���������ͬ����Ϣ
	 * */
	public boolean getCountWithName(String Sname) throws Exception;
	
	/*
	 * ģ����ѯ����
	 * */
	public List<Customer> getForCustomer(Customer c) throws Exception;
	
	public void update(Customer c) throws Exception;
	
}







