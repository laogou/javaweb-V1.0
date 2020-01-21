package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Pre.Pre;

public interface PreService {
	void addPre(Pre pre);
	//void selectPre(Pre pre);
	void updatePre(Pre pre);
	void deletePre(int serial);
	int getMaxSerial();
	Pre getBySerial(int serial);
   List<Pre> getAllPre(String[] params);
   String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getCancel_code(String cancel_name);
}
