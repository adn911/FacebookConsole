package org.consolefacebook.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author: therapJavaFestTeam
 * @since: 10/2/12 4:11 PM
 */
public class DatabaseTemplate {

   // private static final Logger log = LoggerFactory.getLogger(DatabaseTemplate.class);

    public static void execute(String query) {
        Connection conToUse = null;
        Statement stmt = null;

        try {

            conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            stmt.executeQuery(query);

        } catch (SQLException e) {

            e.printStackTrace();
            //throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
            } catch (SQLException e) {

                e.printStackTrace();
                //throw new RuntimeException(e);
            }

            closeConnection(conToUse);

        }
    }

    public static <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper) {
        Connection conToUse = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try {
            conToUse = DatabaseConnectionPool.getConnection();
            stmt = conToUse.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                resultSet.close();
                stmt.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }


        }
        return listOfE;
    }

    public static <E> List<E> queryForObject(String query, ObjectRowMapper<E> objectRowMapper,Object ...params) {

        Connection conToUse = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();

        try {

            if(conToUse == null)
            conToUse = DatabaseConnectionPool.getConnection();

            stmt = conToUse.prepareStatement(query);

            for(int i=0;i<params.length;i++)
            {
                stmt.setObject(i+1,params[i]);
            }

            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                listOfE.add(objectRowMapper.mapRowToObject(resultSet));
            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                resultSet.close();
                stmt.close();
            } catch (SQLException e) {

                e.printStackTrace();

              //  throw new RuntimeException(e);
            }

            closeConnection(conToUse);
        }

       // System.out.println(listOfE.size());
        return listOfE;
    }

    public static boolean executeQuery(String query, Object... parameters) {

        boolean returnValue = false;
        Connection conToUse = null;
        PreparedStatement preparedStatement = null;
        try {
            conToUse = DatabaseConnectionPool.getConnection();
            preparedStatement = conToUse.prepareStatement(query);

            for (int i = 0;i<parameters.length;i++) {
               preparedStatement.setObject(i+1,parameters[i]);
            }

            returnValue = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {

                preparedStatement.close();
            } catch (SQLException e) {
                closeConnection(conToUse);
                throw new RuntimeException(e);
            }
        }

        return returnValue;
    }

    private static void closeConnection(Connection conToClose) {
        try {
           // System.out.println("CLOSING CONNECTION..");
            conToClose.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
