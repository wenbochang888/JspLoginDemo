package com.DAO;

import java.util.ArrayList;
import java.util.List;

import com.po.Goods;
import com.po.ShowInView;
import com.po.ShowOutView;

public class QueryForViewImp extends AbsDAO implements QueryForView {

	@Override
	public List<Goods> queryForGoods(Goods g, int page) throws Exception {
		page = (page-1)*5;
		List<Goods> list = new ArrayList<Goods>();
		String sql = "select top 5 id,Gname,manuf,version,num"
				+" from goods where id like ? and Gname like ? and id not in (select top "
				+ page +" id from goods)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,  g.getId() == null ? "%%" : "%" + g.getId() + "%");
		stmt.setString(2, g.getGoodsName() == null ? "%%" : "%" + g.getGoodsName() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			Goods gs = new Goods();
			gs.setId(rs.getString("id"));
			gs.setGoodsName(rs.getString("Gname"));
			gs.setManuf(rs.getString("manuf"));
			gs.setVersion(rs.getString("version"));
			gs.setNum(rs.getInt("num"));
			list.add(gs);
		}
		return list;
	}

	@Override
	public List<ShowInView> queryForInView(ShowInView s, int page) throws Exception {
		page = (page-1)*5;
		List<ShowInView> showInView = new ArrayList<ShowInView>();
		String sql = "select top 5 id,Gname,manuf,version,num,intime,incompany,inname " + 
				"from showinview where Gname like ? and intime like ? " + 
				"and id not in (select top "+ page +" id from showinview) order by ord desc";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,  s.getGoodsName() == null ? "%%" : "%" + s.getGoodsName() + "%");
		stmt.setString(2, s.getInTime() == null ? "%%" : "%" + s.getInTime() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			ShowInView sv = new ShowInView();
			sv.setId(rs.getString("id"));
			sv.setGoodsName(rs.getString("Gname"));
			sv.setManuf(rs.getString("manuf"));
			sv.setVersion(rs.getString("version"));
			sv.setNum(rs.getInt("num"));
			sv.setInTime(rs.getString("intime"));
			sv.setInCompany(rs.getString("incompany"));
			sv.setInName(rs.getString("inname"));
			showInView.add(sv);
		}
		return showInView;
	}

	@Override
	public List<ShowOutView> queryForOutView(ShowOutView s, int page) throws Exception {
		page = (page-1)*5;
		List<ShowOutView> showOutView = new ArrayList<ShowOutView>();
		String sql = "select top 5 id,Gname,manuf,version,num,outtime,outcompany,outname " + 
				"from showoutview where Gname like ? and outtime like ? " + 
				"and id not in (select top "+ page +" id from showoutview) order by ord desc";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1,  s.getGoodsName() == null ? "%%" : "%" + s.getGoodsName() + "%");
		stmt.setString(2, s.getOutTime() == null ? "%%" : "%" + s.getOutTime() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			ShowOutView sv = new ShowOutView();
			sv.setId(rs.getString("id"));
			sv.setGoodsName(rs.getString("Gname"));
			sv.setManuf(rs.getString("manuf"));
			sv.setVersion(rs.getString("version"));
			sv.setNum(rs.getInt("num"));
			sv.setOutTime(rs.getString("outtime"));
			sv.setOutCompany(rs.getString("outcompany"));
			sv.setOutName(rs.getString("outname"));
			showOutView.add(sv);
		}
		return showOutView;
	}

}
