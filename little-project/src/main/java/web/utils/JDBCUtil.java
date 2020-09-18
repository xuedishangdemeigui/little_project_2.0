package web.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * �ļ��Ķ�ȡ��ֻ��Ҫ��ȡһ�Σ����ɻ����Щֵ�����þ�̬�����
     */
    static {
        //��ȡ��Դ�ļ�����ȡֵ
        //1.����Properties������
        Properties pro=new Properties();
        try {
            //��ȡsrc·���µ��ļ��ķ�ʽ------>ClassLoader
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URI res = null;
            try {
                res = classLoader.getResource("JDBC.properties").toURI();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String path = res.getPath();
            //System.out.println("path: "+path);
            //2.�����ļ�
            pro.load(new FileReader(path));
            //3.��ȡ���ԣ���ֵ
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //4.ע������
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡ����
     * @return ���Ӷ���
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    /**
     * �ͷ���Դ
     * @param conn
     * @param stmt
     */
    public static void close(Connection conn, Statement stmt){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * �ͷ���Դ
     * @param rs
     * @param conn
     * @param stmt
     */
    public static void close(ResultSet rs,Connection conn, Statement stmt){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
