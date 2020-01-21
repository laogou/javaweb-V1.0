package com.itheima.Dao.Outkind;

import java.sql.Date;

public class Outkind {

	private int serial;
	private Date outkind_input_date;
	private String outkind_input_city_code;
	private String outkind_input_product_code;
	private String outkind_input_outkind_code;
	private double outkind_input_amount;
	private String outkind_input_state;
	public Outkind()
	{
		super();
	}
	public Outkind(Outkind outkind)
	{
		this.serial=outkind.serial;
		this.outkind_input_date=outkind.outkind_input_date;
		this.outkind_input_city_code=outkind.outkind_input_city_code;
		this.outkind_input_product_code=outkind.outkind_input_product_code;
		this.outkind_input_outkind_code=outkind.outkind_input_outkind_code;
		this.outkind_input_amount=outkind.outkind_input_amount;
		this.outkind_input_state=outkind.outkind_input_state;
		
	}
	public Outkind(Date date,String city_code,String product_code,String outkind_code,double amount) {
		outkind_input_date=date;
		outkind_input_city_code=city_code;
		outkind_input_product_code=product_code;
		outkind_input_outkind_code=outkind_code;
		outkind_input_amount=amount;
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
		return outkind_input_date;
	}
	
	public String getCity_code()
	{
		return outkind_input_city_code;
	}
	public void setCity_code(String city_code)
	{
		this.outkind_input_city_code=city_code;
	}
	public String getProduct_code()
	{
		return outkind_input_product_code;
	}
	public void setProduct_code(String product_code)
	{
		this.outkind_input_product_code=product_code;
	}
	public String getOutkind_code()
	{
		return outkind_input_outkind_code;
	}
	public void setOutkind_code(String outkind_code)
	{
		this.outkind_input_outkind_code=outkind_code;
	}
	public double getAmount()
	{
		return outkind_input_amount;
	}
	public void setAmount(double amount)
	{
		this.outkind_input_amount=amount;
	}
	public void setState(String state)
	{
		this.outkind_input_state=state;
	}
	public String getState()
	{
		return outkind_input_state;
	}
	public String toString() {
		return "outkind_input [serial=" + serial + ", outkind_input_date=" + outkind_input_date 
				+ ", outkind_input_city_code=" + outkind_input_city_code+",outkind_input_product_code"
				+outkind_input_product_code+ ",outkind_input_outkind_code"+outkind_input_outkind_code
				+",outkind_input_amount"+outkind_input_amount+",outkind_input_state"+outkind_input_state
				+"]";
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.outkind_input_date=date;
	}
}
