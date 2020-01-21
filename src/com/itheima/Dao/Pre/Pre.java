package com.itheima.Dao.Pre;

import java.sql.Date;

public class Pre {
	private int serial;
	private Date pre_input_date;
	private String pre_input_city_code;
	private String pre_input_product_code;
	private String pre_input_cancel_code;
	private double pre_input_amount;
	private String pre_input_state;
	public Pre()
	{
		super();
	}
	public Pre(Pre pre)
	{
		this.serial=pre.serial;
		this.pre_input_date=pre.pre_input_date;
		this.pre_input_city_code=pre.pre_input_city_code;
		this.pre_input_product_code=pre.pre_input_product_code;
		this.pre_input_cancel_code=pre.pre_input_cancel_code;
		this.pre_input_amount=pre.pre_input_amount;
		this.pre_input_state=pre.pre_input_state;
		
	}
	public Pre(Date date,String city_code,String product_code,String cancel_code,double amount) {
		pre_input_date=date;
		pre_input_city_code=city_code;
		pre_input_product_code=product_code;
		pre_input_cancel_code=cancel_code;
		pre_input_amount=amount;
	}
	public int getSerial()
	{
		return serial;
	}
	public void setSerial(int serial)
	{
		this.serial=serial;
	}
	public Date getDate()
	{
		return pre_input_date;
	}
	
	public String getCity_code()
	{
		return pre_input_city_code;
	}
	public void setCity_code(String city_code)
	{
		this.pre_input_city_code=city_code;
	}
	public String getProduct_code()
	{
		return pre_input_product_code;
	}
	public void setProduct_code(String product_code)
	{
		this.pre_input_product_code=product_code;
	}
	public String getCancel_code()
	{
		return pre_input_cancel_code;
	}
	public void setCancel_code(String cancel_code)
	{
		this.pre_input_cancel_code=cancel_code;
	}
	public double getAmount()
	{
		return pre_input_amount;
	}
	public void setAmount(double amount)
	{
		this.pre_input_amount=amount;
	}
	public void setState(String state)
	{
		this.pre_input_state=state;
	}
	public String getState()
	{
		return pre_input_state;
	}
	public String toString() {
		return "pre_input [serial=" + serial + ", pre_input_date=" + pre_input_date 
				+ ", pre_input_city_code=" + pre_input_city_code+",pre_input_product_code"
				+pre_input_product_code+ ",pre_input_cancel_code"+pre_input_cancel_code
				+",opre_input_amount"+pre_input_amount+",pre_input_state"+pre_input_state
				+"]";
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.pre_input_date=date;
	}
}
