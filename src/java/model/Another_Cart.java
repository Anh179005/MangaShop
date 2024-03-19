/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Another_Cart {

    private ArrayList<Item> items;

    public Another_Cart() {
        items = new ArrayList<>();
    }

    public Another_Cart(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    

    private Item getItemById(int id) {
        for (Item i : items) {
            if (i.getManga().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int getSo_LuongById(int id) {
        return getItemById(id).getSo_luong();
    }

    //thêm vào gi? hàng
    public void addItem(Item t) {
        //Có ? cart r?i
        if (getItemById(t.getManga().getId()) != null) {
            Item i = getItemById(t.getManga().getId());
            i.setSo_luong(i.getSo_luong() + t.getSo_luong());
        } else {
            //Chua có
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += i.getSo_luong() * i.getGia();
        }

        return t;
    }

}
