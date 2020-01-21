package service.collectService;

import java.util.ArrayList;
import common.NoticeG;
import dao.collectDao.NoticeCollectDao;

/**
 * 稽核被servlet调用、自身调用dao
 * @author 郑拓
 *
 */
public class NoticeCollectService {

	NoticeCollectDao cd = new NoticeCollectDao();
	/**
	 * 实现多条件查询card信息
	 * @param card
	 * @return
	 */
	public ArrayList<NoticeG> doSearch(NoticeG notice){
		return cd.doSearch(notice);
	}
	
}
