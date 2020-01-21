package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Card.Card;
import com.itheima.Dao.Net.Net;

public interface NetService {

	void addNet(Net net);
	void updateNet(Net net);
	void deleteNet(int serial);
	int getMaxSerial();
	Net getBySerial(int serial);
	List<Net> getAllNet(String[] params);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getOperator_code(String operator_name);
	String getSettle_code(String settle_name);
}
