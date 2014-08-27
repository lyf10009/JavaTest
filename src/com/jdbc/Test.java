package com.jdbc;

import java.sql.*;

public class Test {

    public static void main(String[] args) {
        Dao dao = new Dao();
        try {
            dao.Insert();
//            dao.printAllStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
