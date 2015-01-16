package com.test.web.dao.imp;


import com.test.web.dao.EmployeeDao;
import com.test.web.model.Employee;
import com.test.web.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImp implements EmployeeDao {

    private Connection connection;

    public EmployeeDaoImp()  {
        connection = DbUtil.getConnection();
    }

    @Override
    public void addEmployee(Employee employee)  {

        try {


            PreparedStatement preparedStatement = connection.prepareStatement("insert into  employee  (employeeId,firstName,lastName,saleItems,email,registrDate,departmentId)values (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setInt(4, Integer.parseInt(employee.getSaleItems()));
            preparedStatement.setString(5, employee.getEmail());
            preparedStatement.setDate(6, java.sql.Date.valueOf(employee.getRegistrDate()));
            preparedStatement.setInt(7, employee.getDepartmentId());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee)  {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("update employee set firstName=?,lastName=?,saleItems=?,email=?,registrDate=?" + "where departmentId=? and employeeId=?");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, Integer.parseInt(employee.getSaleItems()));
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setDate(5, java.sql.Date.valueOf(employee.getRegistrDate()));
            preparedStatement.setInt(6, employee.getDepartmentId());
            preparedStatement.setInt(7, employee.getEmployeeId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Employee> getAllEmployeeDepartmentById(int departmentId) {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {

            PreparedStatement ps = connection.prepareStatement("select * from employee where departmentId=? ");

            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Employee employee = new Employee();

                employee.setEmployeeId(rs.getInt("employeeId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setSaleItems(rs.getString("saleItems"));
                employee.setEmail(rs.getString("email"));
                employee.setRegistrDate(rs.getString("registrDate"));
                employee.setDepartmentId(rs.getInt("departmentId"));


                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from employee where employeeId=?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                employee.setEmployeeId(rs.getInt("employeeId"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setSaleItems(rs.getString("saleItems"));
                employee.setEmail(rs.getString("email"));
                employee.setRegistrDate(rs.getString("registrDate"));
                employee.setDepartmentId(rs.getInt("departmentId"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    @Override
    public void deleteEmployee(int employeeId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where employeeId=?");
            preparedStatement.setInt(1, employeeId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    @Override
    public boolean checkDublicateEmail(String email)  {
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select email from employee");
            while (rs.next()) {

                if (rs.getString("email").equals(email)) {
                    return true;
                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false ;
    }

}