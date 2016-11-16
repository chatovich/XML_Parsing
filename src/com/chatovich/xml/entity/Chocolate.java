package com.chatovich.xml.entity;

import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class Chocolate extends Candy{

    private FillingType fillng;

    public Chocolate(String name, int ccal, String production, FillingType filling) {
        super(name, ccal, production);
        this.fillng = filling;
    }

    public Chocolate(){
        super();
    }

    public FillingType getFillng() {
        return fillng;
    }


    @Override
    public void setFlavor(FlavorType flavor) {
        throw new RuntimeException("Chocolate candy doesn't have a flavor, it's already chocolate");
    }

    @Override
    public void setFilling(FillingType filling) {
        this.fillng = filling;
    }

    @Override
    public String toString(){
        return "name: "+super.getName()+", filling: "+this.fillng+", ccal: "+super.getCcal()+", production: "+super.getProduction()+
                ", ingridients: " +super.getIngridients()+ ", nutritional values: "+super.getNutritionals();
    }
}
