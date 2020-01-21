package service.checkService;

import java.util.ArrayList;
import common.NoticeG;
import dao.checkDao.NoticeCheckDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 张志远
 *
 */
public class NoticeCheckService {

	NoticeCheckDao cd = new NoticeCheckDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<NoticeG> doSearch(NoticeG notice){
		return cd.doSearch(notice);
	}
	/**
	 * 实现稽核返回稽核情况
	 * @param card
	 */
	public void doUpdate(ArrayList<NoticeG> list){
		cd.doUpdate(list);
	}
}
