package web.domain;
/**
 * ������װ��¼�����Ϣ
 * @author �ų�
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
