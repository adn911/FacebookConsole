package org.consolefacebook.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class DatabaseConnectionPool {

    private static DataSource dataSource;
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionPool.class);

    static {

       // System.out.println("STATIC INITIALIZER..");

        final ResourceBundle config = ResourceBundle.getBundle("props/db");
        DRIVER_NAME = config.getString("jdbc.driver");
        URL = config.getString("jdbc.url.address");
        USER_NAME = config.getString("db.user");
        PASSWORD = config.getString("db.password");


        try {
            dataSource = setupDataSource();
         //   System.out.println("STATIC INITIALIZER..");
        } catch (PropertyVetoException e) {

            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {

        Connection conn = null;
        try {
           conn =  dataSource.getConnection();

        } catch (SQLException e) {

            System.out.println("PROBLEM CREATING CONNECTION .. COULDN't CONNECT TO THE DATA SOURCE");
            e.printStackTrace();
        }

        return conn;
    }

    private static DataSource setupDataSource() throws PropertyVetoException {

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setDriverClass(DRIVER_NAME);
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER_NAME);
        comboPooledDataSource.setPassword(PASSWORD);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        return comboPooledDataSource;
    }

}