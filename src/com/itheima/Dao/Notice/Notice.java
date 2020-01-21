package com.itheima.Dao.Notice;

import java.sql.Date;


public class Notice {
	private int serial;
	private Date notice_input_date;
	private String notice_input_city_code;
	private String notice_input_product_code;
	private String notice_input_notice_code;
	private double notice_input_amount;
	private String notice_input_state;
	public Notice()
	{
		super();
	}
	public Notice(Notice notice)
	{
		this.serial=notice.serial;
		this.notice_input_date=notice.notice_input_date;
		this.notice_input_city_code=notice.notice_input_city_code;
		this.notice_input_product_code=notice.notice_input_product_code;
		this.notice_input_notice_code=notice.notice_input_notice_code;
		this.notice_input_amount=notice.notice_input_amount;
		this.notice_input_state=notice.notice_input_state;
		
	}
	public Notice(Date date,String city_code,String product_code,String notice_code,double amount) {
		notice_input_date=date;
		notice_input_city_code=city_code;
		notice_input_product_code=product_code;
		notice_input_notice_code=notice_code;
		notice_input_amount=amount;
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
		return notice_input_date;
	}
	
	public String getCity_code()
	{
		return notice_input_city_code;
	}
	public void setCity_code(String city_code)
	{
		this.notice_input_city_code=city_code;
	}
	public String getProduct_code()
	{
		return notice_input_product_code;
	}
	public void setProduct_code(String product_code)
	{
		this.notice_input_product_code=product_code;
	}
	public String getNotice_code()
	{
		return notice_input_notice_code;
	}
	public void setNotice_code(String outkind_code)
	{
		this.notice_input_notice_code=outkind_code;
	}
	public double getAmount()
	{
		return notice_input_amount;
	}
	public void setAmount(double amount)
	{
		this.notice_input_amount=amount;
	}
	public void setState(String state)
	{
		this.notice_input_state=state;
	}
	public String getState()
	{
		return notice_input_state;
	}
	public String toString() {
		return "notice_input [serial=" + serial + ", notice_input_date=" + notice_input_date 
				+ ", notice_input_city_code=" + notice_input_city_code+",notice_input_product_code"
				+notice_input_product_code+ ",notice_input_outkind_code"+notice_input_notice_code
				+",notice_input_amount"+notice_input_amount+",notice_input_state"+notice_input_state
				+"]";
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.notice_input_date=date;
	}
}
