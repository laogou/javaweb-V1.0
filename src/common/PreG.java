package common;

public class PreG {
	private Integer preserial;       //出账编号 
	private String predate;         //出账收入录入日期
	private String preCityCode;       //城市编码
	private String preProductCode;    //产品编码
	private String preCancelCode;        //销账类型编码
	private float preamount;         //销账金额
	private int preType;              //状态：0表示待审查、1表示通过
	private String preCityName = "";     //城市名称
	private String preProductName = "";    //产品名称
	private String preCancelName = "";    //销账名字
	//get和set函数
	public Integer getPreserial() {
		return preserial;
	}
	public void setPreserial(Integer preserial) {
		this.preserial = preserial;
	}
	public String getPredate() {
		return predate;
	}
	public void setPredate(String predate) {
		this.predate = predate;
	}
	public String getPreCityCode() {
		return preCityCode;
	}
	public void setPreCityCode(String preCityCode) {
		this.preCityCode = preCityCode;
	}
	public String getPreProductCode() {
		return preProductCode;
	}
	public void setPreProductCode(String preProductCode) {
		this.preProductCode = preProductCode;
	}
	public float getPreamount() {
		return preamount;
	}
	public void setPreamount(float preamount) {
		this.preamount = preamount;
	}
	public int getPreType() {
		return preType;
	}
	public void setPreType(int preType) {
		this.preType = preType;
	}
	public String getPreCityName() {
		return preCityName;
	}
	public void setPreCityName(String preCityName) {
		this.preCityName = preCityName;
	}
	public String getPreProductName() {
		return preProductName;
	}
	public void setPreProductName(String preProductName) {
		this.preProductName = preProductName;
	}
	public String getPreCancelName() {
		return preCancelName;
	}
	public void setPreCancelName(String preCancelName) {
		this.preCancelName = preCancelName;
	}
	public String getPreCancelCode() {
		return preCancelCode;
	}
	public void setPreCancelCode(String preCancelCode) {
		this.preCancelCode = preCancelCode;
	}
}
