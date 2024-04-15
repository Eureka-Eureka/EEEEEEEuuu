package com.WorkerSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class del_ensurer_controller {
    private static boolean Info = false;


    public void commit(ActionEvent event) throws Exception {
        Info = true;
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void back(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static boolean getInfo(){
        return Info;
    }
}
