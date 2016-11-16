package com.chatovich.xml.entity;

import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yultos_ on 16.11.2016
 */
public abstract class Candy {

    private String name;
    private int ccal;
    private String production;
    private List<Ingridient> ingridients;
    private List<Ingridient> nutritionals;

    public Candy(String name, int ccal, String production) {
        this.name = name;
        this.ccal = ccal;
        this.production = production;
        this.ingridients = new ArrayList<>();
        this.nutritionals = new ArrayList<>();
    }

    public Candy(){
        this.ingridients = new ArrayList<>();
        this.nutritionals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCcal() {
        return ccal;
    }

    public String getProduction() {
        return production;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public List<Ingridient> getNutritionals() {
        return nutritionals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCcal(int ccal) {
        this.ccal = ccal;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void addIngridient(Ingridient ingridient) {
        this.ingridients.add(ingridient);
    }

    public void addNutritional(Ingridient nutritional) {
        this.nutritionals.add(nutritional);
    }

    public abstract void setFlavor (FlavorType flavor);
    public abstract void setFilling (FillingType filling);

    @Override
    public String toString(){
        return "name: "+name+", ccal: "+ccal+", production: "+production+", ingridients: "+ingridients+
                ", nutritional values: "+nutritionals;
    }
}
