package com.itheima.service;

import java.util.List;

import com.itheima.Dao.Card.Card;

public interface CardService {

	void addCard(Card card);
	void updateCard(Card card);
	void deleteCard(int serial);
	int getMaxSerial();
	Card getBySerial(int serial);
	List<Card> getAllCard(String[] params);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
}
