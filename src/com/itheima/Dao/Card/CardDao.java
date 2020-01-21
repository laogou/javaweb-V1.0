package com.itheima.Dao.Card;

import java.util.List;

public interface CardDao {

	void addCard(Card card);
	void updateCard(Card card);
	void deleteCard(int serial);
	int getMaxSerial();
	List<Card> getAllCard(String[] params);
	Card getBySerial(int serial);
	String getCity_code(String city_name);
	String getProduct_code(String product_name);
}
