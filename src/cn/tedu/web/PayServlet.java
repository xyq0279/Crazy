package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.domain.Order;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.OrderService;

public class PayServlet extends HttpServlet {
	private OrderService service = BasicFactory.getFactory().getInstance(OrderService.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得订单ID
		String oid = request.getParameter("orderid");
		Order order =  service.findOrderByOid(oid);
		
		
		request.getRequestDispatcher("/confirm.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
