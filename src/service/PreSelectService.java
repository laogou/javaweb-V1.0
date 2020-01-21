package service;

import java.util.ArrayList;
import common.City;
import common.Cancel;
import common.Product;
import dao.PreSelectDao;


/**
 * 获得下拉框的值

 * @author 张志远

 *
 */
public class PreSelectService {

	PreSelectDao sd=new PreSelectDao();
	/**
	 * 获得有效的地市编号、名称

	 * return ArrayList<City>
	 */
	public ArrayList<City> getCity(){
		return sd.getCity();
	}
	/**
	 * 查询出数据库中按地市编号查询地市名称
	 * @return ArrayList<City>
	 */
	public String getCityName(String cityCode){
		return sd.getCityName(cityCode);
	}
	/**
	 * 获得有效的产品编号、名称

	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getProduct(){
		return sd.getProduct();
	}
	/**
	 * 查询出数据库中按商品编号查询商品名称
	 * @return ArrayList<City>
	 */
	public String getProductName(String productCode){
		return sd.getProductName(productCode);
	}
	/**
	 * 获得有效的运营商类型编号、名称

	 * @return ArrayList<Cancel>
	 */
	public ArrayList<Cancel> getCancel(){
		return sd.getCancel();
	}
	/**
	 * 查询出数据库中按运营商类型编号查询商品名称
	 * @return ArrayList<Cancel>
	 */
	public String getCancelName(String cancelCode){
		return sd.getCancelName(cancelCode);
	}
}
