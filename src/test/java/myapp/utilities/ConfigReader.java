package myapp.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //This class is used to read data from confugiration.properties file

    private static Properties properties;

    //Using Java logic, we wil create block and a method wich will return us the value from confugiration.properties
    // file
    //Static block==>It is called before the class==> runs the prerequisites of that class
    static {
        String path="confugiration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }

}
