package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Card.Card;
import com.itheima.Dao.Card.CardDao;
import com.itheima.Dao.Card.CardDaoImpl;

public class CardServiceImpl implements CardService{
	
	public void addCard(Card card)
	{
		CardDao dd=new CardDaoImpl();
		dd.addCard(card);
	}
	public void updateCard(Card card)
	{
		CardDao dd=new CardDaoImpl();
		dd.updateCard(card);
	}
	public void deleteCard(int serial)
	{
		CardDao dd=new CardDaoImpl();
		dd.deleteCard(serial);
	}
	public int getMaxSerial()
	{
		CardDao dd=new CardDaoImpl();
		return dd.getMaxSerial();
	}
	public Card getBySerial(int serial)
	{
		CardDao dd=new CardDaoImpl();
		return dd.getBySerial(serial);
	}
	public List<Card> getAllCard(String[] params)
	{
		CardDao dd=new CardDaoImpl();
		return dd.getAllCard(params);
	}
	public String getCity_code(String city_name)
	{
		CardDao dd=new CardDaoImpl();
		return dd.getCity_code(city_name);
	}
	public String getProduct_code(String product_name)
	{
		CardDao dd=new CardDaoImpl();
		return dd.getProduct_code(product_name);
	}

}
