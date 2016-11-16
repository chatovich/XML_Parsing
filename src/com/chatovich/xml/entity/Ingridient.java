package com.chatovich.xml.entity;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class Ingridient {

    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "("+name+" - "+weight+")";
    }
}
