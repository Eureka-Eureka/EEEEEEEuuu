package com.WorkerSystem.dao;

import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_Account;
import com.WorkerSystem.pojo.Staff_salary;

import java.util.List;

public interface StaffDAO {

    //获取职工账户
    List<Staff_Account> GetAccount() throws Exception;

    //修改账户密码
    void ModAccount(Staff_Account staff_account) throws Exception;

    //通过ID获取职工信息
    Staff GetStaffByID(String ID) throws Exception;

    //获取职工工资信息
    List<Staff_salary> GetSalaryInfo(String ID) throws Exception;
}
