package com.itheima.Dao.Card;

import java.sql.Date;

import com.itheima.Dao.Outkind.Outkind;

public class Card {

	private int serial;
	private Date card_input_date;
	private String card_input_city_code;
	private String card_input_product_code;
	private int card_input_number;
	private double card_input_price;
	private double card_input_amount;
	private double card_input_discount;
	private String card_input_state;
	public Card()
	{
		super();
	}
	public Card(Date date,String city_code,String product_code,int number,double price,double amount,double discount,String state)
	{
		card_input_date=date;
		card_input_city_code=city_code;
		card_input_product_code=product_code;
		card_input_number=number;
		card_input_price=price;
		card_input_amount=amount;
		card_input_discount=discount;
		card_input_state=state;
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
		return card_input_date;
	}
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.card_input_date=date;
	}
	public String getCity_code()
	{
		return card_input_city_code;
	}
	public void setCity_code(String city_code)
	{
		this.card_input_city_code=city_code;
	}
	public String getProduct_code()
	{
		return card_input_product_code;
	}
	public void setProduct_code(String product_code)
	{
		this.card_input_product_code=product_code;
	}
	public int getNumber()
	{
		return card_input_number;
	}
	public void setNumber(int number)
	{
		this.card_input_number=number;
	}
	public double getPrice()
	{
		return card_input_price;
	}
	public void setPrice(double price)
	{
		this.card_input_price=price;
	}
	public double getAmount()
	{
		return card_input_number*card_input_price;
	}
	public double getAmount(boolean x)
	{
		return card_input_amount;
	}
	public void setAmount(double amount)
	{
		this.card_input_amount=amount;
	}
	public double getDiscount()
	{
		return card_input_discount;
	}
	public void setDiscount(double discount)
	{
		this.card_input_discount=discount;
	}
	public void setState(String state)
	{
		this.card_input_state=state;
	}
	public String getState()
	{
		return card_input_state;
	}
	public String toString() {
		return "card_input [serial=" + serial + ", card_input_date=" + card_input_date 
				+ ", card_input_city_code=" + card_input_city_code+",card_input_product_code="
				+card_input_product_code+ ",card_input_number="+card_input_number+",card_input_price="+
				card_input_price+",card_input_amount="+card_input_amount+",card_input_discount="+card_input_discount+
				",card_input_state"+card_input_state
				+"]";
	}
	
}
