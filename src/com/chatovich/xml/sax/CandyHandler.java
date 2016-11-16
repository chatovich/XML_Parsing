package com.chatovich.xml.sax;

import com.chatovich.xml.entity.*;
import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class CandyHandler extends DefaultHandler {

    private Candy current;
    private CandyEnum currentEnum;
    private CandyShop candyShop = new CandyShop();


    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        switch (localName){
            case "caramel":{
                current = new Caramel();
                current.setName(attrs.getValue(0));
                current.setFlavor(FlavorType.valueOf(attrs.getValue(1).toUpperCase()));
                break;
            }
            case "chocolate":{
                current = new Chocolate();
                current.setName(attrs.getValue(0));
                break;
            }
            case "ingridient":{
                Ingridient ingridient = new Ingridient();
                ingridient.setName(attrs.getValue(0));
                if (attrs.getLength()>1){
                    ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
                }
                current.addIngridient(ingridient);
                break;
            }
            case "value":{
                Ingridient ingridient = new Ingridient();
                ingridient.setName(attrs.getValue(0));
                ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
                current.addNutritional(ingridient);
                break;
            }
            default:{
                currentEnum = CandyEnum.valueOf(localName.toUpperCase());
            }
        }

//        if ("caramel".equals(localName)) {
//            current = new Caramel();
//            current.setName(attrs.getValue(0));
//            current.setFlavor(FlavorType.valueOf(attrs.getValue(1).toUpperCase()));
//        }
//        if ("chocolate".equals(localName)) {
//            current = new Chocolate();
//            current.setName(attrs.getValue(0));
//        }
//        if ("ingridient".equals(localName)) {
//            Ingridient ingridient = new Ingridient();
//            ingridient.setName(attrs.getValue(0));
//            ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
//            current.addIngridient(ingridient);
//        }
//        if ("nutritional".equals(localName)) {
//            Ingridient ingridient = new Ingridient();
//            ingridient.setName(attrs.getValue(0));
//            ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
//            current.addNutritional(ingridient);
//        }
//
//        else {
//            currentEnum = CandyEnum.valueOf(localName.toUpperCase());
//        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("caramel".equals(localName)||"chocolate".equals(localName)) {
            candyShop.addCandy(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case CALORIES:
                    current.setCcal(Integer.parseInt(s));
                    break;
                case PRODUCTION:
                    current.setProduction(s);
                    break;
                case INGRIDIENTS:
                    break;
                case NUTRITIONAL:
                    break;
                case FILLING:
                    current.setFilling(FillingType.valueOf(s.toUpperCase()));
                    break;
                case CANDIES:
                    break;

                default:throw new EnumConstantNotPresentException(
                        currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

    public Set<Candy> getCandyShop(){
        return candyShop.getCandies();
    }
}
