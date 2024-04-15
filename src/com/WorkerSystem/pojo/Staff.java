package com.WorkerSystem.pojo;

public class Staff implements Comparable<Staff>{
    //存放职工基本信息的类
    private String ID;
    private String name;
    private String sex;
    private Integer age;
    private String academic;
    private String tel;
    private String address;
    private Integer staff_baseSalary;


    public Staff() {
    }

    public Staff(String ID, String name, String sex, Integer age, String academic, String tel, String address, Integer staff_baseSalary) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.academic = academic;
        this.tel = tel;
        this.address = address;
        this.staff_baseSalary = staff_baseSalary;
    }

    /**
     * 获取
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return academic
     */
    public String getAcademic() {
        return academic;
    }

    /**
     * 设置
     * @param academic
     */
    public void setAcademic(String academic) {
        this.academic = academic;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return staff_baseSalary
     */
    public Integer getStaff_baseSalary() {
        return staff_baseSalary;
    }

    /**
     * 设置
     * @param staff_baseSalary
     */
    public void setStaff_baseSalary(Integer staff_baseSalary) {
        this.staff_baseSalary = staff_baseSalary;
    }

    public String toString() {
        return "Staff{ID = " + ID + ", name = " + name + ", sex = " + sex + ", age = " + age + ", academic = " + academic + ", tel = " + tel + ", address = " + address + ", staff_baseSalary = " + staff_baseSalary + "}";
    }

    @Override
    public int compareTo(Staff o) {
        return 0;
    }
}
