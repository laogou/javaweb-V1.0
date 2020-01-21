package common;

/**
 * 城市编码
 * @author new
 *
 */
public class City {

	private String cityCode = "";    //城市编码
	private String cityName = "";   //城市名称
	/**
	 * 无参构造函数
	 */
	public City(){
		
	}
	/**
	 * 有参构造函数
	 */
	public City(String cityCode,String cityName){
		this.cityCode = cityCode;
		this.cityName = cityName;
	}
	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}
	/**
	 * @param cityZip the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
