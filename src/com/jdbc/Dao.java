package com.jdbc;

import java.sql.*;

public class Dao {
    public void printAllStudents() throws SQLException {
        Connection conn = null;
        conn = Dbconn.getconn();
        if (conn != null) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select sno,sname,ssex,sage from students");
            while (rs.next()) {
                System.out.print(rs.getString(1) + ",");
                System.out.print(rs.getString(2) + ",");
                System.out.print(rs.getString(3) + ",");
                System.out.print(rs.getString("sage"));
                System.out.print("\n");
            }
        } else {
            System.out.print("connection wrong");
        }
        Dbconn.closeconn(conn);
    }

    //update
    public int Update() throws SQLException {
        Connection conn = null;
        conn = Dbconn.getconn();
        int result = 0;
        if (conn != null) {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate("update students set sage=sage+1");
            Dbconn.closeconn(conn);
        }
        return result;
    }

    //delete
    public int Delete() throws SQLException {
        Connection conn = null;
        conn = Dbconn.getconn();
        int result = 0;
        if (conn != null) {
            Statement stm = conn.createStatement();
            result = stm.executeUpdate("delete from students where sno='2009005'");
            Dbconn.closeconn(conn);
        }
        return result;
    }

    //Statement   
    public int Insert() throws SQLException {
        Connection conn = null;
        conn = Dbconn.getconn();
        int result = 0;
        if (conn != null) {
            Statement stm = conn.createStatement();
            result =
                stm.executeUpdate("insert into students(sno,sname,sage,ssex,spe_id)value('2009005','xixi','19','男','0102')");
            Dbconn.closeconn(conn);
            System.out.println("insert success!!!");
        }
        return result;
    }

    //PreparedStatement
    public int InsertData(String sno, String sname, int sage, String ssex, String spe_id)
            throws SQLException {
        Connection conn = null;
        conn = Dbconn.getconn();
        int result = 0;
        if (conn != null) {
            String sql = "insert into students(sno,sname,sage,ssex,spe_id)value(?,?,?,?,?)";           
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, sno);//index start from 1
            pstm.setString(2, sname);
            pstm.setInt(3, sage);
            pstm.setString(4, ssex);
            pstm.setString(5, spe_id);
            result = pstm.executeUpdate();
            Dbconn.closeconn(conn);
        }
        return result;
    }
}
