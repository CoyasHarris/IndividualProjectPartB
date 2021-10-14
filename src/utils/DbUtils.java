/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Akaros
 */
public class DbUtils {
    
    
    private static final String MYSQLURL = "jdbc:mysql://localhost:3306/individual_project_part_b"
           + "?zeroDateTimeBehavior=CONVERT_TO_NULL"
           + "&useUnicode=true"
           + "&useJDBCCompliantTimezoneShift=true"
           + "&useLegacyDatetimeCode=false"
           + "&serverTimezone=UTC"
           + "&allowPublicKeyRetrieval=true"
           + "&useSSL=false";
    
     private static  String username = "root";
     private static  String password = "BmwGsa1150";
    
    public static Connection getConnection() throws SQLException{
         Connection con = null;
         con = DriverManager.getConnection(MYSQLURL, username, password);
        return con;
    }
}
