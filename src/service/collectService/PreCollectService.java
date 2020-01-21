package service.collectService;

import java.util.ArrayList;
import common.PreG;
import dao.collectDao.PreCollectDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 张志远
 *
 */
public class PreCollectService {

	PreCollectDao cd = new PreCollectDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<PreG> doSearch(PreG pre){
		System.out.println("服务层查询");
		return cd.doSearch(pre);
	}
	
}
