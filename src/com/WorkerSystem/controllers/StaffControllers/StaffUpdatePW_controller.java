package com.WorkerSystem.controllers.StaffControllers;

import com.WorkerSystem.dao.StaffDAO;
import com.WorkerSystem.dao.impl.StaffDAOimpl;
import com.WorkerSystem.pojo.Staff_Account;
import com.WorkerSystem.util.CaptchaGenerator;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class StaffUpdatePW_controller {
    @FXML
    private TextField ID;

    @FXML
    private PasswordField oldPassWord;

    @FXML
    private PasswordField newPassWord;

    @FXML
    private PasswordField renewoldPassWord;

    @FXML
    private TextField captcha;

    @FXML
    private ImageView captchaImage;

    @FXML
    private Label errorInfo;

    private static String Captcha;

    private static String Current;

    @FXML
    public void initialize() throws Exception {
        ID.setText(Current);
        ID.setDisable(true);

        BufferedImage image = CaptchaGenerator.generateCaptcha();
        Captcha = CaptchaGenerator.getCaptcha();
        CaptchaGenerator.saveImage(image);

        //将获取的BufferedImage转为image类型
        Image fxImage = SwingFXUtils.toFXImage(image, null);

        // 将JavaFX的Image对象设置为ImageView的图像
        captchaImage.setImage(fxImage);
    }


    public static void setCurrentInfo(String CurrentID){
        Current = CurrentID;
    }


    @FXML
    public void changeCaptcha() throws IOException {

        //调用验证码生成
        BufferedImage image = CaptchaGenerator.generateCaptcha();
        Captcha = CaptchaGenerator.getCaptcha();

        //保存生成验证码至文件
        CaptchaGenerator.saveImage(image);

        //将获取的BufferedImage转为image类型
        Image fxImage = SwingFXUtils.toFXImage(image, null);

        // 将JavaFX的Image对象设置为ImageView的图像
        captchaImage.setImage(fxImage);
    }

    //提交
    @FXML
    public void submit(ActionEvent event) throws Exception {
        //获取用户输入数据
        String oldPassWordText = oldPassWord.getText();
        String newPassWordText = newPassWord.getText();
        String renewoldPassWordText = renewoldPassWord.getText();
        String captchaText = captcha.getText();

        //获取数据库数据
        StaffDAO staffAccount = new StaffDAOimpl();
        List<Staff_Account> list = staffAccount.GetAccount();
        String password = "";
        for (Staff_Account staff_account : list) {
            if(staff_account.getAccount().equals(Current)){
                password = staff_account.getPassword();
            }
        }

        boolean flag = true;
        //判断原密码
        if(!(oldPassWordText.equals(password))){
            flag = false;
            errorInfo.setText("原密码输入有误！！");
            errorInfo.setVisible(true);
        }


        //判断新密码以及确认密码
        if(!(newPassWordText.equals(renewoldPassWordText))){
            flag = false;
            errorInfo.setText("新密码与确认密码不一致！！");
            errorInfo.setVisible(true);
        }


        //判断验证码
        if(!(captchaText.equals(Captcha))){
            flag = false;
            errorInfo.setText("验证码错误！！");
            errorInfo.setVisible(true);
        }

        if(flag){
            Staff_Account staff_account = new Staff_Account(Current,newPassWordText);
            StaffDAO staffDAO = new StaffDAOimpl();
            staffDAO.ModAccount(staff_account);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
