package web.domain;
/**
 * 用来封装登录结果信息
 * @author 张驰
 *
 */
public class LoginResult {
	private String statusCode;
	private String msg;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "LoginResult [statusCode=" + statusCode + ", msg=" + msg + "]";
	}
	
	
	
}
