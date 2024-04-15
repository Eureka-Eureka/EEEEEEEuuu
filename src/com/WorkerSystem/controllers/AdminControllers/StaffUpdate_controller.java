package com.WorkerSystem.controllers.AdminControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.pojo.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StaffUpdate_controller {
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

    private static Staff currentInfo;//获取当前的信息 作为默认值

    @FXML
    public void initialize(){
        sex.getItems().clear();
        sex.getItems().addAll("男","女");


        ID.setText(currentInfo.getID());
        name.setText(currentInfo.getName());
        sex.setValue(currentInfo.getSex());
        age.setText(Integer.toString(currentInfo.getAge()));
        academic.setText(currentInfo.getAcademic());
        tel.setText(currentInfo.getTel());
        address.setText(currentInfo.getAddress());
        staff_baseSalary.setText(Integer.toString(currentInfo.getStaff_baseSalary()));
    }


    @FXML
    public static void setCurrentInfo(Staff Current){
         StaffUpdate_controller.currentInfo = Current;
    }


    @FXML
    public void Staff_update(ActionEvent event) throws Exception {
        AdminDAO adminDAO = new AdminDAOimpl();
        Staff staff = new Staff(ID.getText(), name.getText(), sex.getValue(),
                Integer.parseInt(age.getText()), academic.getText(), tel.getText(),
                address.getText(), Integer.parseInt(staff_baseSalary.getText()));

        adminDAO.ModStaff_inf(staff);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Main.changeView("views/AdminViews/AdminManageSystem.fxml");
    }

}
