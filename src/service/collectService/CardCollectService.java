package service.collectService;

import java.util.ArrayList;

import common.CardG;
import dao.collectDao.CardCollectDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author new
 *
 */
public class CardCollectService {

	CardCollectDao cd = new CardCollectDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<CardG> doSearch(CardG card){
		return cd.doSearch(card);
	}
}
