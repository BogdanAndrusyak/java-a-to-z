package andrusyak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 9/5/16.
 */
@Component
public class JdbcStorage implements Storage {
    private static final Logger Log = LoggerFactory.getLogger(JdbcStorage.class);
    private final Connection connection;

    public JdbcStorage(String settingsLocation) {
        Settings settings = new Settings(settingsLocation);
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void add(User user) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("insert into users(name) values(?)");
            statement.setString(1, user.getName());

            statement.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return users;
    }
}
