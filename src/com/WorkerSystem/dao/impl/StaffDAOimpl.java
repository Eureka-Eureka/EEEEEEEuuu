package com.WorkerSystem.dao.impl;

import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_Account;
import com.WorkerSystem.pojo.Staff_salary;
import com.WorkerSystem.util.jdbcConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOimpl implements StaffDAO {


    @Override
    public List<Staff_Account> GetAccount() throws Exception {
        Connection conn = jdbcConn.getConnection();
        List<Staff_Account> list = new ArrayList<>();


        String sql = "select * from staff_account";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()){
            Staff_Account staff_account = new Staff_Account(rs.getString("Staff_ID"),rs.getString("password"));

            list.add(staff_account);
        }

        conn.close();

        return list;
    }

    @Override
    public void ModAccount(Staff_Account staff_account) throws Exception {
        Connection conn = jdbcConn.getConnection();
        String account = staff_account.getAccount();
        String password = staff_account.getPassword();

        String sql = "update staff_account set password = ? where Staff_ID = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,password);
        pstm.setString(2,account);
        pstm.executeUpdate();

        conn.close();
    }

    @Override
    public Staff GetStaffByID(String ID) throws Exception {
        Connection conn = jdbcConn.getConnection();
        String sql = "select * from staff_inf where Staff_ID = "+ID;
        PreparedStatement pstm = conn.prepareStatement(sql);
        Staff staff = null;

        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            staff = new Staff(rs.getString("Staff_ID"),rs.getString("Staff_name"),
                    rs.getString("Staff_sex"), rs.getInt("Staff_age"), rs.getString("Staff_academic"),
                    rs.getString("Staff_tel"), rs.getString("Staff_address"),
                    rs.getInt("staff_baseSalary"));
        }
        return staff;
    }

    @Override
    public List<Staff_salary> GetSalaryInfo(String ID) throws Exception {
        Connection conn = jdbcConn.getConnection();
        String sql= "select * from Staff_salary "+"where Staff_ID = "+ID;
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<Staff_salary> list = new ArrayList<>();

        ResultSet rs = pstm.executeQuery();
        while(rs.next()){

            Staff_salary salary = new Staff_salary(rs.getString("Staff_ID"),rs.getInt("Staff_baseSalary"),rs.getInt("Staff_benefit"),
                    rs.getInt("Staff_livingAllowance"),rs.getInt("Staff_totalCut"),rs.getInt("Staff_telBill"),rs.getInt("Staff_utiBill"),
                    rs.getInt("Staff_houseRent"),rs.getInt("Staff_incomeTax"),rs.getInt("Staff_sanFee"),rs.getInt("Staff_accumFunds"),
                    rs.getInt("Staff_netPay"), rs.getInt("Staff_shouldPay"), rs.getDate("Staff_Date"));
            list.add(salary);
        }
        return list;
    }
}
