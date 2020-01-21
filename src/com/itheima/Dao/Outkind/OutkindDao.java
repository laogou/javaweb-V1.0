package com.itheima.Dao.Outkind;

import java.util.List;


public interface OutkindDao {
	void addOutkind(Outkind outkind);
	void updateOutkind(Outkind outkind);
	void deleteOutkind(int serial);
	int getMaxSerial();
	List<Outkind> getAllOutkind(String[] params);
	Outkind getBySerial(int serial);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getOutkind_code(String outkind_name);
}
