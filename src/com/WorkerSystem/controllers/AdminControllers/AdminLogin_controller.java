package com.WorkerSystem.controllers.AdminControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.controllers.errorInfo_controller;
import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.pojo.Admin;
import com.WorkerSystem.util.Stringutil;

import com.WorkerSystem.util.errorSetter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.util.List;



public class AdminLogin_controller {

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;

    @FXML
    public void AdminLogin() throws Exception {
        String accountText = account.getText();
        String passwordText = password.getText();

        if(Stringutil.isEmpty(accountText)){
            errorSetter.SetError("账号不可为空！！");
            return;
        }

        if(Stringutil.isEmpty(passwordText)){
            errorSetter.SetError("密码不可为空！！");
            return;
        }

        //获取数据
        AdminDAO adminDAO = new AdminDAOimpl();
        List<Admin> list=  adminDAO.GetAccount();
        boolean flag = false;

        for (Admin admin:list) {
            if(admin.getAccount().equals(accountText)){
                if(admin.getPassword().equals(passwordText)){
                    flag = true;
                    break;
                }
                break;
            }
        }

        if(flag){
            Main.changeView("views/AdminViews/AdminManageSystem.fxml");
        }else{
            errorSetter.SetError("密码错误!!!");
            return;
        }
    }
}
