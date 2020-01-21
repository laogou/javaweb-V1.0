package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Outkind.Outkind;

public interface OutkindService {

	void addOutkind(Outkind outkind);
	void updateOutkind(Outkind outkind);
	void deleteOutkind(int serial);
	int getMaxSerial();
	Outkind getBySerial(int serial);
	List<Outkind> getAllOutkind(String[] params);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getOutkind_code(String outkind_name);
}
