package web.service.impl;

import web.dao.LoginDao;
import web.dao.impl.LoginDaoImpl;
import web.domain.LoginInfo;
import web.service.LoginService;

public class LoginServiceImpl implements LoginService{
	private LoginDao loginDao= new LoginDaoImpl();
	public boolean login(LoginInfo loginInfo) {
		return loginDao.findUserByTel(loginInfo);
	}
}
