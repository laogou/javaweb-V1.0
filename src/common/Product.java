package common;

/**
 * 产品实体信息
 * @author new
 *
 */
public class Product {

	private String productCode = "";       //产品编码
	private String productName = "";    //产品名称
	
	/**
	 * 无参构造函数
	 */
	public Product(){
		
	}
	/**
	 * 有参构造函数
	 */
    public Product(String productCode,String productName){
		this.productCode = productCode;
		this.productName = productName;
	}
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productId the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productState
	 */
}
