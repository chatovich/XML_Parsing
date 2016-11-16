package com.chatovich.xml.sax;

/**
 * Created by Yultos_ on 16.11.2016
 */
public enum CandyEnum {
    
    CALORIES ("calories"),
    PRODUCTION ("production"),
    INGRIDIENTS ("ingridients"),
    NUTRITIONAL ("nutritional"),
    FILLING ("filling"),
    CANDIES ("candies");


    private String value;

    CandyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
