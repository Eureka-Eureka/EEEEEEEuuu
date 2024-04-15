package com.WorkerSystem.controllers.AdminControllers;

import com.WorkerSystem.Main;
import com.WorkerSystem.util.ConfirmDelete;
import com.WorkerSystem.dao.AdminDAO;
import com.WorkerSystem.dao.impl.AdminDAOimpl;
import com.WorkerSystem.pojo.Staff;
import com.WorkerSystem.util.errorSetter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdminManageSystem_controller {


    @FXML
    private TableView<Staff> tableview;

    @FXML
    private TableColumn<Staff,String> ID;

    @FXML
    private TableColumn<Staff,String> name;

    @FXML
    private TableColumn<Staff,String> sex;

    @FXML
    private TableColumn<Staff,Integer> age;

    @FXML
    private TableColumn<Staff,String> academic;

    @FXML
    private TableColumn<Staff,String> address;

    @FXML
    private TableColumn<Staff,Integer> staff_baseSalary;

    @FXML
    private TableColumn<Staff,String> tel;

    @FXML
    private TextField Salary_topRange;

    @FXML
    private TextField Salary_lowRange;

    @FXML
    private TextField acadeInfo;

    @FXML
    private TextField IDinfo;

    @FXML
    private TextField Age_topRange;

    @FXML
    private TextField Age_lowRange;

    @FXML
    private CheckMenuItem Age_asc;

    @FXML
    private CheckMenuItem Age_desc;

    @FXML
    private CheckMenuItem Salary_asc;

    @FXML
    private CheckMenuItem Salary_desc;


    @FXML
    public void initialize() throws Exception {
        AdminDAO adminDAO = new AdminDAOimpl();
        List<Staff> list = adminDAO.GetWorker_inf();
        setData(list);
    }



    @FXML
    public void showAddView(){
       Main.addView("views/AdminViews/Staff_add.fxml");
    }

    @FXML
    public void delinfo() throws Exception {
        Staff staff = tableview.getSelectionModel().getSelectedItem();

        if(staff != null){
            ConfirmDelete.setDel_ID(staff.getID());
            ConfirmDelete.confirmDelete();
        }else if(staff == null){
            errorSetter.SetError("未选中对应行！！");
            return;
        }
        Main.changeView("views/AdminViews/AdminManageSystem.fxml");
    }


    @FXML
    public void showUpdateView() {
        Staff staff = tableview.getSelectionModel().getSelectedItem();
        if(staff != null){
            StaffUpdate_controller.setCurrentInfo(staff);
            Main.addView("views/AdminViews/Staff_update.fxml");
        }else if(staff == null){
            errorSetter.SetError("未选中对应行！！");
            return;
        }
    }

    @FXML
    public void queryInfoByCondition() throws Exception {
        AdminDAO adminDAO = new AdminDAOimpl();
        String str = "";//where
        String salaryTop = Salary_topRange.getText();//null
        String salaryLow = Salary_lowRange.getText();//1111
        String ageLow = Age_lowRange.getText();
        String ageTop = Age_topRange.getText();
        String acadeInfoText = acadeInfo.getText();//学历
        String iDinfoText = IDinfo.getText();//职工号

        int Flag = 0;//

        //默认值
        if(!salaryTop.equals("") ){
            str += "where Staff_baseSalary <= "+salaryTop;
            Flag++;
        }

        if((!salaryLow.equals(""))  && Flag == 0){
            str += "where Staff_baseSalary >= "+salaryLow;
            Flag++;
        }else if((!salaryLow.equals("")) && Flag > 0){
            str += " and Staff_baseSalary >="+salaryLow;
        }

        if((!acadeInfoText.equals("")) && Flag == 0){
            str += "where Staff_academic = "+"\""+acadeInfoText+"\"";
            Flag++;
        }else if((!acadeInfoText.equals("")) && Flag > 0){
            str += " and Staff_academic = "+"\""+acadeInfoText+"\"";
        }

        if( (!ageTop.equals("")) && Flag == 0){
            str += "where Staff_age <= "+ageTop;
            Flag++;
        }else if((!ageTop.equals("") && Flag > 0)){
            str += " and Staff_age <= "+ageTop;
        }

        if( (!ageLow.equals("")) && Flag == 0){
            str += "where Staff_age >= "+ageLow;
            Flag++;
        }else if((!ageLow.equals("") && Flag > 0)){
            str += " and Staff_age >= "+ageLow;
        }

        if((!iDinfoText.equals("")) && Flag == 0){
            str += "where Staff_academic = "+"\""+iDinfoText+"\"";
            Flag++;
        }else if((!iDinfoText.equals("")) && Flag > 0){
            str += " and Staff_academic = "+"\""+iDinfoText+"\"";
        }

        List<Staff> list = adminDAO.GetWorker_inf_Salary_academic(str);

        setData(list);
    }

    @FXML
    public void orderInfoByCondition() throws Exception {
        List<Staff> list = getData();

        boolean selected1 = Age_asc.isSelected();
        boolean selected2 = Age_desc.isSelected();
        boolean selected3 = Salary_asc.isSelected();
        boolean selected4 = Salary_desc.isSelected();

        if(selected1){
            Collections.sort(list, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    return o2.getAge()-o1.getAge();
                }//年龄降序
            });
        }

        if(selected2){
            Collections.sort(list, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    return o1.getAge()-o2.getAge();
                }//年龄升序
            });
        }

        if(selected3){
            Collections.sort(list, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    return o2.getStaff_baseSalary()-o1.getStaff_baseSalary();
                }//工资降序
            });
        }

        if(selected4){
            Collections.sort(list, new Comparator<Staff>() {
                @Override
                public int compare(Staff o1, Staff o2) {
                    return o1.getStaff_baseSalary()-o2.getStaff_baseSalary();
                }//工资升序
            });
        }

        setData(list);
    }

    //填入数据
    public void setData(List<Staff> list) throws Exception {
        //将数据库职工信息读取 并初始化到表
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        academic.setCellValueFactory(new PropertyValueFactory<>("academic"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        staff_baseSalary.setCellValueFactory(new PropertyValueFactory<>("staff_baseSalary"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));

        tableview.setItems(FXCollections.observableList(list));
    }


    //获得数据
    public List<Staff> getData(){
        ObservableList<Staff> dataList = tableview.getItems();

        return dataList;
    }

    public void showSalaryAddView() {
        Staff staff = tableview.getSelectionModel().getSelectedItem();
        if(staff != null){
            StaffSalaryAdd_controller.setCurrent(staff);
            Main.addView("views/AdminViews/Admin_salaryAdd.fxml");
        }else if(staff == null){
            errorSetter.SetError("未选中对应行！！");
            return;
        }
    }

    @FXML
    public void Back() {
        Main.changeView("views/index.fxml");
    }
}
