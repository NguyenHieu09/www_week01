package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GrantAccessRepository {
    public GrantAccess getGrantAccessByAccountId (String accountId) throws SQLException, ClassNotFoundException {
        Connection con = ConnectDB.getInstance().getConnection();
        GrantAccess grantAccess = null;
        String sql = "select * from grant_access where account_id=?";
        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            s.setString(1, accountId);
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                Account account = new Account(rs.getString(2));
                boolean isGrant = rs.getBoolean(3);
                String note = rs.getString(4);
                grantAccess = new GrantAccess(id,account,isGrant,note);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return grantAccess;

    }
}
