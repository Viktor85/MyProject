package com.test.web.dao;


import com.test.web.model.Department;

import java.sql.SQLException;
import java.util.List;


public interface DepatmentDao {

    public void addDepartment(Department department) throws SQLException;

    public List<Department> getAllDepartmens() throws SQLException;

    public void deleteDepartment(int departmentId) throws SQLException;

    public void updateDepartment(Department department) throws SQLException;

    public String getDepartmentName(int departmentId) throws SQLException;

    public Department getDepartmentById(int departmentId) throws SQLException;

    public boolean checkDublicateName(String departmentName) throws SQLException;


}
