package com.chatovich.xml.builder;

/**
 * Created by Yultos_ on 16.11.2016
 */
public enum CandyEnum {
    
    CALORIES ("calories"),
    PRODUCTION ("production"),
    FILLING ("filling"),
    INGRIDIENTS ("ingridients"),
    NUTRITIONAL ("nutritional"),
    CANDIES ("candies"),
    CARAMEL ("caramel"),
    CHOCOLATE ("chocolate"),
    INGRIDIENT ("ingridient"),
    VALUE ("value"),
    NAME ("name"),
    FLAVOR ("flavor"),
    WEIGHT ("weight");


    private String value;

    CandyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
