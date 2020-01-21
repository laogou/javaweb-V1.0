package service;

import java.util.ArrayList;
import common.City;
import common.Operator;
import common.Product;
import common.Settle;
import dao.NetSelectDao;


/**
 * 获得下拉框的值

 * @author 张志远

 *
 */
public class NetSelectService {

	NetSelectDao sd=new NetSelectDao();
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

	 * @return ArrayList<Operator>
	 */
	public ArrayList<Operator> getOperator(){
		return sd.getOperator();
	}
	/**
	 * 查询出数据库中按运营商类型编号查询商品名称
	 * @return ArrayList<Operator>
	 */
	public String getOperatorName(String operatorCode){
		return sd.getOperatorName(operatorCode);
	}
	/**
	 * 获得有效的结算类型类型编号、名称

	 * @return ArrayList<Settle>
	 */
	public ArrayList<Settle> getSettle(){
		return sd.getSettle();
	}
	/**
	 * 查询出数据库中按结算类型编号查询结算类型名称
	 * @return ArrayList<Operator>
	 */
	public String getSettleName(String settleCode){
		return sd.getSettleName(settleCode);
	}
}
