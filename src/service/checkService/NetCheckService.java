package service.checkService;

import java.util.ArrayList;
import common.NetG;
import dao.checkDao.NetCheckDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 张志远
 *
 */
public class NetCheckService {

	NetCheckDao cd = new NetCheckDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<NetG> doSearch(NetG net){
		return cd.doSearch(net);
	}
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<NetG> list){
		cd.doUpdate(list);
	}
}
