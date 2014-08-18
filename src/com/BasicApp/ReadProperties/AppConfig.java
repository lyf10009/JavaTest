package com.BasicApp.ReadProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private String paramA;
    private String paramB;
    public String getParamA() {
        return paramA;
    }
    public void setParamA(String paramA) {
        this.paramA = paramA;
    }
    public String getParamB() {
        return paramB;
    }
    public void setParamB(String paramB) {
        this.paramB = paramB;
    }
    
    public AppConfig(){
        readConfig();
    }
    private void readConfig(){
        Properties p = new Properties();
        InputStream in = AppConfig.class.getResourceAsStream("appConfig.properties");
        try {
            p.load(in);
            this.paramA = p.getProperty("paramA");
            this.paramB = p.getProperty("paramB");
        } catch (IOException e) {
            System.out.println("≈‰÷√Œƒº˛º”‘ÿ¥ÌŒÛ£°£°£°");
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
