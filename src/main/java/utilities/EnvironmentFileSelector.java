package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvironmentFileSelector {

    public static Map<String, String> envMap = new HashMap<String, String>();

    private static Properties properties = new Properties();
    public static Map<String, String> envFileSelected (){
        //Here we set the system properties key
        String sysProperKey = System.getProperty("environment");

        try {
            FileInputStream fileInputStreamDEV = new FileInputStream(System.getProperty("user.dir") + "/systemPropertiesInputs/dev.properties");
            //Here we set the system properties default value
            if (sysProperKey.equalsIgnoreCase("dev")){
                properties.load(fileInputStreamDEV);
                envMap.put("ServerUrl", properties.getProperty("ServerUrl"));
                envMap.put("portNo", properties.getProperty("portNo"));
                envMap.put("username", properties.getProperty("username"));
                envMap.put("password", properties.getProperty("password"));
            }
            if (sysProperKey.equalsIgnoreCase("qa")){
                FileInputStream fileInputStreamQA = new FileInputStream(System.getProperty("user.dir")+"/systemPropertiesInputs/qa.properties");
                properties.load(fileInputStreamQA);
                envMap.put("ServerUrl", properties.getProperty("ServerUrl"));
                envMap.put("portNo", properties.getProperty("portNo"));
                envMap.put("username", properties.getProperty("username"));
                envMap.put("password", properties.getProperty("password"));
            }
            if (sysProperKey.equalsIgnoreCase("staging")){
                FileInputStream fileInputStreamSTAGING = new FileInputStream(System.getProperty("user.dir") + "/systemPropertiesInputs/staging.properties");
                properties.load(fileInputStreamSTAGING);
                envMap.put("ServerUrl", properties.getProperty("ServerUrl"));
                envMap.put("portNo", properties.getProperty("portNo"));
                envMap.put("username", properties.getProperty("username"));
                envMap.put("password", properties.getProperty("password"));
            }
        }catch (FileNotFoundException filenotfoundexception){
            filenotfoundexception.fillInStackTrace();
        }catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException.fillInStackTrace();
        }catch (SecurityException securityException){
            securityException.fillInStackTrace();
        }catch (IOException ioException){
            ioException.fillInStackTrace();
        }
        return envMap;
    }

}
