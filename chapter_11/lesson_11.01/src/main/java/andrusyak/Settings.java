package andrusyak;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by bogdan on 9/5/16.
 */
public class Settings {
    private final Properties properties = new Properties();

    public Settings(String propertiesLocation) {
        this.loadProperties(propertiesLocation);
    }

    private void loadProperties(String propertiesLocation) {
        try {
            this.properties.load(new FileReader(this.getClass().getClassLoader().getResource(propertiesLocation).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return this.properties.getProperty(key);
    }
}
