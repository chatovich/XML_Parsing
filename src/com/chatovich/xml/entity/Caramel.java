package com.chatovich.xml.entity;

import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class Caramel extends Candy {

    private FlavorType flavor;

    public Caramel(String name, int ccal, String production, FlavorType flavor) {
        super(name, ccal, production);
        this.flavor = flavor;
    }

    public Caramel(){
        super();

    }

    public FlavorType getFlavor() {
        return flavor;
    }

    @Override
    public void setFlavor(FlavorType flavor) {
        this.flavor = flavor;
    }

    @Override
    public void setFilling(FillingType flavor) {
        throw new RuntimeException("Caramel doesn't have a filling");
    }

    @Override
     public String toString(){
        return "name: "+super.getName()+", flavor: "+this.flavor+", ccal: "+super.getCcal()+", production: "+super.getProduction()+
                ", ingridients: " +super.getIngridients()+ ", nutritional values: "+super.getNutritionals();
    }
}
