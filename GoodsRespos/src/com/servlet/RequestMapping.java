package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AddRespos;
import com.DAO.AddResposImp;
import com.DAO.QueryForNumber;
import com.DAO.QueryForNumberImp;
import com.DAO.QueryForTime;
import com.DAO.QueryForTimeImpl;
import com.DAO.QueryForView;
import com.DAO.QueryForViewImp;
import com.po.Goods;
import com.po.InResposRecord;
import com.po.OutResposRecord;
import com.po.ShowInView;
import com.po.ShowOutView;
import com.po.Time;


public class RequestMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * �Լ�����DAO��ʵ�ַ���
	 */
	AddRespos addRespos = new AddResposImp();
	QueryForNumber queryForNumber = new QueryForNumberImp();
	QueryForTime queryForTime = new QueryForTimeImpl();
	QueryForView queryForView = new QueryForViewImp();
	
	public RequestMapping() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * �������ǽ�����ı�������⣬��ס�Ժ�һ��Ҫ����
		 * */
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.length()-3);
		
		
		try {
			if ("GoodsRespForQuery".equals(methodName)) {
				GoodsRespForQuery(request, response);
			} else if ("InRespoRecord".equals(methodName)) {
				InRespoRecord(request, response);
			} else if ("OutRespoRecord".equals(methodName)) {
				OutRespoRecord(request, response);
			} else if ("AddGoods".equals(methodName)) {
				AddGoods(request, response);
			} else if ("DeleteGoods".equals(methodName)) {
				DeleteGoods(request, response);
			} else if ("ShowTime".equals(methodName)) {
				ShowTime(request, response);
			}
				
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
	}
	
	//�ȴ����ļ�¼
		private void ShowTime(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			//���������
			String sql = "select Datename(year, outtime) as year, count(*) as num from outresposrecord group by Datename(year, outtime)";
			List<Time> yearTime = queryForTime.queryForTime(sql, "year");
			request.setAttribute("yearTime", yearTime);
			
			//���������
			sql = "select Datename(month, outtime) as month, count(*) as num from outresposrecord group by Datename(month, outtime)";
			List<Time> monthTime = queryForTime.queryForTime(sql, "month");
			request.setAttribute("monthTime", monthTime);
			
			//���������
			sql = "select Datename(day, outtime) as day, count(*) as num from outresposrecord group by Datename(day, outtime)";
			List<Time> dayTime = queryForTime.queryForTime(sql, "day");
			request.setAttribute("dayTime", dayTime);
			
			//������
			sql = "select Datename(year, intime) as year, count(*) as num from inresposrecord group by Datename(year, intime)";
			List<Time> yearInTime = queryForTime.queryForTime(sql, "year");
			request.setAttribute("yearInTime", yearInTime);
			
			//������
			sql = "select Datename(month, intime) as month, count(*) as num from inresposrecord group by Datename(month, intime)";
			List<Time> monthInTime = queryForTime.queryForTime(sql, "month");
			request.setAttribute("monthInTime", monthInTime);
			
			//������
			sql = "select Datename(day, intime) as day, count(*) as num from inresposrecord group by Datename(day, intime)";
			List<Time> dayInTime = queryForTime.queryForTime(sql, "day");
			request.setAttribute("dayInTime", dayInTime);
			
			request.getRequestDispatcher("ShowTime.jsp").forward(request, response);
		}

		private void DeleteGoods(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			String id = request.getParameter("id");
			String goodsName = request.getParameter("goodsName");
			String manuf = request.getParameter("manuf");
			String version = request.getParameter("version");
			int newNum = Integer.valueOf(request.getParameter("num"));
			int oldNum = Integer.valueOf(request.getParameter("oldNum"));
			String dateTime = request.getParameter("dateTime");
			String company = request.getParameter("company");
			String name = request.getParameter("name");
			
			if (dateTime.length() != 8 || dateTime.length() == 0 || dateTime == null) {
				response.sendRedirect("error.jsp");
			}
			
			OutResposRecord orr = new OutResposRecord();
			orr.setId(id);
			orr.setOutTime(dateTime);
			orr.setOutCompany(company);
			orr.setOutName(name);
			orr.setNum(newNum);
			
			//System.out.println(newNum + "  " + oldNum); 22 176
			if (newNum > oldNum) {
				request.setAttribute("msg", "num(����)�����˲ֿ��е�����������ʧ��");
				request.getRequestDispatcher("DeleteGoods.jsp").forward(request, response);
			} else if (newNum == oldNum) {
				addRespos.addForOutRecord(orr);
				addRespos.deleteGoods(id);
				request.setAttribute("msg", "��Ʒ�Ѿ�ȫ��ȡ������Ʒ�����Ѳ����ڴ˲�Ʒ");
				request.getRequestDispatcher("DeleteGoods.jsp").forward(request, response);
				return;
			} else {
				addRespos.addForOutRecord(orr);
				Goods g = new Goods();
				g.setId(id);
				g.setGoodsName(goodsName);
				g.setManuf(manuf);
				g.setNum(-newNum);
				g.setVersion(version);
				addRespos.updateForNum(g);
				request.setAttribute("msg", "��Ʒ����ɹ������д�ID��Ʒ�ڿ���");
				request.getRequestDispatcher("DeleteGoods.jsp").forward(request, response);
			}
		}

		private void AddGoods(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			String id = request.getParameter("id");
			String goodsName = request.getParameter("goodsName");
			String manf = request.getParameter("manf");
			String version = request.getParameter("version");
			int num = Integer.valueOf(request.getParameter("num"));
			String dateTime = request.getParameter("dateTime");
			String company = request.getParameter("company");
			String name = request.getParameter("name");
			if (dateTime.length() != 8 || dateTime.length() == 0 || dateTime == null) {
				response.sendRedirect("error.jsp");
			}
			
			Boolean isExist = addRespos.isExistGoods(id);
			Goods g = new Goods();
			g.setId(id);
			g.setGoodsName(goodsName);
			g.setManuf(manf);
			g.setNum(num);
			g.setVersion(version);
			InResposRecord r = new InResposRecord();
			r.setId(id);
			r.setInName(name);
			r.setInCompany(company);
			r.setInTime(dateTime);
			r.setNum(num);
			addRespos.addForRecord(r);
			if (isExist) {
				addRespos.updateForNum(g);
				request.setAttribute("msg", "������ƷID��ͬ���Ѿ��޸���numֵ��������������¼����鿴");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			} else {
				addRespos.addForGoods(g);
				request.setAttribute("msg", "�ֿ����޸�ID��Ʒ���Ѿ��ɹ���ӣ�������������¼����鿴");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			}
		}

		private void OutRespoRecord(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			//��Ʒ�б�
			ShowOutView so = new ShowOutView();
			so.setGoodsName(request.getParameter("goodsName"));
			so.setOutTime(request.getParameter("dateTime"));
			
			//������Ʒ
			List<ShowOutView> showOutView = queryForView.queryForOutView(so, Integer.valueOf(request.getParameter("page")));
			request.setAttribute("showOutView", showOutView);
			
			//����ҳ��
			int number = queryForNumber.queryForOutNumber(so);
			request.setAttribute("number", number);
			request.getRequestDispatcher("OutRespoRecord.jsp").forward(request, response);
			
		}

		private void InRespoRecord(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			ShowInView sv = new ShowInView();
			sv.setGoodsName(request.getParameter("goodsName"));
			sv.setInTime(request.getParameter("dateTime"));
			List<ShowInView> showInView = queryForView.queryForInView(sv, Integer.valueOf(request.getParameter("page")));
			request.setAttribute("showInView", showInView);
			
			int number = queryForNumber.queryForInNumber(sv);
			request.setAttribute("number", number);
			
			request.getRequestDispatcher("InRespoRecord.jsp").forward(request, response);
		}

		private void GoodsRespForQuery(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			Goods g = new Goods();
			g.setId(request.getParameter("id"));
			g.setGoodsName(request.getParameter("goodsName"));
			List<Goods> goodsList = queryForView.queryForGoods(g, Integer.valueOf(request.getParameter("page")));
			request.setAttribute("goodsList", goodsList);
			
			int number = queryForNumber.queryForGoodsNumber(g);
			request.setAttribute("number", number);
			
			request.getRequestDispatcher("GoodResp.jsp").forward(request, response);
		}
}













