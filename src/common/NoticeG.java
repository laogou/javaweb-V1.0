package common;

public class NoticeG {
	private Integer noticeserial;       //出账编号 
	private String noticedate;         //出账收入录入日期
	private String noticeCityCode;       //城市编码
	private String noticeProductCode;    //产品编码
	private String noticeNoticeCode;         //通知单编码
	private int noticeType;              //状态：0表示待审查、1表示通过
	private float noticeAmount;          //通知单金额
	private String noticeCityName = "";     //城市名称
	private String noticeProductName = "";    //产品名称
	private String noticeNoticeName = "";    //通知单名字
	//生成函数
	public Integer getNoticeserial() {
		return noticeserial;
	}
	public void setNoticeserial(Integer noticeserial) {
		this.noticeserial = noticeserial;
	}
	public String getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
	}
	public String getNoticeCityCode() {
		return noticeCityCode;
	}
	public void setNoticeCityCode(String noticeCityCode) {
		this.noticeCityCode = noticeCityCode;
	}
	public String getNoticeProductCode() {
		return noticeProductCode;
	}
	public void setNoticeProductCode(String noticeProductCode) {
		this.noticeProductCode = noticeProductCode;
	}
	public String getNoticeNoticeCode() {
		return noticeNoticeCode;
	}
	public void setNoticeNoticeCode(String noticeNoticeCode) {
		this.noticeNoticeCode = noticeNoticeCode;
	}
	public int getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(int noticeType) {
		this.noticeType = noticeType;
	}
	public float getNoticeAmount() {
		return noticeAmount;
	}
	public void setNoticeAmount(float noticeAmount) {
		this.noticeAmount = noticeAmount;
	}
	public String getNoticeCityName() {
		return noticeCityName;
	}
	public void setNoticeCityName(String noticeCityName) {
		this.noticeCityName = noticeCityName;
	}
	public String getNoticeProductName() {
		return noticeProductName;
	}
	public void setNoticeProductName(String noticeProductName) {
		this.noticeProductName = noticeProductName;
	}
	public String getNoticeNoticeName() {
		return noticeNoticeName;
	}
	public void setNoticeNoticeName(String noticeNoticeName) {
		this.noticeNoticeName = noticeNoticeName;
	}
}
