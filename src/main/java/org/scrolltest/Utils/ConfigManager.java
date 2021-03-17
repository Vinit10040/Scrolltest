package org.scrolltest.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager manager;
    private final static Properties prop = new Properties();

    private ConfigManager() {
        try (InputStream inputStream = ConfigManager.class.getResourceAsStream("/config.properties")){
            prop.load(inputStream);

        }catch (Exception e){

        }

    }

    public static ConfigManager getInstance() {

        try {
            if (manager == null) {
                synchronized (ConfigManager.class) {
                    manager = new ConfigManager();
                }
            }
        } catch (Exception e) { }
            return manager;



    }

    public String getString(String key) {
        return System.getProperty(key,prop.getProperty(key));
    }
}