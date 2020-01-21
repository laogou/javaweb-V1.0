package com.itheima.Dao.Pre;

import java.util.List;


public interface PreDao {
	void addPre(Pre pre);
	void updatePre(Pre pre);
	void deletePre(int serial);
	int getMaxSerial();
	List<Pre> getAllPre(String[] params);
	Pre getBySerial(int serial);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getCancel_code(String cancel_name);
}
