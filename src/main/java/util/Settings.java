package util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Properties;

public class Settings {
    private static Settings settings;
    private Properties properties;

    public static Settings getInstance() throws IOException {
        if (settings == null) {
            settings = new Settings();
        }
        return settings;
    }

    private Settings() throws IOException {
        File file = null;
        try {
            file = new File(Settings.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File configFile = new File(file.getParent() + System.getProperty("file.separator") + "settings.txt");
        properties = new Properties();
        properties.load(new FileInputStream(configFile.getAbsolutePath()));
    }

    public String getSetting(String settingName) {
        return (String) properties.get(settingName);
    }
}
