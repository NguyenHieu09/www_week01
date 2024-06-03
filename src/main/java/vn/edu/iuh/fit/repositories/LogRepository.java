package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Logs;
import vn.edu.iuh.fit.models.Status;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    public boolean addLog(Logs logs) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();;
        PreparedStatement stm = null;
        int n=0;
        String sql = "insert into log(id,account_id,login_time,logout_time,notes) values(?,?,?,?,?)";
        try {
            stm = con.prepareStatement(sql);
            stm.setLong(1, logs.getId());
            stm.setString(2, logs.getAccount().getId());
            stm.setString(3, logs.getLoginTime().toString());
            stm.setString(4, logs.getLogoutTime().toString());
            stm.setString(5,logs.getNotes());
            n = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n>0;
    }

    public List<Logs> getLogs() throws SQLException, ClassNotFoundException {
        List<Logs> logsList= null;
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "select * from log";
        try {
            logsList  =new ArrayList<>();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rs.next()){
                long id = rs.getLong(1);
                Account account = new Account(rs.getString(2));
                String login = rs.getString(3);
                String logout = rs.getString(4);
                String note = rs.getString(5);
                Logs logs = new Logs(id, account, LocalDateTime.parse(login, formatter), LocalDateTime.parse(logout,formatter), note);
                logsList.add(logs);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return logsList;
    }

    public boolean updateLogoutTime(long id, LocalDateTime logoutTime) throws SQLException, ClassNotFoundException {
        String sql = "update log set logout_time=? where id=?";
        PreparedStatement s= null;
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            s = con.prepareStatement(sql);
            s.setString(1, logoutTime.toString());
            s.setLong(2,id);
            s.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public Logs findLogById(long id) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();
        String sql = "SELECT * FROM log WHERE id=?";
        PreparedStatement s  = null;
        Logs logs =null;
        try {
            s = con.prepareStatement(sql);
            s.setLong(1,id);
            ResultSet rs = s.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (rs.next()){
                long logId = rs.getLong(1);
                Account account = new Account(rs.getString(2));
                String login = rs.getString(3);
                String logout = rs.getString(4);
                String note = rs.getString(5);
                logs = new Logs(id, account, LocalDateTime.parse(login, formatter), LocalDateTime.parse(logout,formatter), note);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return logs;
    }





}
