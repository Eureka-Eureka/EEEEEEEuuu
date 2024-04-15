package com.WorkerSystem.util;

import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ConfirmDelete {
    private static String del_ID;

    public static void confirmDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("确认删除");
        alert.setHeaderText("确定删除此信息吗？");
        alert.setContentText("请确认您的选择。");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // 执行删除操作
                AdminDAO adminDAO = new AdminDAOimpl();
                try {
                    adminDAO.DelStaff_inf(del_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void setDel_ID(String ID){
        del_ID = ID;
    }
}
