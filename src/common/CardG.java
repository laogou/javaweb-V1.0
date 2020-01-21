package common;

/**
  * 卡销售收入信息表（个体）
 * @author new
 *
 */
public class CardG {
	private Integer cardserial;     //卡的编号
	private String carddate;         //卡销售收入录入日期
	private String cardCityCode;   //录入的城市编码
	private String cardProductCode;    //产品编码
	//private String cardOutKindCode;    //出账类型编码
	private int cardNum;              //卡销售数量
	private int cardPrice;          //面值金额
	private int cardAmount;       //卡总金额，通过计算自动算出
	private float cardDisamount;   //卡折扣后金额
	private int cardState;              //状态：0表示待审查、1表示通过
	private String cardCityName = "";     //城市名称
	private String cardProductName="";    //产品名称
	//private String cardOutKindName;    //出账类型名字

	
	
	/**
	 *  无参构造函数

	 */
	public CardG(){
		
	}
	/**
	 *  有参构造函数
	 */
	public CardG(String cityCode,String productCode,int cardPrice,int cardNum,float cardDisamount){
		this.cardCityCode = cityCode;
		this.cardProductCode = productCode;
		this.cardPrice = cardPrice;
		this.cardNum=cardNum;
		this.cardAmount=cardPrice*cardNum;
		this.cardDisamount=cardDisamount;
	}
	/**
	 *  有参构造函数(数据归集)
	 */
	public CardG(int accountID,String cardTime,String cityCode,String productCode,int cardNum,int cardPrice,float cardDisamount,String cardCityName,String cardProductName){

		this.carddate = cardTime;
		this.cardCityCode = cityCode;
		this.cardProductCode = productCode;
		this.cardNum = cardNum;
		this.cardPrice=cardPrice;
		this.cardAmount=cardNum*cardPrice;
		this.cardDisamount=cardDisamount;
		this.cardCityName = cardCityName;
		this.cardProductName = cardProductName;

	}
	//生成的get和set函数
	public Integer getCardserial() {
		return cardserial;
	}
	public void setCardserial(Integer cardserial) {
		this.cardserial = cardserial;
	}
	public String getCarddate() {
		return carddate;
	}
	public void setCarddate(String carddate) {
		this.carddate = carddate;
	}
	public String getCardCityCode() {
		return cardCityCode;
	}
	public void setCardCityCode(String cardCityCode) {
		this.cardCityCode = cardCityCode;
	}
	public String getCardProductCode() {
		return cardProductCode;
	}
	public void setCardProductCode(String cardProductCode) {
		this.cardProductCode = cardProductCode;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public int getCardPrice() {
		return cardPrice;
	}
	public void setCardPrice(int cardPrice) {
		this.cardPrice = cardPrice;
	}
	public int getCardAmount() {
		return cardAmount;
	}
	public void setCardAmount(int cardAmount) {
		this.cardAmount = cardAmount;
	}
	public float getCardDisamount() {
		return cardDisamount;
	}
	public void setCardDisamount(float cardDisamount) {
		this.cardDisamount = cardDisamount;
	}
	public int getCardState() {
		return cardState;
	}
	public void setCardState(int cardState) {
		this.cardState = cardState;
	}
	public String getCardCityName() {
		return cardCityName;
	}
	public void setCardCityName(String cardCityName) {
		this.cardCityName = cardCityName;
	}
	public String getCardProductName() {
		return cardProductName;
	}
	public void setCardProductName(String cardProductName) {
		this.cardProductName = cardProductName;
	}
	
	
}


