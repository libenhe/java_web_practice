package study.libenhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.libenhe.dao.ProductDao;
import study.libenhe.entity.Product;

/**
 * 查询所有产品的servlet
 * 
 * @author Li Benhe
 * 
 */
public class ListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		// 读取数据库，查询所有产品
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.findAll();

		PrintWriter writer = response.getWriter();
		String html = "";

		html += "<html>";
		html += "<head>";
		html += "<title>显示商品列表</title>";
		html += "</head>";
		html += "<body>";
		html += "<table border='1' align='center' width='800px'>";
		html += "<tr>";
		html += "<th>编号</th><th>产品名称</th><th>产品型号</th><th>产品价格</th>";
		html += "</tr>";

		// 遍历产品

		if (list != null) {
			for (Product product : list) {
				html += "<tr>";
				html += "<td>" + product.getProductId() + "</td><td><a href='"
						+ request.getContextPath()
						+ "/DetailServlet?productId=" + product.getProductId()
						+ "'>" + product.getProductName() + "</a></td><td>"
						+ product.getProductVersion() + "</td><td>"
						+ product.getProductPrice() + "</td>";
			}
		}
		html += "</table>";

		/**
		 * 显示浏览过的商品
		 */
		html += "最近浏览过的商品：<br/>";
		// 取出prodHist的cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("productHist")) {
					String prodHist = cookie.getValue(); // 3,2,1
					String[] ids = prodHist.split(",");
					// 遍历浏览过的商品id
					for (String id : ids) {
						// 查询数据库，查询对应的商品
						Product p = productDao.findProductID(id);
						// 显示到浏览器
						html += "" + p.getProductId() + "&nbsp;"
								+ p.getProductName() + "&nbsp;"
								+ p.getProductPrice() + "<br/>";
					}
				}
			}
		}

		html += "</body>";
		html += "</html>";
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
