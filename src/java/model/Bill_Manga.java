/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Bill_Manga {
    private int id;
    private int bill_id;
    private int manga_id;
    private int so_luong;

    public Bill_Manga() {
    }

    public Bill_Manga(int id, int bill_id, int manga_id, int so_luong) {
        this.id = id;
        this.bill_id = bill_id;
        this.manga_id = manga_id;
        this.so_luong = so_luong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getManga_id() {
        return manga_id;
    }

    public void setManga_id(int manga_id) {
        this.manga_id = manga_id;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    @Override
    public String toString() {
        return "Bill_Manga{" + "id=" + id + ", bill_id=" + bill_id + ", manga_id=" + manga_id + ", so_luong=" + so_luong + '}';
    }
    
}
