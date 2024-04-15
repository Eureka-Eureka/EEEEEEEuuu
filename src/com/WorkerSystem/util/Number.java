package com.WorkerSystem.util;

import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Admin;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_Account;

import java.util.List;

public class Number {
    public static int isUnique(String new_id) throws Exception {
        //1->不唯一   2->含有非法字符   0->合法

        AdminDAO adminDAO = new AdminDAOimpl();
        StaffDAO staffDAO = new StaffDAOimpl();
        List<Staff> list1 = adminDAO.GetWorker_inf();
        List<Staff_Account> list2 = staffDAO.GetAccount();

        if(!(new_id.matches("[0-9]+"))){
            return 2;
        }

        for (Staff staff : list1) {
            if(staff.getID().equals(new_id)){
                return 1;
            }
        }

        for (Staff_Account staff : list2) {
            if(staff.getAccount().equals(new_id)){
                return 1;
            }
        }

        return 0;
    }
}
