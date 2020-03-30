package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        String propertiesFilePath =  "qa.properties";

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getEnvName() {
        return System.getProperty("env");

    }

    public Properties getProperties() {
        return properties;
    }

    public String getHost() {
        return properties.getProperty("host");
    }
}
