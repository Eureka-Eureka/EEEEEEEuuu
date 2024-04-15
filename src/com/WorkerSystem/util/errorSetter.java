package com.WorkerSystem.util;

import com.WorkerSystem.Main;
import com.WorkerSystem.controllers.errorInfo_controller;

public class errorSetter {
    public static void SetError(String errorInfo){
        errorInfo_controller.SetErrorInfo(errorInfo);
        Main.addView("views/error_info.fxml");
    }
}
