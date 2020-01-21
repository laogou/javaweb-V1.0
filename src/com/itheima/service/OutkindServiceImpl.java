package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Outkind.Outkind;
import com.itheima.Dao.Outkind.OutkindDao;
import com.itheima.Dao.Outkind.OutkindDaoImpl;

public class OutkindServiceImpl implements OutkindService{

	public void addOutkind(Outkind outkind)
	{
		OutkindDao dd=new OutkindDaoImpl();
		dd.addOutkind(outkind);
	}
	public void updateOutkind(Outkind outkind)
	{
		OutkindDao dd=new OutkindDaoImpl();
		dd.updateOutkind(outkind);
	}
	public void deleteOutkind(int serial)
	{
		OutkindDao dd=new OutkindDaoImpl();
		dd.deleteOutkind(serial);
	}
	public int getMaxSerial()
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getMaxSerial();
	}
	public Outkind getBySerial(int serial)
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getBySerial(serial);
	}
	public List<Outkind> getAllOutkind(String[] params)
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getAllOutkind(params);
	}
	public String getCity_code(String city_name)
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getCity_code(city_name);
	}
	public String getProduct_code(String product_name)
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getProduct_code(product_name);
	}
	public String getOutkind_code(String outkind_name)
	{
		OutkindDao dd=new OutkindDaoImpl();
		return dd.getOutkind_code(outkind_name);
	}
}
