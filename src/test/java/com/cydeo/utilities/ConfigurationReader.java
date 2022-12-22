package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create the object of Properties class
    //We need properties class to use methods coming from class like load(), getProperty("key")
    //it is static bc we are using it in static method
    //it is private bc I will be using only in this class
    private static Properties properties = new Properties();

    static{
        try {
            //2- Create the object of FileInputStream
            //We need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("config.properties");

            //3- Load the properties object using FileInputStream object
            // Load "Properties" object with the "file" we opened using FileInputStream
            properties.load(file);

            //close the file after loading
                //if we do not close the file, it will take space from computer memory like Scanner
            file.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    This method is used to read value from a configuration.properties file
    @param keyword --> key name in configuration.properties file
    @return --> value for the key. returns null if key is not found
    driver.get(ConfigurationReader).getProperty('env')
     */

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
