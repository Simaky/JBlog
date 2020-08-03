package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties PROPERTIES = new Properties();
    private static final String PATH = "/src/main/resources/application.properties";

    static {
        try {
            PROPERTIES.load(PropertyUtils.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
