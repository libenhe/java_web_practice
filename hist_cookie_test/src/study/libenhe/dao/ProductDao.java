package study.libenhe.dao;

import java.util.ArrayList;
import java.util.List;

import study.libenhe.entity.Product;

/**
 * 本类存放Product对象的CRUD方法
 * 
 * @author Li Benhe
 * 
 */
public class ProductDao {

	// 模拟数据库存放所有商品
	private static List<Product> productData = new ArrayList<Product>();

	/**
	 * 初始化商品的数据，使用静态代码块，随着类加载一次
	 */
	static {
		for (int i = 1; i <= 10; i++) {
			productData.add(new Product("" + i, "笔记本" + i, "DELL" + i,
					988.99 + i));
		}
	}

	/***
	 * 查询所有产品的方法
	 */
	public List<Product> findAll() {
		return productData;
	}

	/***
	 * 根据编号查询商品的方法
	 */
	public Product findProductID(String productId) {
		for (Product product : productData) {
			if (product.getProductId().equals(productId)) {
				return product;
			}
		}
		return null;
	}
}
