package com.itheima.Dao.Net;

import java.util.List;

public interface NetDao {

	void addNet(Net net);
	void updateNet(Net net);
	void deleteNet(int serial);
	int getMaxSerial();
	List<Net> getAllNet(String[] params);
	Net getBySerial(int serial);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getOperator_code(String operator_name);
	String getSettle_code(String settle_name);
}
