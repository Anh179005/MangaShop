/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author ACER
 */
public class AccountDAO extends DBContext {

    public Account checkAccount(String users, String pass) {
        String sql = "select id,username,password,email,admin,budget from Account\n"
                + "where username=? and password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, users);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getBoolean("admin"),
                        rs.getDouble("budget"));
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public Account checkAccountByUsername(String users) {
        String sql = "select id,username,password,email,admin,budget from Account\n"
                + "where username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, users);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getBoolean("admin"),
                        rs.getDouble("budget"));
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public Account checkAccountByEmail(String email) {
        String sql = "select id,username,password,email,admin,budget from Account\n"
                + "where email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getBoolean("admin"),
                        rs.getDouble("budget"));
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public void RegisterNewAccount(String username, String password, String email) {
        String sql = "INSERT INTO Account (username, password, email,admin,budget)\n"
                + "VALUES (?,?,?,0,0);";
        try {

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, email);
            stm.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    public void updateBudgetById(double budget, int id) {
        String sql = "update Account\n"
                + "set budget = budget + ?\n"
                + "where id= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDouble(1, budget);
            stm.setInt(2, id);
            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            AccountDAO dao = new AccountDAO();
            Account acc = dao.checkAccountByUsername("client1");
            dao.RegisterNewAccount("client3", "3", "client3@gmail.com");
            System.out.println(acc.toString());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
