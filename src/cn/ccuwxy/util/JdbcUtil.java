package cn.ccuwxy.util;

import java.sql.*;

public class JdbcUtil {
    private Connection conn;
    private Statement stat;
    private ResultSet rs;

    public Connection getConn() {
        return conn;
    }

    public JdbcUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://139.199.105.207/runrun", "root", "1528154605");
            stat = null;
            rs = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(String sql) {
        try {
            conn.setAutoCommit(false);
            stat = conn.createStatement();
            stat.execute(sql);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet excuteQuery(String sql) {
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeDb() {
        try {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
