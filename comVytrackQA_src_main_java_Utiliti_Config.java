package Utiliti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public  abstract class  Config {
    static Properties prop;

    static {
     String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            prop = new Properties();
            prop.load(file);
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("This Path "+path+" Not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }
}
