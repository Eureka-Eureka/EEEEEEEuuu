package com.WorkerSystem.dao;

import com.WorkerSystem.pojo.Admin;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_Account;
import com.WorkerSystem.pojo.Staff_salary;

import java.util.List;

public interface AdminDAO {

    //获取管理员账号密码信息
    List<Admin> GetAccount() throws Exception;

    //浏览职工信息
    List<Staff> GetWorker_inf() throws Exception;

    //录入职工信息和工资
    void AddStaff_inf(String ID, String name, String sex, Integer age,
                      String academic,  String tel,String address,
                      Integer staff_baseSalary) throws Exception;



    //根据条件进行查询
    List<Staff> GetWorker_inf_Salary_academic(String str) throws Exception;

    //修改员工信息
    void ModStaff_inf(Staff staff) throws Exception;

    //删除员工信息
    void DelStaff_inf(String ID) throws Exception;

    //录入员工工资
    void AddStaff_salary(Staff_salary salary) throws Exception;
}
