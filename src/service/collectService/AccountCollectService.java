package service.collectService;

import java.util.ArrayList;

import common.AccountG;
import dao.collectDao.AccountCollectDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 郑拓
 *
 */
public class AccountCollectService {

	AccountCollectDao cd = new AccountCollectDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<AccountG> doSearch(AccountG account){
		return cd.doSearch(account);
	}
}
