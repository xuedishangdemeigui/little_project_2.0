package web.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web.dao.LoginDao;
import web.domain.LoginInfo;
import web.utils.JDBCUtil;

public class LoginDaoImpl implements LoginDao{

	public boolean findUserByTel(LoginInfo logininfo) {
		Connection conn=null;
		Statement stmt=null;
        ResultSet rs=null;
        boolean result=false;
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.createStatement();
			String sql="select * from user_tel_pwd where tel = '"+logininfo.getTel()+"' and pwd = '"+logininfo.getPwd()+"'";
            System.out.println(sql);
            rs=stmt.executeQuery(sql);
            result=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,conn,stmt);
		}
		return result;
	}

	
	
}
