package Lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2_2 {
    public Ex2_2() {
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    String str = "select title, price from books where author = 'Codelean vn'";
                    System.out.println("The statement is: " + str);
                    ResultSet rs = stmt.executeQuery(str);

                    for(int var5 = 0; rs.next(); ++var5) {
                        String title = rs.getString("title");
                        double price = rs.getDouble("price");
                        System.out.println(title + "," + price);
                    }
                } catch (Throwable var11) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var12) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var13) {
            var13.printStackTrace();
        }

    }
}
