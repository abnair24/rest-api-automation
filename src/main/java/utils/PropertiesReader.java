package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        String propertiesFilePath =  getEnvName() +".properties";

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getEnvName() {

        String env = System.getProperty("env");

        if(null == env) {
            env = "qa";
        }
        return env;

    }

    public Properties getProperties() {
        return properties;
    }

    public String getHost() {
        return properties.getProperty("host");
    }
}
