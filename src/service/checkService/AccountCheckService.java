package service.checkService;

import java.util.ArrayList;

import common.AccountG;
import dao.checkDao.AccountCheckDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 张志远
 *
 */
public class AccountCheckService {

	AccountCheckDao cd = new AccountCheckDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<AccountG> doSearch(AccountG account){
		return cd.doSearch(account);
	}
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<AccountG> list){
		cd.doUpdate(list);
	}
}
