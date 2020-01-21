package service.collectService;

import java.util.ArrayList;
import common.NetG;
import dao.collectDao.NetCollectDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 郑拓
 *
 */
public class NetCollectService {

	NetCollectDao cd = new NetCollectDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<NetG> doSearch(NetG net){
		return cd.doSearch(net);
	}
}
