package com.WorkerSystem.controllers.StaffControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff_Account;
import com.WorkerSystem.util.Stringutil;
import com.WorkerSystem.util.errorSetter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.List;

public class StaffLogin_controller {

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;


    @FXML
    public void StaffLogin() throws Exception {
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
        StaffDAO StaffAccount = new StaffDAOimpl();
        List<Staff_Account> list = StaffAccount.GetAccount();
        boolean flag = false;

        for (Staff_Account staff:list) {
            if(staff.getAccount().equals(accountText)){
                if(staff.getPassword().equals(passwordText)){
                    flag = true;
                    break;
                }
                break;
            }
        }

        if(flag == true){
            StaffInfo_controller.setCurrentInfo(accountText);
            Main.changeView("views/StaffViews/Staff_Info.fxml");
        }else{
            errorSetter.SetError("密码错误!!!");
            return;
        }

    }


    @FXML
    public void Back() {
        Main.changeView("views/index.fxml");
    }
}
