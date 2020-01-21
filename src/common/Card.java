package common;

/**
  * 卡信息表
 * @author new
 *
 */
public class Card {

	private String cardInTime;         //卡录入日期	private String cardCityZip = "";   //城市编码
	private String cardProductId;      //产品编码
	private int cardPrice;             //卡的单价
	private int cardSaleNum;           //卡销售数量	private float cardTotalPrcie;      //卡销售总金额
	private float cardDiscount;        //折扣后金额
	private int cardType;              //card状态：0表示待审查、1表示通过
	private String cardCityName = "";     //城市名称
	private String cardProductName="";    //产品名称

	
	/**
	 *  无参构造函数
	 */
	public Card(){
		
	}
	/**
	 *  有参构造函数	 */
	public Card(String cityZip,String productId,int price,int saleNum,float cardDis){
		this.cardCityZip = cityZip;
		this.cardProductId = productId;
		this.cardSaleNum = saleNum;
		this.cardPrice = price;
		this.cardDiscount=cardDis;
	}
	/**
	 *  有参构造函数(数据归集)
	 */
	public Card(int cardID,String cardInTime,String cityZip,String productId,int saleNum,int price,int cardTotalPrcie,String outKindId,String cardCityName,String cardProductName,String cardOutKindName){

		this.cardInTime = cardInTime;
		this.cardCityZip = cityZip;
		this.cardProductId = productId;
		this.cardSaleNum = saleNum;
		this.cardPrice = price;
		this.cardTotalPrcie = cardTotalPrcie;
		this.cardCityName = cardCityName;
		this.cardProductName = cardProductName;

	}
	
	/**
	 * @return 录入日期
	 */
	public String getCardInTime() {
		return cardInTime;
	}
	/**
	 * @param cardInTime the cardInTime to set
	 */
	public void setCardInTime(String cardInTime) {
		this.cardInTime = cardInTime;
	}
	/**
	 * @return 城市编码
	 */
	public String getCardCityZip() {
		return cardCityZip;
	}
	/**
	 * @param cardCityZip the cardCityZip to set
	 */
	public void setCardCityZip(String cardCityZip) {
		this.cardCityZip = cardCityZip;
	}
	/**
	 * @return 产品编码
	 */
	public String getCardProductId() {
		return cardProductId;
	}
	/**
	 * @param cardProductId the cardProductId to set
	 */
	public void setCardProductId(String cardProductId) {
		this.cardProductId = cardProductId;
	}
	/**
	 * @return 销售数量
	 */
	public int getCardSaleNum() {
		return cardSaleNum;
	}
	/**
	 * @param cardSaleNum the cardSaleNum to set
	 */
	public void setCardSaleNum(int cardSaleNum) {
		this.cardSaleNum = cardSaleNum;
	}
	/**
	 * @return 总价
	 */
	public float getCardTotalPrcie() {
		return cardTotalPrcie;
	}
	/**
	 * @param cardTotalPrcie the cardTotalPrcie to set
	 */
	public void setCardTotalPrcie(float cardTotalPrcie) {
		this.cardTotalPrcie = cardTotalPrcie;
	}
	/**
	 * @return 单价
	 */
	public int getCardPrice() {
		return cardPrice;
	}
	/**
	 * @param cardPrice the cardPrice to set
	 */
	public void setCardPrice(int cardPrice) {
		this.cardPrice = cardPrice;
	}
	/**
	 * @return the cardType
	 */
	public int getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	
	/**
	 * @return the cardCityName
	 */
	public String getCardCityName() {
		return cardCityName;
	}
	/**
	 * @param cardCityName the cardCityName to set
	 */
	public void setCardCityName(String cardCityName) {
		this.cardCityName = cardCityName;
	}
	/**
	 * @return the cardProductName
	 */
	public String getCardProductName() {
		return cardProductName;
	}
	/**
	 * @param cardProductName the cardProductName to set
	 */
	public void setCardProductName(String cardProductName) {
		this.cardProductName = cardProductName;
	}
	
}
