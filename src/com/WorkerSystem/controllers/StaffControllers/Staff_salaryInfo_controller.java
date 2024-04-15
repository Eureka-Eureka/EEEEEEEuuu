package com.WorkerSystem.controllers.StaffControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff_salary;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;

public class Staff_salaryInfo_controller {

    @FXML
    private TableView<Staff_salary> tableview;

    @FXML
    private TableColumn<Staff_salary,Integer> shouldPay;
    @FXML
    private TableColumn<Staff_salary,Integer> baseSalary;
    @FXML
    private TableColumn<Staff_salary,Integer> benefit;
    @FXML
    private TableColumn<Staff_salary,Integer> livingAllowance;
    @FXML
    private TableColumn<Staff_salary,Integer> totalCut;
    @FXML
    private TableColumn<Staff_salary,Integer> telBill;
    @FXML
    private TableColumn<Staff_salary,Integer> utiBill;
    @FXML
    private TableColumn<Staff_salary,Integer> houseRent;
    @FXML
    private TableColumn<Staff_salary,Integer> incomeTax;
    @FXML
    private TableColumn<Staff_salary,Integer> sanFee;
    @FXML
    private TableColumn<Staff_salary,Integer> accumFunds;
    @FXML
    private TableColumn<Staff_salary,Integer> netPay;
    @FXML
    private TableColumn<Staff_salary, Date> date;


    private static String Current;

    @FXML
    public void initialize() throws Exception {
        StaffDAO salaryDAO = new StaffDAOimpl();
        List<Staff_salary> list = salaryDAO.GetSalaryInfo(Current);
        setDate(list);
    }

    //获取当前所选对象
    public static void setCurrentInfo(String CurrentID){
        Current = CurrentID;
    }

    public void setDate(List<Staff_salary> list){
        baseSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        benefit.setCellValueFactory(new PropertyValueFactory<>("benefit"));
        livingAllowance.setCellValueFactory(new PropertyValueFactory<>("livingAllowance"));
        totalCut.setCellValueFactory(new PropertyValueFactory<>("totalCut"));
        telBill.setCellValueFactory(new PropertyValueFactory<>("telBill"));
        utiBill.setCellValueFactory(new PropertyValueFactory<>("utiBill"));
        houseRent.setCellValueFactory(new PropertyValueFactory<>("houseRent"));
        incomeTax.setCellValueFactory(new PropertyValueFactory<>("incomeTax"));
        sanFee.setCellValueFactory(new PropertyValueFactory<>("sanFee"));
        accumFunds.setCellValueFactory(new PropertyValueFactory<>("accumFunds"));
        netPay.setCellValueFactory(new PropertyValueFactory<>("netPay"));
        shouldPay.setCellValueFactory(new PropertyValueFactory<>("shouldPay"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableview.setItems(FXCollections.observableList(list));
    }


    @FXML
    public void Back(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Main.changeView("views/StaffViews/Staff_Info.fxml");
    }
}
