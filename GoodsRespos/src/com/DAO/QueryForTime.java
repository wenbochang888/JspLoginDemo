package com.DAO;

import java.util.List;

import com.po.Time;

public interface QueryForTime {
	
	public List<Time> queryForTime(String sql, String arg) throws Exception;
}
