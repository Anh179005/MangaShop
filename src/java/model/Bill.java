/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class Bill {
    private int bill_id;
    private Date date;
    private double tong_tien;
    private int account_id;

    public Bill() {
    }

    public Bill(int bill_id, Date date, double tong_tien, int account_id) {
        this.bill_id = bill_id;
        this.date = date;
        this.tong_tien = tong_tien;
        this.account_id = account_id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Bill{" + "bill_id=" + bill_id + ", date=" + date + ", tong_tien=" + tong_tien + ", account_id=" + account_id + '}';
    }
    
}
