package com.company.movierating.main;

import com.company.movierating.dao.connectionpool.ConnectionPool;
import com.company.movierating.dao.connectionpool.ConnectionPoolException;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, ConnectionPoolException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/movies_rating?useUnicode=true&serverTimezone=UTC&useSSL=false","root", "4fgb");
        System.out.println("ОК");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movies");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
            rs.getString(2) + " " +
            rs.getInt(3) + " " +
            rs.getString(4));
        }

        rs.close();
        st.close();
        con.close();*/


        ConnectionPool cp = ConnectionPool.connect();
        cp.initPoolData();
        Connection connection = cp.takeConnection();


        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movies");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3) + " " +
                    rs.getString(4));
        }

    }

}
