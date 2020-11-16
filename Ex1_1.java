package Lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1_1 {
    public Ex1_1() {
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    String strSelect1 = "Select * from books";
                    System.out.println("The sql statement 1 is " + strSelect1);
                    ResultSet rset = stmt.executeQuery(strSelect1);
                    System.out.println("Results: ");

                    for(int var5 = 0; rset.next(); ++var5) {
                        int id = rset.getInt("id");
                        String title = rset.getString("title");
                        String author = rset.getString("author");
                        double price = rset.getDouble("price");
                        int qty = rset.getInt("qty");
                        System.out.println(id + "," + title + "," + author + "," + price + "," + qty);
                    }
                } catch (Throwable var14) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var13) {
                            var14.addSuppressed(var13);
                        }
                    }

                    throw var14;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var15) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var12) {
                        var15.addSuppressed(var12);
                    }
                }

                throw var15;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var16) {
            var16.printStackTrace();
        }

    }
}
