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
import model.Manga;

/**
 *
 * @author ACER
 */
public class DAO extends DBContext {

    

    public ArrayList<Manga> getAllManga() {
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

    public ArrayList<Manga> getMangaByCategory(String cate_id) {
        try {
            ArrayList<Manga> list = new ArrayList<>();

            String sql = "select m.id, m.name, m.image, m.price, m.description, tg.name as AuthorName, tl.name as CategoryName\n"
                    + "from Manga m, Tacgia tg, TheLoai tl\n"
                    + "where m.author_id=tg.id and m.category_id=tl.id and tl.id LIKE '%'+?+'%';";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cate_id);
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

    public ArrayList<Manga> searchMangaByNameOrAuthor(String name) {
        try {
            ArrayList<Manga> list = new ArrayList<>();

            String sql = "select m.id, m.name, m.image, m.price, m.description, tg.name as AuthorName, tl.name as CategoryName\n"
                    + "from Manga m, Tacgia tg, TheLoai tl\n"
                    + "where m.author_id=tg.id and m.category_id=tl.id and ( m.name LIKE '%'+?+'%' or tg.name like '%'+?+'%' );";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, name);
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

    public static void main(String[] args) {
        try {
            DAO dao = new DAO();
            

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
