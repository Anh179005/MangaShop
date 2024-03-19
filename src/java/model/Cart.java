/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Cart {
    private int id;
    private int bill_id;
    private String name;
    private int so_luong;
    private double price;
    private double tong;

    public Cart() {
    }

    public Cart(int id, int bill_id, String name, int so_luong, double price, double tong) {
        this.id = id;
        this.bill_id = bill_id;
        this.name = name;
        this.so_luong = so_luong;
        this.price = price;
        this.tong = tong;
    }

  

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTong() {
        return tong;
    }

    public void setTong(double tong) {
        this.tong = tong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", bill_id=" + bill_id + ", name=" + name + ", so_luong=" + so_luong + ", price=" + price + ", tong=" + tong + '}';
    }

    
    
}
