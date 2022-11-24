package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollService
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/employee_payroll"; // table details
        String username = "root"; // MySQL credentials
        String password = "root";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully "+connection);
        } catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("Catch Block");
        }
    }
}
