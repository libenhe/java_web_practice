package study.libenhe.entity;

/***
 * 产品的实体类
 * 
 * @author Li Benhe
 * 
 */
public class Product {

	private String productId;
	private String productName;
	private String productVersion;
	private double productPrice;

	public Product() {
		super();
	}

	public Product(String productId, String productName, String productVersion,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productVersion = productVersion;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productVersion=" + productVersion
				+ ", productPrice=" + productPrice + "]";
	}

}
