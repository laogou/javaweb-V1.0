package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Pre.Pre;
import com.itheima.Dao.Pre.PreDao;
import com.itheima.Dao.Pre.PreDaoImpl;

public class PreServiceImpl implements PreService{
	public void addPre(Pre pre)
	{
		PreDao dd=new PreDaoImpl();
		dd.addPre(pre);
	}
	public void updatePre(Pre pre)
	{
		PreDao dd=new PreDaoImpl();
		dd.updatePre(pre);
	}
	public void deletePre(int serial)
	{
		PreDao dd=new PreDaoImpl();
		dd.deletePre(serial);
	}
	public int getMaxSerial()
	{
		PreDao dd=new PreDaoImpl();
		return dd.getMaxSerial();
	}
	public Pre getBySerial(int serial)
	{
		PreDao dd=new PreDaoImpl();
		return dd.getBySerial(serial);
	}
	public List<Pre> getAllPre(String[] params)
	{
		PreDao dd=new PreDaoImpl();
		return dd.getAllPre(params);
	}
	public String getCity_code(String city_name)
	{
		PreDao dd=new PreDaoImpl();
		return dd.getCity_code(city_name);
	}
	public String getProduct_code(String product_name)
	{
		PreDao dd=new PreDaoImpl();
		return dd.getProduct_code(product_name);
	}
	public String getCancel_code(String cancel_name)
	{
		PreDao dd=new PreDaoImpl();
		return dd.getCancel_code(cancel_name);
	}
}
