package com.test.web.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUtil {
    private static Connection connection = null;
    private static Statement statement = null;

    private final static String createDepartment =
            "CREATE TABLE IF NOT EXISTS my_data_base.department   (\n" +
                    "  `departmentId` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `departmentName` varchar(50) NOT NULL,\n" +
                    "  PRIMARY KEY (`departmentId`)\n" +

                    ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8";


    private final static String createEmployee = "CREATE TABLE IF NOT EXISTS my_data_base.employee (\n" +
            "  `employeeId` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `firstName` varchar(50) NOT NULL,\n" +
            "  `lastName` varchar(50) NOT NULL,\n" +
            "  `saleItems` int(50) NOT NULL,\n" +
            "  `email` varchar(50) NOT NULL,\n" +
            "  `registrDate` date NOT NULL,\n" +
            "  `departmentId` int(11) NOT NULL,\n" +
            "  PRIMARY KEY (`employeeId`),\n" +

            "  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`) ON DELETE CASCADE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

    public static Connection getConnection()  {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/my_data_base";
                String user = "root";
                String password = "0000";

                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
                statement.executeUpdate(createDepartment);
                statement.executeUpdate(createEmployee);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            }
            return connection;
        }

    }

