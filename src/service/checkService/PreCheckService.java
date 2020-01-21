package service.checkService;

import java.util.ArrayList;
import common.PreG;
import dao.checkDao.PreCheckDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 张志远
 *
 */
public class PreCheckService {

	PreCheckDao cd = new PreCheckDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<PreG> doSearch(PreG pre){
		return cd.doSearch(pre);
	}
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<PreG> list){
		cd.doUpdate(list);
	}
}
