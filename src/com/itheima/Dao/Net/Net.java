package com.itheima.Dao.Net;

import java.sql.Date;

public class Net {

	private int serial;
	private Date net_input_date;
	private String net_input_city_code;
	private String net_input_product_code;
	private String net_input_operator_code;
	private String net_input_settle_code;
	private double net_input_amount;
	private String net_input_state;
	
	public Net()
	{
		super();
	}
	public  int getSerial()
	{
		return serial;
	}
	public void setSerial(int serial)
	{
		this.serial=serial;
	}
	public Date getDate()
	{
		return net_input_date;
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.net_input_date=date;
	}
	public String getCity_code()
	{
		return net_input_city_code;
	}
	public void setCity_code(String city_code)
	{
		this.net_input_city_code=city_code;
	}
	public String getProduct_code()
	{
		return net_input_product_code;
	}
	public void setProduct_code(String product_code)
	{
		this.net_input_product_code=product_code;
	}
	public String getOperator_code()
	{
		return net_input_operator_code;
	}
	public void setOperator_code(String operator_code)
	{
		this.net_input_operator_code=operator_code;
	}
	public String getSettle_code()
	{
		return net_input_settle_code;
	}
	public void setSettle_code(String settle_code)
	{
		this.net_input_settle_code=settle_code;
	}
	
	public double getAmount()
	{
		return net_input_amount;
	}
	public void setAmount(double amount)
	{
		this.net_input_amount=amount;
	}
	
	public void setState(String state)
	{
		this.net_input_state=state;
	}
	public String getState()
	{
		return net_input_state;
	}
	public String toString() {
		return "net_input [serial=" + serial + ", net_input_date=" + net_input_date 
				+ ", net_input_city_code=" + net_input_city_code+",net_input_product_code="
				+net_input_product_code+",net_input_operator_code="+net_input_operator_code
				+",net_input_settle_code="+net_input_settle_code+",net_input_amount="+net_input_amount+
				",net_input_state"+net_input_state+"]";
	}
}
