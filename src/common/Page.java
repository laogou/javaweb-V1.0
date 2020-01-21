package common;
/**
 * 分页实体
 * @author new
 *
 */
public class Page {

	private int totalPage;      //总页数
	private int currentPage;    //当前页数
	private int totalRecord;    //总的记录条数
	private int currentRecord;  //当前的记录条数
	private int pageSize = 5;  //每页显示的记录数量
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalRecord,int pageSize) {
		//如果总记录数除以每页显示条数可以整除，商就是总页码
		if(totalRecord % pageSize == 0){
			this.totalPage = totalRecord/pageSize;
		}else{
		//如果总记录除数以每页显示条数不能整除，商加1才是总页码
			this.totalPage = totalRecord/pageSize + 1;
		}
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentRecord,int pageSize) {
		//如果当前记录数除以每页显示的条数可以整除、商就是当前的页码
		if(currentRecord%pageSize == 0){
			this.currentPage = currentRecord/pageSize;
		}else{
			//如果当前记录数除以每页显示的条数不能整除、商加1就是当前的页码
			this.currentPage = currentRecord/pageSize+1;
		}
	}
	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	/**
	 * @return the currentRecord
	 */
	public int getCurrentRecord() {
		return currentRecord;
	}
	/**
	 * @param currentRecord the currentRecord to set
	 */
	public void setCurrentRecord(int currentRecord) {
		this.currentRecord = currentRecord;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
