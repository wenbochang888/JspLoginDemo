package com.DAO;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public class QueryForNumberImp extends AbsDAO implements QueryForNumber {

	@Override
	public int queryForOutNumber(ShowOutView so) throws Exception {
		String sql = "select count(*) from showoutview where Gname like ? and outtime like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,  so.getGoodsName() == null ? "%%" : "%" + so.getGoodsName() + "%");
		stmt.setString(2, so.getOutTime() == null ? "%%" : "%" + so.getOutTime() + "%");
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt(1); 
		}
		return 1;
	}

	@Override
	public int queryForInNumber(ShowInView sv) throws Exception {
		String sql = "select count(*) from showinview where Gname like ? and intime like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,  sv.getGoodsName() == null ? "%%" : "%" + sv.getGoodsName() + "%");
		stmt.setString(2, sv.getInTime() == null ? "%%" : "%" + sv.getInTime() + "%");
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt(1); 
		}
		return 1;
	}

	@Override
	public int queryForGoodsNumber(Goods g) throws Exception {
		String sql = "select count(*) from goods where id like ? and Gname like ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(2,  g.getGoodsName() == null ? "%%" : "%" + g.getGoodsName() + "%");
		stmt.setString(1, g.getId() == null ? "%%" : "%" + g.getId() + "%");
		rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 1;
	}
}
















