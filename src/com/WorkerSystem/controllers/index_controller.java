package com.WorkerSystem.controllers;

import com.WorkerSystem.Main;
import javafx.fxml.FXML;

public class index_controller {

    @FXML
    public void initialize(){
        
    }

    @FXML
    public void toAdminLogin() {
        Main.changeView("views/AdminViews/AdminLogin.fxml");
    }

    @FXML
    public void toStaffLogin() {
        Main.changeView("views/StaffViews/StaffLogin.fxml");
    }
}
