package com.itheima.service;

import java.util.List;


import com.itheima.Dao.Notice.Notice;
import com.itheima.Dao.Notice.NoticeDao;
import com.itheima.Dao.Notice.NoticeDaoImpl;

public class NoticeServiceImpl implements NoticeService{
	public void addNotice(Notice notice)
	{
		NoticeDao dd=new NoticeDaoImpl();
		dd.addNotice(notice);
	}
	public void updateNotice(Notice notice)
	{
		NoticeDao dd=new NoticeDaoImpl();
		dd.updateNotice(notice);
	}
	public void deleteNotice(int serial)
	{
		NoticeDao dd=new NoticeDaoImpl();
		dd.deleteNotice(serial);
	}
	public int getMaxSerial()
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getMaxSerial();
	}
	public Notice getBySerial(int serial)
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getBySerial(serial);
	}
	public List<Notice> getAllNotice(String[] params)
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getAllNotice(params);
	}
	public String getCity_code(String city_name)
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getCity_code(city_name);
	}
	public String getProduct_code(String product_name)
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getProduct_code(product_name);
	}
	public String getNotice_code(String notice_name)
	{
		NoticeDao dd=new NoticeDaoImpl();
		return dd.getNotice_code(notice_name);
	}
}
