package com.WorkerSystem.controllers.StaffControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StaffInfo_controller {

    @FXML
    private Label ID;

    @FXML
    private Label name;

    @FXML
    private Label sex;

    @FXML
    private Label age;

    @FXML
    private Label academic;

    @FXML
    private Label tel;

    @FXML
    private Label baseSalary;

    @FXML
    private Label address;

    private static String Current;

    @FXML
    public void initialize() throws Exception {
        StaffDAO staffDAO = new StaffDAOimpl();
        Staff staff = staffDAO.GetStaffByID(Current);
        ID.setText(staff.getID());
        name.setText(staff.getName());
        sex.setText(staff.getSex());
        age.setText(staff.getAge().toString());
        academic.setText(staff.getAcademic());
        tel.setText(staff.getTel());
        baseSalary.setText(staff.getStaff_baseSalary().toString());
        address.setText(staff.getAddress());
    }

    @FXML
    public void updatePassword() {
        StaffUpdatePW_controller.setCurrentInfo(Current);
        Main.addView("views/StaffViews/StaffUpdatePW.fxml");
    }

    @FXML
    public void Back() {
        Main.changeView("views/StaffViews/StaffLogin.fxml");
    }

    @FXML
    public void salaryInfo() {
        Staff_salaryInfo_controller.setCurrentInfo(Current);
        Main.addView("views/StaffViews/Staff_salaryInfo.fxml");
    }


    public static void setCurrentInfo(String CurrentID){
        Current = CurrentID;
    }


}
