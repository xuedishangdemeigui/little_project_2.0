package web.service;

import web.domain.LoginInfo;

public interface LoginService {
	//用户登录时调用
	public boolean login(LoginInfo loginInfo);
}
