package com.BasicApp.ReadProperties;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        AppConfig config= new AppConfig();
        //µ¥ÀýÄ£Ê½
        AppConfigSingleton config = AppConfigSingleton.getInstance();
        
        String paramA = config.getParamA();
        String paramB = config.getParamB();
        System.out.println("paramA="+paramA+", paramB="+paramB);
    }
}
