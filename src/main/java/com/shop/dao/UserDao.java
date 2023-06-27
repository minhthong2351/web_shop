package com.shop.dao;
import java.sql.PreparedStatement;

import com.shop.beans.Products;
import com.shop.beans.User;
import com.shop.db.DBConnect;
import com.shop.db.JDBIConnector;
import com.shop.service.AES256;
import com.shop.service.SendEmail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UserDao {
    Connection conn;
    PreparedStatement ps = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    PreparedStatement preparedStatement1;

    public User checkLogin(String username, String password) {
        Connection conn = DBConnect.getConnect();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user "
                    + "WHERE username=? AND password=? AND status=1");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, AES256.encrypt(password));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(9));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int RegisterUser(User user) {
        int set = 0;
        Connection conn = DBConnect.getConnect();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE username=? ");
            preparedStatement.setString(1, user.getUsername());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                    return set = 2;
            } else {
                preparedStatement1 = conn.prepareStatement("SELECT * FROM user WHERE email=? ");
                preparedStatement1.setString(1, user.getEmail());
                ResultSet rs1 = preparedStatement1.executeQuery();
                if(rs1.next()){
                        return set = 3;
                } else {
                    Random random = new Random();
                    int n = random.nextInt(99999999) + 11111111;
                    String user_id = "" + n;
                    preparedStatement = conn.prepareStatement("INSERT INTO user (userid,username,password,name,phone,email,isAdmin) values (?,?,?,?,?,?,0)");
                    preparedStatement.setString(1, user_id);
                    preparedStatement.setString(2, user.getUsername());
                    preparedStatement.setString(3, AES256.encrypt(user.getPassword()));
                    preparedStatement.setString(4, user.getName());
                    preparedStatement.setString(5, user.getPhone());
                    preparedStatement.setString(6, user.getEmail());
                    int i = preparedStatement.executeUpdate();
                    if (i != 0) {
                        SendEmail se = new SendEmail(user.getEmail(), AES256.encrypt(user.getPassword()));
                        se.sendMailActivate();
                        return set = 1;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean checkUser(String username, String email) {
        Connection conn = DBConnect.getConnect();
        boolean set = false;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE username=? AND email=? AND status=1");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String checkUsername = rs.getString("username");
                String checkUseremail = rs.getString("email");
                String pass = rs.getString("password");
                if (username.equals(checkUsername) && email.equals(checkUseremail)) {
                    SendEmail se = new SendEmail(email, AES256.decrypt(pass));
                    se.sendMailForgot();
                    return set = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean changeProfile(String userid, String userName, String phoneNumber, String email, String address) {
        Connection conn = DBConnect.getConnect();
        boolean set = false;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE userid=? AND status=1");
            preparedStatement.setString(1, userid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String oldName = rs.getString("name");
                String oldPhone = rs.getString("phone");
                String oldEmail = rs.getString("email");
                String oldAddress = rs.getString("address");
                preparedStatement1 = conn.prepareStatement("UPDATE user SET name=?, phone=?, email=?, address=? WHERE userid=?");
                if (userName.length() > 1) {
                    preparedStatement1.setString(1, userName);
                } else {
                    preparedStatement1.setString(1, oldName);
                }
                //
                if (phoneNumber.length() > 1) {
                    preparedStatement1.setString(2, phoneNumber);
                } else {
                    preparedStatement1.setString(2, oldPhone);
                }
                //
                if (email.length() > 1) {
                    preparedStatement1.setString(3, email);
                } else {
                    preparedStatement1.setString(3, oldEmail);
                }
                //
                if (address.length() > 1) {
                    preparedStatement1.setString(4, address);
                } else {
                    preparedStatement1.setString(4, oldAddress);
                }
                preparedStatement1.setString(5, userid);
                int rs1 = preparedStatement1.executeUpdate();
                if (rs1 > 0) {
                    return set = true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public boolean changePass(String userid, String oldPass, String newPass) {
        Connection conn = DBConnect.getConnect();
        boolean set = false;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE userid=? AND status=1");
            preparedStatement.setString(1, userid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String checkPass = rs.getString("password");
                if (oldPass.equals(AES256.decrypt(checkPass))) {
                    preparedStatement1 = conn.prepareStatement("UPDATE user SET password=? WHERE userid=?");
                    preparedStatement1.setString(1, AES256.encrypt(newPass));
                    preparedStatement1.setString(2, userid);
                    int rs1 = preparedStatement1.executeUpdate();
                    if (rs1 > 0) {
                        return set = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

    public User viewProfile(String userid) {
        Connection conn = DBConnect.getConnect();
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM user WHERE userid=? AND status=1");
            preparedStatement.setString(1, userid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // phuong thuc lay danh sach cac user
    public static List<User> getAllUser() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> result = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            conn = new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

        } catch (Exception e) {

        }
        return result;
    }

    // phuong thuc delete
    public void deleteStudent(String id) {
        String query = "delete from user\n" + "where userid=?";
        try {
            conn = new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }

    }

    // phuong thuc insert
    public void insertUser(String userid, String username, String password, String name, String phone, String email, String address, String status) {
        String query = "insert into user values(?,?,?,?,?,?,?,?)";
        try {
            conn = new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, userid);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, name);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, email);
            ps.setString(8, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // phuong thuc lay thong tin cua user tu id
    public User getUserByID(String userid) {
        String query = "select * from User\n" + "where userid=?";
        try {
            conn = new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));

            }

        } catch (Exception e) {
        }
        return null;
    }

    // phuong thuc update
    public void updateUser(String userid, String username, String password, String name, String phone, String email, String address, String status) {

        String query="update user set username=?,password=?, name=?, phone=?, email=? , address=?,status=? where userid=?";
        try {
            conn= new DBConnect().getConnect();
            ps = conn.prepareStatement(query);
            ps.setString(1,username );
            ps.setString(2,password );
            ps.setString(3,name);
            ps.setString(4,phone );
            ps.setString(5,email );
            ps.setString(6,address );
            ps.setString(7,status );
            ps.setString(8,userid );
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
}

