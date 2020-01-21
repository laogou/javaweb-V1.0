package common;

/**
  * 出账收入信息表（个体）
 * @author new
 *
 */
public class AccountG {
	private Integer accountserial;       //出账编号 
	private String accountdate;         //出账收入录入日期
	private String accountCityCode;       //城市编码
	private String accountProductCode;    //产品编码
	private String accountOutKindCode;    //出账类型编码
	private float accountNum;              //出账收入金额
	private int accountType;              //状态：0表示待审查、1表示通过
	private String accountCityName = "";     //城市名称
	private String accountProductName = "";    //产品名称
	private String accountOutKindName = "";    //出账类型名字

	
	
	/**
	 *  无参构造函数

	 */
	public AccountG(){
		
	}
	/**
	 *  有参构造函数
	 */
	public AccountG(String cityCode,String productCode,String outkindCode,float accountnum){
		this.accountCityCode = cityCode;
		this.accountProductCode = productCode;
		this.accountOutKindCode = outkindCode;
		this.accountNum = accountnum;
	}
	/**
	 *  有参构造函数(数据归集)
	 */
	public AccountG(int accountID,String accountTime,String cityCode,String productCode,float num,String outKindCode,String accountCityName,String accountProductName,String accontOutKindName){

		this.accountdate = accountTime;
		this.accountCityCode = cityCode;
		this.accountProductCode = productCode;
		this.accountNum = num;
		this.accountCityName = accountCityName;
		this.accountProductName = accountProductName;

	}
	//生成的get和set函数
	public Integer getAccountserial() {
		return accountserial;
	}
	public void setAccountserial(Integer accountserial) {
		this.accountserial = accountserial;
	}
	public String getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(String accountdate) {
		this.accountdate = accountdate;
	}
	public String getAccountCityCode() {
		return accountCityCode;
	}
	public void setAccountCityCode(String acountCityCode) {
		this.accountCityCode = acountCityCode;
	}
	public String getAccountProductCode() {
		return accountProductCode;
	}
	public void setAccountProductCode(String accountProductCode) {
		this.accountProductCode = accountProductCode;
	}
	public String getAccountOutKindCode() {
		return accountOutKindCode;
	}
	public void setAccountOutKindCode(String accountOutKindCode) {
		this.accountOutKindCode = accountOutKindCode;
	}
	public float getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(float accountNum) {
		this.accountNum = accountNum;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public String getAccountCityName() {
		return accountCityName;
	}
	public void setAccountCityName(String accountCityName) {
		this.accountCityName = accountCityName;
	}
	public String getAccountProductName() {
		return accountProductName;
	}
	public void setAccountProductName(String accountProductName) {
		this.accountProductName = accountProductName;
	}
	public String getAccountOutKindName() {
		return accountOutKindName;
	}
	public void setAccountOutKindName(String accountOutKindName) {
		this.accountOutKindName = accountOutKindName;
	}
}


