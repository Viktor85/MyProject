package com.test.web.dao;


import com.test.web.model.Employee;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDao {

    public void addEmployee(Employee employees) throws SQLException;

    public void updateEmployee(Employee employee) throws SQLException;

    public List<Employee> getAllEmployeeDepartmentById(int departmentId) throws SQLException;

    public Employee getEmployeeById(int employeeId) throws SQLException;

    public void deleteEmployee(int employeeId) throws SQLException;

    public boolean checkDublicateEmail(String email) throws SQLException;


}
