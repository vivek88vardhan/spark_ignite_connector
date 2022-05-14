package com.vivek;

import org.apache.ignite.Ignition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StartIgniteThinDriverConnect {

    public static void main(String args[]) throws Exception {
        Ignition.start("/Users/vivek/Documents/spaceandtime/apache-ignite-2.13.0-bin/examples/config/example-ignite.xml");
        Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
        String sql1 = "select * from City";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql1);
        while ( resultSet.next())
            System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2));

    }
}
