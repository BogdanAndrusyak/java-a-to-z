package andrusyak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by bogdan on 9/5/16.
 */
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
        throw new IllegalStateException("Could not create new user");
    }
}
