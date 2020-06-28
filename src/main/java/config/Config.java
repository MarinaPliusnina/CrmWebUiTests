package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static String getProperty(String s) {
        InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");

        Properties prop = new Properties();

        try{
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(s);
    }
}
