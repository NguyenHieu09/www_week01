package vn.edu.iuh.fit.models;

public class GrantAccess {
    private String id;
    private Account account;
    private boolean isGrant;
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        this.isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {
    }

    public GrantAccess(String id, Account account, boolean isGrant, String note) {
        this.id = id;
        this.account = account;
        this.isGrant = isGrant;
        this.note = note;
    }



    @Override
    public String toString() {
        return "GrantAccess{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
