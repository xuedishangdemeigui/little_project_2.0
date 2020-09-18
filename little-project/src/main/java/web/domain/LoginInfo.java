package web.domain;
/**
  * 封装登录信息
 * @author 张驰
 *
 */
public class LoginInfo {
	
	private String tel;
	private String pwd;
	private String timeStamp;
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "LoginInfo [tel=" + tel + ", pwd=" + pwd + ", timeStamp=" + timeStamp + "]";
	}
	
}
