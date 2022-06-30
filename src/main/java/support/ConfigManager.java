package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static support.TestContext.configFile;

public class ConfigManager {

    static Properties prop = new Properties();

    public static String getConfigDataFileData(String key) throws IOException {
        prop = readConfigFile();
        key = prop.getProperty(key);
        return key;
    }

    private static Properties readConfigFile() throws IOException {
        FileInputStream fis = new FileInputStream(configFile);
        prop.load(fis);
        return prop;
    }
}
