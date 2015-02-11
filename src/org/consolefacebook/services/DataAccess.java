package org.consolefacebook.services;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataAccess
{

    private String servername = "localhost";
    private int port = 3306;
    private String dbname = "facebook";
    private String username = "root";
    private String password = "";
    private String connectionString = "jdbc:mysql://localhost/facebook";
    private String driverName="com.mysql.jdbc.Driver";

    public DataAccess(){}

    public DataAccess(String servername, int port, String dbname, String username, String password)
    {
        this.servername = servername;
        this.port = port;
        this.dbname = dbname;
        this.username = username;
        this.password = password;
    }

    public void setServerName(String servername)
    {
        this.servername = servername;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setDatabaseName(String dbname)
    {
        this.dbname = dbname;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public ResultSet getResultSet(String sql)
    {
        try
        {

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(this.connectionString, this.username, this.password);
            Statement stm=con.createStatement();
            ResultSet result = stm.executeQuery(sql);
            return result;
        }
        catch(Exception exp)
        {

            exp.printStackTrace();
        }

        return null;
    }

    public boolean executeSQL(String sql)
    {
        boolean result=false;

        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(this.connectionString, this.username, this.password);
            Statement stm= con.createStatement();
           // System.out.println(sql);
            result = stm.execute(sql);
            con.close();
        }
        catch(Exception exp)
        {
            System.out.println(exp.getMessage());
            //exp.printStackTrace();
        }

        return result;
    }

    public Connection getConnection()
    {
        Connection con =null;

        try
        {
            Class.forName(driverName);
            con = DriverManager.getConnection(this.connectionString, this.username, this.password);

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

    public static void main(String []args){

        /*DataAccess dataAccess = new DataAccess();

        String sql = "INSERT INTO USER_LOGIN (USER_NAME,EMAIL,PASSWORD,ACTIVE) VALUES('asif','asif@gmail.com','123456',1)";

        dataAccess.executeSQL(sql);

        sql = "SELECT * FROM USER_LOGIN";

        ResultSet rs = dataAccess.getResultSet(sql);

        System.out.println("HEllO");

        try{

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("USER_ID");
                String username = rs.getString("USER_NAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Username: " + username);
                System.out.print(", Email: " + email);
                System.out.println(", Password: " + password);
            }

        }catch (Exception ex){

            ex.printStackTrace();
        }*/

    }
}

