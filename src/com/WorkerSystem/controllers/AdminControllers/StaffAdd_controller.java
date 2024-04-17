package com.WorkerSystem.controllers.AdminControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.util.Number;
import com.WorkerSystem.util.errorSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StaffAdd_controller {

    @FXML
    private TextField ID;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<String> sex;

    @FXML
    private TextField age;

    @FXML
    private TextField academic;

    @FXML
    private TextField tel;

    @FXML
    private TextField address;

    @FXML
    private TextField staff_baseSalary;


    @FXML
    public void initialize(){
        sex.getItems().clear();//防止缓存数据 先清除
        sex.getItems().addAll("男","女");//设置选项内容
    }

    @FXML
    public void Staff_add(ActionEvent event) throws Exception {


        //判断工号唯一性 和 工号格式
        int flag = Number.isUnique(ID.getText());

        if(flag == 1){
            errorSetter.SetError("当前职工号已存在！");
            return;
        }

        if(flag == 2){
            errorSetter.SetError("职工号格式错误！");
            return;
        }

        if(ID.getText()==null||name.getText()==null||sex.getValue()==null||
                age.getText()==null||academic.getText()==null||tel.getText()==null||address.getText()==null||
                staff_baseSalary.getText()==null){
            errorSetter.SetError("请完善信息后提交！！");
            return;
        }
        //获取输入数据
        AdminDAO adminDAO = new AdminDAOimpl();

        adminDAO.AddStaff_inf(ID.getText(),name.getText(),sex.getValue(),
                Integer.parseInt(age.getText()), academic.getText(),tel.getText(),address.getText(),
                Integer.parseInt(staff_baseSalary.getText()));

        adminDAO.AddStaff_account(ID.getText());
        //添加结束 关闭当前页面 转发至录入界面
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Main.changeView("views/AdminViews/AdminManageSystem.fxml");
    }


}
