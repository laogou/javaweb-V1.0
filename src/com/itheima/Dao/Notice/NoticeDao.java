package com.itheima.Dao.Notice;

import java.util.List;


public interface NoticeDao {
	void addNotice(Notice notice);
	void updateNotice(Notice notice);
	void deleteNotice(int serial);
	int getMaxSerial();
	List<Notice> getAllNotice(String[] params);
	Notice getBySerial(int serial);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getNotice_code(String notice_name);
}
