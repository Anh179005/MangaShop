/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Another_Cart;
import model.Bill;
import model.Cart;
import model.Item;
import model.Manga;

/**
 *
 * @author ACER
 */
public class cartDAO extends DBContext {

    public void addNewBill(int account_id) {
        String sql = "INSERT INTO Bill (date,tong_tien,account_id)\n"
                + "VALUES (GETDATE(),0,?);";
        try {

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, account_id);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Cart> getShoppingCartByBillId(int bill_id) {
        ArrayList<Cart> list = new ArrayList<>();
        try {

            String sql = "select bm.id, b.bill_id, m.name,bm.so_luong, m.price, (m.price * bm.so_luong) AS Tong\n"
                    + "from Bill_Manga bm, Manga m, Bill b\n"
                    + "where m.id=bm.manga_id and b.bill_id=bm.bill_id and b.bill_id=?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, bill_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cart c = new Cart();
                c.setId(rs.getInt("id"));
                c.setBill_id(rs.getInt("bill_id"));
                c.setName(rs.getString("name"));
                c.setSo_luong(rs.getInt("so_luong"));
                c.setPrice(rs.getDouble("price"));
                c.setTong(rs.getDouble("Tong"));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateSo_luong_Cho_1_Manga(int so_luong, int id) {
        String sql = "update Bill_Manga\n"
                + "set so_luong=?\n"
                + "where id= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, so_luong);
            stm.setInt(2, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Bill getNewestBill() {
        try {

            String sql = "SELECT TOP 1 * FROM Bill\n"
                    + "ORDER BY date DESC;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Bill b = new Bill();
                b.setBill_id(rs.getInt("bill_id"));
                b.setDate(rs.getDate("date"));
                b.setTong_tien(rs.getDouble("tong_tien"));
                b.setAccount_id(rs.getInt("account_id"));

                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addBill_VA(Account acc, Another_Cart cart) {
        try {
            String sql = "INSERT INTO Bill (date,tong_tien,account_id)\n"
                    + "VALUES (GETDATE(),?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDouble(1, cart.getTotalMoney());
            stm.setInt(2, acc.getId());
            stm.executeUpdate();

            //Lay id cua Bill vua add
            String sql1 = "SELECT TOP 1 bill_id FROM Bill\n"
                    + "ORDER BY bill_id DESC;";
            PreparedStatement stm1 = connection.prepareStatement(sql1);
            ResultSet rs = stm1.executeQuery();
            if (rs.next()) {
                int bill_id = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into Bill_Manga(bill_id,manga_id,so_luong)\n"
                            + "values(?,?,?)";
                    PreparedStatement stm2 = connection.prepareStatement(sql1);
                    stm2.setInt(1, bill_id);
                    stm2.setInt(2, i.getManga().getId());
                    stm2.setInt(3, i.getSo_luong());
                    stm2.executeUpdate();

                }

            }

        } catch (SQLException ex) {

        }
    }

    public void addNewMangaIntoCart(int bill_id, int manga_id) {
        String sql = "insert into Bill_Manga(bill_id,manga_id,so_luong)\n"
                + "values(?,?,1)";
        try {

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bill_id);
            stm.setInt(2, manga_id);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public static void main(String[] args) {
        Another_Cart a_cart = new Another_Cart();
        cartDAO cart = new cartDAO();
        DAO dao = new DAO();
        Manga m = dao.getMangaById("1");
        double price = m.getPrice();
        Item t = new Item(m, 1, price);
        a_cart.addItem(t);
        
        Manga m1 = dao.getMangaById("2");
        double price1 = m1.getPrice();
        Item t1 = new Item(m1, 3, price1);
        a_cart.addItem(t1);
        
        
        
        for (int i = 0; i < a_cart.getItems().size(); i++) {
            System.out.println(a_cart.getItems().get(i).toString());
            
        }
        System.out.println(a_cart.getTotalMoney());

    }

}
