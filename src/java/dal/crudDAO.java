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
import model.Manga;

/**
 *
 * @author ACER
 */
public class crudDAO extends DBContext {

    public ArrayList<Manga> getAll() {
        try {
            ArrayList<Manga> list = new ArrayList<>();

            String sql = "select m.id, m.name, m.image, m.price, m.description, tg.name as AuthorName, tl.name as CategoryName\n"
                    + "from Manga m, Tacgia tg, TheLoai tl\n"
                    + "where m.author_id=tg.id and m.category_id=tl.id;";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Manga m = new Manga();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setImage(rs.getString("image"));
                m.setPrice(rs.getDouble("price"));
                m.setDescription(rs.getString("description"));
                m.setAuthor_name(rs.getString("AuthorName"));
                m.setCategory_name(rs.getString("CategoryName"));
                list.add(m);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Manga getMangaById(String id) {
        try {

            String sql = "select m.id, m.name, m.image, m.price, m.description, tg.name as AuthorName, tl.name as CategoryName\n"
                    + "from Manga m, Tacgia tg, TheLoai tl\n"
                    + "where m.author_id=tg.id and m.category_id=tl.id and m.id = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Manga m = new Manga();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setImage(rs.getString("image"));
                m.setPrice(rs.getDouble("price"));
                m.setDescription(rs.getString("description"));
                m.setAuthor_name(rs.getString("AuthorName"));
                m.setCategory_name(rs.getString("CategoryName"));
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public void insert(String name, String image, double price, String description, int aid, int cid) {
        String sql = "INSERT INTO Manga (name,image,price,description,author_id,category_id)\n"
                + "VALUES (?,?,?,?,?,?);";
        try {

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, image);
            stm.setDouble(3, price);
            stm.setString(4, description);
            stm.setInt(5, aid);
            stm.setInt(6, cid);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    //xoa 1 category
    public void delete(int id) {
        String sql = "delete from Manga where id=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update
    public void update(String name, double price, String description, int aid, int cid, int id) {
        String sql = "update Manga\n"
                + "set name=?,price=?,description=?,author_id=?,category_id=?\n"
                + "where id=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setDouble(2, price);
            stm.setString(3, description);
            stm.setInt(4, aid);
            stm.setInt(5, cid);
            stm.setInt(6, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
