package vn.edu.iuh.fit.models;

import java.time.LocalDateTime;

public class Logs {
    private long id;
    private Account account;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Logs() {
    }

    public Logs(long id, Account account, LocalDateTime loginTime, LocalDateTime logoutTime, String notes) {
        this.id = id;
        this.account = account;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", account=" + account +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
