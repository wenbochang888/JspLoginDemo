package com.DAO;

import com.po.Goods;
import com.po.InResposRecord;
import com.po.OutResposRecord;

public class AddResposImp extends AbsDAO implements AddRespos {

	@Override
	public Boolean isExistGoods(String id) throws Exception {
		String sql = "select * from goods where id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addForGoods(Goods g) throws Exception {
		String sql = "insert into goods values(?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, g.getId());
		stmt.setString(2, g.getGoodsName());
		stmt.setString(3, g.getManuf());
		stmt.setString(4, g.getVersion());
		stmt.setInt(5, g.getNum());
		stmt.executeUpdate();
	}

	@Override
	public void addForRecord(InResposRecord r) throws Exception {
		String sql = "insert into inresposrecord(id, intime, incompany, inname, num) values(?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, r.getId());
		stmt.setString(2, r.getInTime());
		stmt.setString(3, r.getInCompany());
		stmt.setString(4, r.getInName());
		stmt.setInt(5, r.getNum());
		stmt.executeUpdate();
	}

	@Override
	public void addForOutRecord(OutResposRecord r) throws Exception {
		String sql = "insert into outresposrecord(id, outtime, outcompany, outname, num)  values(?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, r.getId());
		stmt.setString(2, r.getOutTime());
		stmt.setString(3, r.getOutCompany());
		stmt.setString(4, r.getOutName());
		stmt.setInt(5, r.getNum());
		stmt.executeUpdate();
	}

	@Override
	public void updateForNum(Goods g) throws Exception {
		String sql = "update goods set num = (select mid.num from (select num from goods where id = ?)mid) + ? where id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, g.getId());
		stmt.setInt(2, g.getNum());
		stmt.setString(3, g.getId());
		stmt.executeUpdate();
	}

	@Override
	public void deleteGoods(String id) throws Exception {
		String sql = "update goods set num = 0 where id = ?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.executeUpdate();
	}
}










