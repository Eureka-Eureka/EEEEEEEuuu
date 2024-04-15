package com.WorkerSystem.dao.impl;

import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.pojo.Admin;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_salary;
import com.WorkerSystem.util.jdbcConn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOimpl implements AdminDAO {
    @Override
    public List<Admin> GetAccount() throws Exception {
        List<Admin> list = new ArrayList<>();
        Connection conn = jdbcConn.getConnection();//获取连接

        String sql = "select * from admin_account";

        PreparedStatement pstm = conn.prepareStatement(sql);//编译sql

        ResultSet rs = pstm.executeQuery();//获取数据保存到rs集合

        while(rs.next()){
            String account = rs.getString("account");
            String password = rs.getString("password");

            Admin admin = new Admin(account,password);

            list.add(admin);
        }//从rs集合读取数据 保存到list中

        conn.close();
        return list;
    }

    @Override
    public List<Staff> GetWorker_inf() throws Exception {
        Connection conn = jdbcConn.getConnection();

        String sql = "select * from staff_inf";
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<Staff> list = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();

        while(rs.next()){
            Staff staff = new Staff(rs.getString("Staff_ID"),rs.getString("Staff_name"),
                    rs.getString("Staff_sex"), rs.getInt("Staff_age"), rs.getString("Staff_academic"),
                    rs.getString("Staff_tel"), rs.getString("Staff_address"),
                    rs.getInt("staff_baseSalary"));

            list.add(staff);
        }
        conn.close();
        return list;
    }

    //录入基本信息和工资
    @Override
    public void AddStaff_inf(String ID, String name, String sex, Integer age,
                             String academic,  String tel,String address,
                             Integer staff_baseSalary) throws Exception {
        Connection conn = jdbcConn.getConnection();

        String sql1 = "insert into staff_inf (Staff_ID,Staff_name,Staff_sex,Staff_age,Staff_academic,Staff_address,Staff_tel," +
                "staff_baseSalary) values (?,?,?,?,?,?,?,?)";


        PreparedStatement pstm1 = conn.prepareStatement(sql1);


        //pstm1 置入数据
        pstm1.setString(1,ID);
        pstm1.setString(2,name);
        pstm1.setString(3,sex);
        pstm1.setInt(4,age);
        pstm1.setString(5,academic);
        pstm1.setString(6,address);
        pstm1.setString(7,tel);
        pstm1.setInt(8,staff_baseSalary);

       /* //pstm2 置入数据
        pstm2.setInt(1,staff_baseSalary);
        pstm2.setInt(2,staff_benefit);
        pstm2.setInt(3,staff_livingAllowance);

        pstm2.execute();*/
        pstm1.execute();
        conn.close();
    }

    @Override
    public List<Staff> GetWorker_inf_Salary_academic(String str) throws Exception {

        Connection conn = jdbcConn.getConnection();

        String sql = "select * from staff_inf "+str;
        PreparedStatement pstm = conn.prepareStatement(sql);
        List<Staff> list = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();

        while(rs.next()){
            Staff staff = new Staff(rs.getString("Staff_ID"),rs.getString("Staff_name"),
                    rs.getString("Staff_sex"), rs.getInt("Staff_age"), rs.getString("Staff_academic"),
                    rs.getString("Staff_tel"), rs.getString("Staff_address"),
                    rs.getInt("Staff_baseSalary"));

            list.add(staff);
        }
        conn.close();
        return list;
    }

    @Override
    public void ModStaff_inf(Staff staff) throws Exception {
        Connection conn = jdbcConn.getConnection();

        String sql = "update staff_inf set Staff_name= ? , Staff_sex= ? ,Staff_age= ? ," +
                " Staff_academic= ? ,Staff_tel= ? , Staff_address= ? , Staff_baseSalary= ? where Staff_ID = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql);
        //pstm1 置入数据
        pstm1.setString(1,staff.getName());
        pstm1.setString(2,staff.getSex());
        pstm1.setInt(3,staff.getAge());
        pstm1.setString(4,staff.getAcademic());
        pstm1.setString(5,staff.getTel());
        pstm1.setString(6,staff.getAddress());
        pstm1.setInt(7,staff.getStaff_baseSalary());
        pstm1.setString(8,staff.getID());

        pstm1.executeUpdate();
        conn.close();
    }

    @Override
    public void DelStaff_inf(String No) throws Exception {
        Connection conn = jdbcConn.getConnection();

        String sql = "delete from Staff_inf where Staff_ID = ?";
        String sql1 = "delete from Staff_inf where Staff_ID = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql);
        PreparedStatement pstm2 = conn.prepareStatement(sql1);

        pstm1.setString(1,No);
        pstm2.setString(1,No);

        pstm1.execute();
        pstm2.execute();

        conn.close();
    }

    @Override
    public void AddStaff_salary(Staff_salary salary) throws Exception {
        Connection conn = jdbcConn.getConnection();
        String sql = "insert into staff_salary (Staff_ID,Staff_benefit,Staff_livingAllowance,Staff_shouldPay," +
                "Staff_telBill,Staff_utiBill,Staff_houseRent,Staff_incomeTax,Staff_sanFee,Staff_accumFunds," +
                "Staff_totalCut,Staff_netPay,Staff_Date,Staff_baseSalary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1,salary.getID());
        pstm.setInt(2,salary.getBenefit());
        pstm.setInt(3,salary.getLivingAllowance());
        pstm.setInt(4,salary.getShouldPay());
        pstm.setInt(5,salary.getTelBill());
        pstm.setInt(6,salary.getUtiBill());
        pstm.setInt(7,salary.getHouseRent());
        pstm.setInt(8,salary.getIncomeTax());
        pstm.setInt(9,salary.getSanFee());
        pstm.setInt(10,salary.getAccumFunds());
        pstm.setInt(11,salary.getTotalCut());
        pstm.setInt(12,salary.getNetPay());
        pstm.setDate(13, (java.sql.Date) salary.getDate());
        pstm.setInt(14,salary.getBaseSalary());

        pstm.execute();
    }

}
