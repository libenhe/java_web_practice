package study.libenhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.libenhe.dao.ProductDao;
import study.libenhe.entity.Product;

/***
 * 显示产品的详细信息
 * 
 * @author Li Benhe
 * 
 */
public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		String id = request.getParameter("productId");
		ProductDao productDao = new ProductDao();
		Product product = productDao.findProductID(id);

		// 显示到浏览器
		PrintWriter writer = response.getWriter();
		String html = "";
		html += "<html>";
		html += "<head>";
		html += "<title>显示商品详细</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='600px'>";
		if (product != null) {
			html += "<tr><th>编号：</th><td>" + product.getProductId()
					+ "</td></tr>";
			html += "<tr><th>产品名称：</th><td>" + product.getProductName()
					+ "</td></tr>";
			html += "<tr><th>产品型号：</th><td>" + product.getProductVersion()
					+ "</td></tr>";
			html += "<tr><th>产品价格：</th><td>" + product.getProductPrice()
					+ "</td></tr>";
		}
		html += "</table>";
		html += "<center><a href = '" + request.getContextPath()
				+ "/ListServlet'>[返回列表]</a></center>";
		html += "</body>";
		html += "</html>";
		writer.write(html);

		// 创建cookie并发送
		Cookie cookie = new Cookie("productHist", createHist(request, id));
		cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
		response.addCookie(cookie);
	}

	/**
	 * 生成cookie的值 分析： 当前cookie值 传入商品id 最终cookie值 null或没有prodHist 1 1 （算法：
	 * 直接返回传入的id ） 1 2 2,1 （没有重复且小于3个。算法：直接把传入的id放最前面 ） 2,1 1
	 * 1,2（有重复且小于3个。算法：去除重复id，把传入的id放最前面 ） 3,2,1 2
	 * 2,3,1（有重复且3个。算法：去除重复id，把传入的id放最前面） 3,2,1 4
	 * 4,3,2（没有重复且3个。算法：去最后的id，把传入的id放最前面）
	 * 
	 */

	String createHist(HttpServletRequest request, String id) {
		Cookie[] cookies = request.getCookies();

		String productHist = "";
		if (cookies != null) {
			for (Cookie cookie2 : cookies) {
				if (cookie2.getName().equals("productHist")) {
					productHist = cookie2.getValue();
					break;
				}
			}
		}
		if (cookies == null || productHist == null) {
			return id;
		}

		// 3,21 2
		// String -> String[] -> Collection :为了方便判断重复id
		String[] ids = productHist.split(",");
		Collection colls = Arrays.asList(ids); // <3,21>
		// LinkedList 方便地操作（增删改元素）集合
		// Collection -> LinkedList
		LinkedList list = new LinkedList(colls);

		// 不超过3个
		if (list.size() < 3) {
			// id重复
			if (list.contains(id)) {
				// 去除重复id，把传入的id放最前面
				list.remove(id);
				list.addFirst(id);
			} else {
				// 直接把传入的id放最前面
				list.addFirst(id);
			}
		} else {
			// 等于3个
			// id重复
			if (list.contains(id)) {
				// 去除重复id，把传入的id放最前面
				list.remove(id);
				list.addFirst(id);
			} else {
				// 去最后的id，把传入的id放最前面
				list.removeLast();
				list.addFirst(id);
			}
		}

		// LinedList -> String
		StringBuffer sb = new StringBuffer();
		for (Object object : list) {
			sb.append(object + ",");
		}
		// 去掉最后的逗号
		String result = sb.toString();
		result = result.substring(0, result.length() - 1);
		return result;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
