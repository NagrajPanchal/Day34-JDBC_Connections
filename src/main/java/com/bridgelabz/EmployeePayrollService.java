package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollService
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/employee_payroll"; // table details
        String username = "root"; // MySQL credentials
        String password = "root";
        String query = "Select min(id),max(id),sum(id),avg(id),count(id)\n" +
                "from employee where gender = \"male\"\n" +
                "group by gender;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
            Statement st = con.createStatement();
            boolean result = st.execute(query);
            if (result) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    int minId = rs.getInt("min(id)");
                    System.out.println("Min : "+minId);
                    int maxId = rs.getInt("max(id)");
                    System.out.println("Max : "+maxId);
                    int sumId = rs.getInt("sum(id)");
                    System.out.println("Sum : "+sumId);
                    int avgId = rs.getInt("avg(id)");
                    System.out.println("Avg : "+avgId);
                    int countId = rs.getInt("count(id)");
                    System.out.println("Count : "+countId);
                }
            } else {
                int rowCount = st.getUpdateCount();
                System.out.println(rowCount);
            }
            st.close(); // close statement
            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
