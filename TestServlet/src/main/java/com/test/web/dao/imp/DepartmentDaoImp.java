package com.test.web.dao.imp;

import com.test.web.dao.DepatmentDao;

import com.test.web.model.Department;
import com.test.web.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDaoImp implements DepatmentDao {

    private Connection connection;
    private String s;

    public DepartmentDaoImp()  {

        connection = DbUtil.getConnection();
    }

    @Override
    public void addDepartment(Department department) {
        try {


            PreparedStatement ps = connection.prepareStatement("insert into department(departmentId,departmentName) values (?,?)");

            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteDepartment(int departmentId) {
        try {


            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from department where departmentId=?");
            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department)  {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("update department set departmentName=?" + "where departmentId=?");

            preparedStatement.setString(1, department.getDepartmentName());

            preparedStatement.setInt(2, department.getDepartmentId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAllDepartmens()  {
        List<Department> departmentList = new ArrayList<Department>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from department");
            while (rs.next()) {
                Department department = new Department();

                department.setDepartmentId(rs.getInt("departmentId"));
                department.setDepartmentName(rs.getString("departmentName"));

                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }

    @Override
    public Department getDepartmentById(int departmentId)  {
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from department where departmentid=?");
            preparedStatement.setInt(1, departmentId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                department.setDepartmentId(rs.getInt("departmentId"));
                department.setDepartmentName(rs.getString("departmentName"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public String getDepartmentName(int departmentId)  {

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from department where departmentid=?");
            preparedStatement.setInt(1, departmentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                s = (rs.getString("departmentName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return s;
    }

    @Override
    public boolean checkDublicateName(String departmentName) {
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select departmentName from department");
            while (rs.next()) {

                if (rs.getString("departmentName").equals(departmentName)) {
                    return true;
                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }


            return false;
        }


    }

