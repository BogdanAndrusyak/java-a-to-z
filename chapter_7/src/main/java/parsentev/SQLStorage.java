package parsentev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Properties;

/**
 * TODO: comment.
 * Created by Bogdan on 4/19/2016.
 */
public class SQLStorage {
    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class); // Logger

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_a_to_z";
        String username = "postgres";
        String password = "kolo0";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from users where id=?");
            st.setInt(1, 6);
            st.executeUpdate();

//            ResultSet generatedKeys = st.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                System.out.println(generatedKeys.getInt(1));
//            }

//            PreparedStatement st = conn.prepareStatement("SELECT * FROM users as u where u.id in(?, ?, ?)");
//            st.setInt(1, 1);
//            st.setInt(2, 3);
//            st.setInt(3, 4);
//            ResultSet rs = st.executeQuery(); // ResultSet - итератор указивает на первую строку
//            while (rs.next()) {
//                System.out.println(String.format("%s %s %s", rs.getInt("id"), rs.getString("login"), rs.getTimestamp("create_data"))); // лучше указивать назву столбца а не его номер
//            }
//            rs.close(); // todo нужно перенести в finally
//            st.close();
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e); // e - always
                }
            }
        }
    }
}
