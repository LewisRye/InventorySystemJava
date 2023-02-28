package com.lewis.inventory;

import java.sql.*;

public class Login {
    public static int account_id = 0; // no account IDs are allowed to be zero
    public static String username = null;

    public Boolean login(String username, String passhash) {
        this.account_id = 0;
        this.username = null;

        int count = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true" + "&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT", "root", "");
            stmt = conn.prepareStatement("SELECT accounts.account_id FROM accounts WHERE username = ? AND passhash = ? GROUP BY accounts.account_id;");
            stmt.setString(1, username);
            stmt.setString(2, passhash);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Login.account_id = rs.getInt("account_id");
                Login.username = username;
            }
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Login.account_id > 0;
    }
}
