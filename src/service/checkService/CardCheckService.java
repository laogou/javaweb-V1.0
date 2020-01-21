package service.checkService;

import java.util.ArrayList;

import common.CardG;
import dao.checkDao.CardCheckDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author new
 *
 */
public class CardCheckService {

	CardCheckDao cd = new CardCheckDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<CardG> doSearch(CardG card){
		return cd.doSearch(card);
	}
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<CardG> list){
		cd.doUpdate(list);
	}
}
