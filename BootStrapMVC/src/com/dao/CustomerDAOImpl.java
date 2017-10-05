package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;










import com.po.Customer;
import com.util.C3P0;

public class CustomerDAOImpl implements CustomerDAO{

	PreparedStatement stmt;
	ResultSet rs;

	/*
	 * ��������� getForCustomer����getAllInformation����
	 * */
	@Override 
	public List<Customer> getAllInformation() throws Exception {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = C3P0.getConnection();
		String sql = "select * from student";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Customer stu = new Customer();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPhone(rs.getString("Phone"));
			list.add(stu);
		}
		conn.close();
		return list;
	}
	
	@Override
	public void update(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update student set sno = ?, sname = ?, phone = ? where sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getSno());
		stmt.setString(2, customer.getSname());
		stmt.setString(3, customer.getPhone());
		stmt.setString(4, customer.getSno());
		stmt.executeUpdate();
		conn.close();
	}

	@Override
	public void save(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?, ?, ?)";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getSno());
		stmt.setString(2, customer.getSname());
		stmt.setString(3, customer.getPhone());
		stmt.executeUpdate();
		conn.close();
	}
	
	@Override
	public Customer getSigner(String Sno) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from student where Sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, Sno);
		ResultSet rs = stmt.executeQuery();
		Customer stu = null;
		if (rs.next()) {
			stu = new Customer();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPhone(rs.getString("Phone"));
		}
		conn.close();
		return stu;
	}

	@Override
	public void delete(String Sno) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "delete from student where Sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, Sno);
		stmt.executeUpdate();
		conn.close();
	}

	@Override
	public boolean getCountWithName(String Sno) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from student where Sno = ?";
		Connection conn = C3P0.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, Sno);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			conn.close();
			return true;
		} else {
			conn.close();
			return false;
		}
	}

	@Override
	public List<Customer> getForCustomer(Customer c) throws Exception {

		List<Customer> list = new ArrayList<Customer>();
		Connection conn = C3P0.getConnection();
		String sql = "select * from student where sno like ? and sname like ? and phone like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, c.getSno() == null ? "%%" : "%" + c.getSno() + "%");
		stmt.setString(2, c.getSname() == null ? "%%" : "%" + c.getSname() + "%");
		stmt.setString(3, c.getPhone() == null ? "%%" : "%" + c.getPhone() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Customer stu = new Customer();
			stu.setSno(rs.getString("Sno"));
			stu.setSname(rs.getString("Sname"));
			stu.setPhone(rs.getString("Phone"));
			list.add(stu);
		}
		conn.close();
		return list;
	}

}







