package com.WorkerSystem.pojo;

import java.util.Date;

public class Staff_salary {
    private String ID;
    private Integer baseSalary;
    private Integer benefit;
    private Integer livingAllowance;
    private Integer totalCut;
    private Integer telBill;
    private Integer utiBill;
    private Integer houseRent;
    private Integer incomeTax;
    private Integer sanFee;
    private Integer accumFunds;
    private Integer netPay;
    private Integer shouldPay;
    private java.sql.Date date;


    public Staff_salary() {
    }

    public Staff_salary(String ID, Integer baseSalary, Integer benefit, Integer livingAllowance, Integer totalCut, Integer telBill, Integer utiBill, Integer houseRent, Integer incomeTax, Integer sanFee, Integer accumFunds, Integer netPay, Integer shouldPay, Date date) {
        this.ID = ID;
        this.baseSalary = baseSalary;
        this.benefit = benefit;
        this.livingAllowance = livingAllowance;
        this.totalCut = totalCut;
        this.telBill = telBill;
        this.utiBill = utiBill;
        this.houseRent = houseRent;
        this.incomeTax = incomeTax;
        this.sanFee = sanFee;
        this.accumFunds = accumFunds;
        this.netPay = netPay;
        this.shouldPay = shouldPay;
        this.date = (java.sql.Date) date;
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
     * @return baseSalary
     */
    public Integer getBaseSalary() {
        return baseSalary;
    }

    /**
     * 设置
     * @param baseSalary
     */
    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * 获取
     * @return benefit
     */
    public Integer getBenefit() {
        return benefit;
    }

    /**
     * 设置
     * @param benefit
     */
    public void setBenefit(Integer benefit) {
        this.benefit = benefit;
    }

    /**
     * 获取
     * @return livingAllowance
     */
    public Integer getLivingAllowance() {
        return livingAllowance;
    }

    /**
     * 设置
     * @param livingAllowance
     */
    public void setLivingAllowance(Integer livingAllowance) {
        this.livingAllowance = livingAllowance;
    }

    /**
     * 获取
     * @return totalCut
     */
    public Integer getTotalCut() {
        return totalCut;
    }

    /**
     * 设置
     * @param totalCut
     */
    public void setTotalCut(Integer totalCut) {
        this.totalCut = totalCut;
    }

    /**
     * 获取
     * @return telBill
     */
    public Integer getTelBill() {
        return telBill;
    }

    /**
     * 设置
     * @param telBill
     */
    public void setTelBill(Integer telBill) {
        this.telBill = telBill;
    }

    /**
     * 获取
     * @return utiBill
     */
    public Integer getUtiBill() {
        return utiBill;
    }

    /**
     * 设置
     * @param utiBill
     */
    public void setUtiBill(Integer utiBill) {
        this.utiBill = utiBill;
    }

    /**
     * 获取
     * @return houseRent
     */
    public Integer getHouseRent() {
        return houseRent;
    }

    /**
     * 设置
     * @param houseRent
     */
    public void setHouseRent(Integer houseRent) {
        this.houseRent = houseRent;
    }

    /**
     * 获取
     * @return incomeTax
     */
    public Integer getIncomeTax() {
        return incomeTax;
    }

    /**
     * 设置
     * @param incomeTax
     */
    public void setIncomeTax(Integer incomeTax) {
        this.incomeTax = incomeTax;
    }

    /**
     * 获取
     * @return sanFee
     */
    public Integer getSanFee() {
        return sanFee;
    }

    /**
     * 设置
     * @param sanFee
     */
    public void setSanFee(Integer sanFee) {
        this.sanFee = sanFee;
    }

    /**
     * 获取
     * @return accumFunds
     */
    public Integer getAccumFunds() {
        return accumFunds;
    }

    /**
     * 设置
     * @param accumFunds
     */
    public void setAccumFunds(Integer accumFunds) {
        this.accumFunds = accumFunds;
    }

    /**
     * 获取
     * @return netPay
     */
    public Integer getNetPay() {
        return netPay;
    }

    /**
     * 设置
     * @param netPay
     */
    public void setNetPay(Integer netPay) {
        this.netPay = netPay;
    }

    /**
     * 获取
     * @return shouldPay
     */
    public Integer getShouldPay() {
        return shouldPay;
    }

    /**
     * 设置
     * @param shouldPay
     */
    public void setShouldPay(Integer shouldPay) {
        this.shouldPay = shouldPay;
    }

    /**
     * 获取
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(Date date) {
        this.date = (java.sql.Date) date;
    }

    public String toString() {
        return "Staff_salary{ID = " + ID + ", baseSalary = " + baseSalary + ", benefit = " + benefit + ", livingAllowance = " + livingAllowance + ", totalCut = " + totalCut + ", telBill = " + telBill + ", utiBill = " + utiBill + ", houseRent = " + houseRent + ", incomeTax = " + incomeTax + ", sanFee = " + sanFee + ", accumFunds = " + accumFunds + ", netPay = " + netPay + ", shouldPay = " + shouldPay + ", date = " + date + "}";
    }
}
