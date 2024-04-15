package com.WorkerSystem.controllers.AdminControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.pojo.Staff_salary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;


public class StaffSalaryAdd_controller {
    @FXML
    private TextField ID;
    @FXML
    private TextField baseSalary;
    @FXML
    private TextField benefit;
    @FXML
    private TextField livingAllowance;
    @FXML
    private TextField telBill;
    @FXML
    private TextField utiBill;
    @FXML
    private TextField houseRent;
    @FXML
    private TextField incomeTax;
    @FXML
    private TextField sanFee;
    @FXML
    private TextField accumFunds;
    @FXML
    private DatePicker date;

    private static Staff Current;

    public static void setCurrent(Staff current){
        StaffSalaryAdd_controller.Current = current;
    }

    @FXML
    public void initialize(){
        ID.setText(Current.getID());
        baseSalary.setText(Current.getStaff_baseSalary().toString());

        ID.setDisable(true);
        baseSalary.setDisable(true);
    }

    @FXML
    public void SalaryAdd(ActionEvent event) throws Exception {
        AdminDAO adminDAO = new AdminDAOimpl();

        //总扣款项
        Integer telBill = Integer.parseInt(this.telBill.getText());
        Integer sanFee = Integer.parseInt(this.sanFee.getText());
        Integer accumFunds = Integer.parseInt(this.accumFunds.getText());
        Integer incomeTax = Integer.parseInt(this.incomeTax.getText());
        Integer houseRent = Integer.parseInt(this.houseRent.getText());
        Integer utiBill = Integer.parseInt(this.utiBill.getText());

        //工资项
        Integer basesalary = Current.getStaff_baseSalary();
        Integer livingAllowance = Integer.parseInt(this.livingAllowance.getText());
        Integer benefit = Integer.parseInt(this.benefit.getText());


        //
        String date = this.date.getEditor().getText();

        Integer totalCut = telBill + sanFee + accumFunds + incomeTax + houseRent + utiBill;
        Integer shouPay = basesalary + livingAllowance + benefit;
        Integer netPay =shouPay - totalCut;

        Staff_salary salary = new Staff_salary(Current.getID(),basesalary,benefit,livingAllowance,totalCut,
                telBill,utiBill,houseRent,incomeTax,sanFee,accumFunds,netPay,shouPay, Date.valueOf(date));


        adminDAO.AddStaff_salary(salary);
        //添加结束 关闭当前页面 转发至录入界面
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Main.changeView("views/AdminViews/AdminManageSystem.fxml");
    }

    @FXML
    public void Back(ActionEvent event) {
        //添加结束 关闭当前页面 转发至录入界面
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Main.changeView("views/AdminViews/AdminManageSystem.fxml");
    }
}
