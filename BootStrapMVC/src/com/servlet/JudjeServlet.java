package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDAOImpl;
import com.po.Customer;

public class JudjeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudjeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		String methodName = servletPath.substring(1,servletPath.length()-3);
		try {
			if ("addCustomerServlet".equals(methodName)) {
				add(request, response);
			} else if ("queryCustomerServlet".equals(methodName)) {
				query(request, response);
			} else if ("delete".equals(methodName)) {
				delete(request, response);
			} else if ("edit".equals(methodName)) {
				edit(request, response);
			} else if ("update".equals(methodName)) {
				update(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.sendRedirect("index.jsp");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String oldSno = request.getParameter("oldSno");
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String phone = request.getParameter("phone");
		
		Customer c = new Customer();
		c.setSno(sno);
		c.setSname(sname);
		c.setPhone(phone);
		request.setAttribute("customer", c);
		
		if (oldSno.equals(sno)) {
			customerDAOImpl.update(c);
			response.sendRedirect("queryCustomerServlet.do");
		} else {
			request.setAttribute("msg", "不能修改学号，请重新输入");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String sno = request.getParameter("sno");
		Customer customer = customerDAOImpl.getSigner(sno);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String sno = request.getParameter("sno");
		customerDAOImpl.delete(sno);
		response.sendRedirect("queryCustomerServlet.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Customer c = new Customer();
		c.setSno(request.getParameter("sno"));
		c.setSname(request.getParameter("sname"));
		c.setPhone(request.getParameter("phone"));
		
		List<Customer> listCustomer = customerDAOImpl.getForCustomer(c);
		request.setAttribute("listCustomer" ,listCustomer);
		request.getRequestDispatcher("query.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		boolean flag = customerDAOImpl.getCountWithName(request.getParameter("sno"));
		if (flag || request.getParameter("sno") == null || request.getParameter("sno") == "") {
			request.setAttribute("msg", "该学号" + request.getParameter("sno") + "已经被注册，请换其他学号");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "恭喜你，该学号" + request.getParameter("sno") + "注册成功，请return查看或继续add");
			Customer c = new Customer();
			c.setSno(request.getParameter("sno"));
			c.setSname(request.getParameter("sname"));
			c.setPhone(request.getParameter("phone"));
			customerDAOImpl.save(c);
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}
}













