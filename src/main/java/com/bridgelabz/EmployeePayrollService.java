package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollService
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/employee_payroll"; // table details
        String username = "root"; // MySQL credentials
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
            PreparedStatement st = con.prepareStatement("Select min(id),max(id),avg(id),count(id),sum(id) \n" +
                    "from employee where gender = ?" +
                    "group by gender;");
            st.setString(1,"male");
            boolean result = st.execute();
            if (result) {
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    int id = rs.getInt("id"); // Retrieve name from db
                    System.out.println(id); // Print result on console
                    String name = rs.getString("name"); // Retrieve name from db
                    System.out.println(name); // Print result on console
                    String gender = rs.getString("gender"); // Retrieve name from db
                    System.out.println(gender); // Print result on console
                    String city = rs.getString("city"); // Retrieve name from db
                    System.out.println(city); // Print result on console
                    String email = rs.getString("email"); // Retrieve name from db
                    System.out.println(email); // Print result on console
                }
            } else {
                int rowCount = st.getUpdateCount();
                System.out.println(rowCount);
            }
            st.close(); // close statement
            con.close(); // close connection
            System.out.println("Connection Closed....");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Catch Block");
        }
    }
}
