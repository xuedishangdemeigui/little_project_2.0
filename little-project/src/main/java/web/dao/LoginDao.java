package web.dao;

import web.domain.LoginInfo;

public interface LoginDao {
	public boolean findUserByTel(LoginInfo loginInfo);
}
