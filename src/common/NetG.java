package common;

public class NetG {
	private Integer netserial;       //出账编号 
	private String netdate;         //出账收入录入日期
	private String netCityCode;       //城市编码
	private String netProductCode;    //产品编码
	private String netOperatorCode;    //运营商编码
	private String netSettleCode;    //结算编码
	private float netAmount;    //结算金额
	private int netType;              //状态：0表示待审查、1表示通过
	private String netCityName = "";     //城市名称
	private String netProductName = "";    //产品名称
	private String netOperatorName = "";    //运营商名字
	private String netSettleName = "";    //运营商名字
	public Integer getNetserial() {
		return netserial;
	}
	public void setNetserial(Integer netserial) {
		this.netserial = netserial;
	}
	public String getNetdate() {
		return netdate;
	}
	public void setNetdate(String netdate) {
		this.netdate = netdate;
	}
	public String getNetCityCode() {
		return netCityCode;
	}
	public void setNetCityCode(String netCityCode) {
		this.netCityCode = netCityCode;
	}
	public String getNetProductCode() {
		return netProductCode;
	}
	public void setNetProductCode(String netProductCode) {
		this.netProductCode = netProductCode;
	}
	public String getNetOperatorCode() {
		return netOperatorCode;
	}
	public void setNetOperatorCode(String netOperatorCode) {
		this.netOperatorCode = netOperatorCode;
	}
	public String getNetSettleCode() {
		return netSettleCode;
	}
	public void setNetSettleCode(String netSettleCode) {
		this.netSettleCode = netSettleCode;
	}
	public int getNetType() {
		return netType;
	}
	public void setNetType(int netType) {
		this.netType = netType;
	}
	public String getNetCityName() {
		return netCityName;
	}
	public void setNetCityName(String netCityName) {
		this.netCityName = netCityName;
	}
	public String getNetProductName() {
		return netProductName;
	}
	public void setNetProductName(String netProductName) {
		this.netProductName = netProductName;
	}
	public String getNetOperatorName() {
		return netOperatorName;
	}
	public void setNetOperatorName(String netOperatorName) {
		this.netOperatorName = netOperatorName;
	}
	public String getNetSettleName() {
		return netSettleName;
	}
	public void setNetSettleName(String netSettleName) {
		this.netSettleName = netSettleName;
	}
	public float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}
}
