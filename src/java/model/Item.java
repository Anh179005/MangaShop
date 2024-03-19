/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Item {
    private Manga manga;
    private int so_luong;
    private double gia;

    public Item() {
    }

    public Item(Manga manga, int so_luong, double gia) {
        this.manga = manga;
        this.so_luong = so_luong;
        this.gia = gia;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Item{" + "manga=" + manga + ", so_luong=" + so_luong + ", gia=" + gia + '}';
    }
    
}
