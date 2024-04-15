package com.WorkerSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class errorInfo_controller {

    @FXML
    private Label errorInfo;

    public static String errorStr;

    @FXML
    public void initialize(){
        errorInfo.setText(errorStr);
        errorInfo.setVisible(true);
    }

    public static void SetErrorInfo(String str){
        errorStr = str;
    }

    public void Back(ActionEvent event) {
        //添加结束 关闭当前页面 转发至录入界面
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
