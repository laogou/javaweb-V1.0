package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Notice.Notice;

public interface NoticeService {
	void addNotice(Notice notice);
	//void selectNotice(Notice notice);
	void updateNotice(Notice notice);
	void deleteNotice(int serial);
	int getMaxSerial();
	Notice getBySerial(int serial);
    List<Notice> getAllNotice(String[] params);
    String getCity_code(String city_name);
	String getProduct_code(String product_name);
	String getNotice_code(String notice_name);
}
