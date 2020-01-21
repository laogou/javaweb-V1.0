package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Net.Net;
import com.itheima.Dao.Net.NetDao;
import com.itheima.Dao.Net.NetDaoImpl;

public class NetServiceImpl implements NetService{
	public void addNet(Net net)
	{
		NetDao dd=new NetDaoImpl();
		dd.addNet(net);
	}
	public void updateNet(Net net)
	{
		NetDao dd=new NetDaoImpl();
		dd.updateNet(net);
	}
	public void deleteNet(int serial)
	{
		NetDao dd=new NetDaoImpl();
		dd.deleteNet(serial);
	}
	public int getMaxSerial()
	{
		NetDao dd=new NetDaoImpl();
		return dd.getMaxSerial();
	}
	public Net getBySerial(int serial)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getBySerial(serial);
	}
	public List<Net> getAllNet(String[] params)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getAllNet(params);
	}
	public String getCity_code(String city_name)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getCity_code(city_name);
	}
	public String getProduct_code(String product_name)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getProduct_code(product_name);
	}
	public String getOperator_code(String operator_name)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getOperator_code(operator_name);
	}
	public String getSettle_code(String settle_name)
	{
		NetDao dd=new NetDaoImpl();
		return dd.getSettle_code(settle_name);
	}

}
