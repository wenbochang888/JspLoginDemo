package com.DAO;

import java.util.ArrayList;
import java.util.List;

import com.po.Time;

public class QueryForTimeImpl extends AbsDAO implements QueryForTime {

	/**
	 * 统计日期
	 * 参数：sql为sql语句，arg为年，月，日
	 * 总共有三个选项：year month day
	 * select Datename(year, intime) as year, count(*) as num from inresposrecord group by Datename(year, intime);
	 */
	@Override
	public List<Time> queryForTime(String sql, String arg) throws Exception {

		List<Time> list = new ArrayList<Time>();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
			Time t = new Time();
			
			if ("year".equals(arg)) {
				t.setYear(rs.getString("year"));
			} else if ("month".equals(arg)) {
				t.setMonth(rs.getString("month"));
			} else {
				t.setDay(rs.getString("day"));
			}
			
			t.setNum(rs.getInt("num"));
			list.add(t);
		}
		return list;
	}
}
