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
     * 文件的读取，只需要读取一次，即可获得这些值，采用静态代码块
     */
    static {
        //读取资源文件，获取值
        //1.创建Properties集合类
        Properties pro=new Properties();
        try {
            //获取src路径下的文件的方式------>ClassLoader
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URI res = null;
            try {
                res = classLoader.getResource("JDBC.properties").toURI();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String path = res.getPath();
            //System.out.println("path: "+path);
            //2.加载文件
            pro.load(new FileReader(path));
            //3.获取属性，赋值
            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    /**
     * 释放资源
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
     * 释放资源
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
