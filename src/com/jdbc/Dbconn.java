package com.jdbc;

import java.sql.*;
import java.util.*;

public class Dbconn {
    final static String driver = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/mytest?characterEncoding=utf8";
    final static String user = "root";
    final static String password = "root";
    
    static {
        try {
            Class.forName(driver); //������������
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconn() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);//�������Ӷ���
        return conn;
    }

    public static void closeconn(Connection conn) throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close(); //�ر�����
        }
    }
}
