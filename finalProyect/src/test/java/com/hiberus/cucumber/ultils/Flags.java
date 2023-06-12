package com.hiberus.cucumber.ultils;

public class Flags {
    private static final String BROWSER = "browser";
    private static final String HEADLESS = "headless";
    private final String browser = System.getProperty(BROWSER, "");
    private final boolean isHeadless = parseBoolean(System.getProperty(HEADLESS, ""));
    private static Flags instance;
    private Flags(){
    }
    public static Flags getInstance(){
        if(instance == null){
            instance = new Flags();
        }
        return instance;
    }
    public String getBrowser() {
        return this.browser;
    }
    public boolean isHeadless() {
        return this.isHeadless;
    }
    private boolean parseBoolean (String string){
        String value =((string == null) ? "false":string).toLowerCase().trim();
        if(value.equals("true")||value.equals("false")){
            return Boolean.parseBoolean(value);
        }else{
            return false;
        }
    }
}