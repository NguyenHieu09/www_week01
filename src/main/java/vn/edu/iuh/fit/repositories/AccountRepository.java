package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
//    get all account
    public List<Account> getAllAccount() throws SQLException, ClassNotFoundException {
        List<Account> lstAcount= null;
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "select * from account";
        try {
            lstAcount = new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString(1);
                String fullName = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                Status status;
                int statusAcc = rs.getInt(6);

                if(statusAcc == 1)
                   status = Status.ACTIVE;
                else if(statusAcc == 0)
                    status = Status.DEACTIVE;
                else
                    status = Status.DELETED;
                Account acc = new Account(id, fullName, pass, email, phone,status);
                lstAcount.add(acc);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lstAcount;
    }

    public boolean addAccount(Account account) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();;
        PreparedStatement stm = null;
        int n= 0;
        String sql = "insert into account(account_id,full_name,password,email,phone,status) values(?,?,?,?,?,?)";
        try {
            stm = con.prepareStatement(sql);
            stm.setString(1, account.getId());
            stm.setString(2,account.getFullName());
            stm.setString(3,account.getPassword());
            stm.setString(4, account.getEmail());
            stm.setString(5,account.getPhone());
            stm.setInt(6,Status.ACTIVE.getValue());
            n = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n>0;
    }

    public Account login(Account account) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM account WHERE email = ? AND password = ? and status =?";
        PreparedStatement s  = null;
        Account acc = null;
        try {
            s = con.prepareStatement(sql);
            s.setString(1,account.getEmail());
            s.setString(2, account.getPassword());
            s.setInt(3, Status.ACTIVE.getValue());
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String fullName = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
//                Status status;
//                int statusAcc = rs.getInt(6);
//
//                if(statusAcc == 1)
//                    status = Status.ACTIVE;
//                else if(statusAcc == 0)
//                    status = Status.DEACTIVE;
//                else
//                    status = Status.DELETED;
                acc = new Account(id, fullName, pass, email, phone,Status.ACTIVE);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return acc;
    }

    public boolean updateStatusAccount(String id, Status status) throws SQLException, ClassNotFoundException {
        String sql = "update account set status=? where account_id=?";
        PreparedStatement s= null;
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            s = con.prepareStatement(sql);
            s.setInt(1,status.getValue());
            s.setString(2,id);
            s.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateAccount(Account account) throws SQLException, ClassNotFoundException {
        String sql = "update Account set full_name=?, password=?, email=?, phone=?, status=? where account_id=?";
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement s = null;
        int n= 0;
        try {
            s = con.prepareStatement(sql);
            s.setString(1,account.getFullName());
            s.setString(2, account.getPassword());
            s.setString(3,account.getEmail());
            s.setString(4,account.getPhone());
            s.setInt(5,account.getStatus().getValue());
            s.setString(6,account.getId());
            n=s.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return n>0;
    }

    public List<Account> getAccountByRole(String role) throws SQLException, ClassNotFoundException {
        String sql = "select acc.* from account acc JOIN grant_access gr ON acc.account_id = gr.account_id where role_id=?";
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement s =null;
        List<Account> accountList= new ArrayList<>();
        try {
            s = con.prepareStatement(sql);
            s.setString(1,role);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String fullName = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                Status status;
                int statusAcc = rs.getInt(6);

                if(statusAcc == 1)
                    status = Status.ACTIVE;
                else if(statusAcc == 0)
                    status = Status.DEACTIVE;
                else
                    status = Status.DELETED;
                Account acc = new Account(id, fullName, pass, email, phone,status);
                accountList.add(acc);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accountList;
    }

    public Account findAccountById(String id) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM account WHERE account_id=?";
        PreparedStatement s  = null;
        Account acc = null;
        try {
            s = con.prepareStatement(sql);
            s.setString(1,id);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                String idAcc = rs.getString(1);
                String fullName = rs.getString(2);
                String pass = rs.getString(3);
                String email = rs.getString(4);
                String phone = rs.getString(5);
                Status status;
                int statusAcc = rs.getInt(6);

                if(statusAcc == 1)
                    status = Status.ACTIVE;
                else if(statusAcc == 0)
                    status = Status.DEACTIVE;
                else
                    status = Status.DELETED;
                acc = new Account(idAcc, fullName, pass, email, phone,status);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return acc;
    }
}
