package com.chatovich.xml.builder;

import com.chatovich.xml.entity.*;
import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class CandyHandler extends DefaultHandler {

    private Candy current;
    private CandyEnum currentEnum;
    private CandyShop candyShop = new CandyShop();
    private EnumSet<CandyEnum> withText;

    public CandyHandler() {
        withText = EnumSet.range(CandyEnum.CALORIES, CandyEnum.FILLING);
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        currentEnum = CandyEnum.valueOf(localName.toUpperCase());
        switch (currentEnum){
            case CARAMEL:{
                current = new Caramel();
                current.setName(attrs.getValue(0));
                current.setFlavor(FlavorType.valueOf(attrs.getValue(1).toUpperCase()));
                currentEnum=null;
                break;
            }
            case CHOCOLATE:{
                current = new Chocolate();
                current.setName(attrs.getValue(0));
                currentEnum=null;
                break;
            }
            case INGRIDIENT:{
                Ingridient ingridient = new Ingridient();
                ingridient.setName(attrs.getValue(0));
                if (attrs.getLength()>1){
                    ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
                }
                current.addIngridient(ingridient);
                currentEnum=null;
                break;
            }
            case VALUE:{
                Ingridient ingridient = new Ingridient();
                ingridient.setName(attrs.getValue(0));
                ingridient.setWeight(Integer.parseInt(attrs.getValue(1)));
                current.addNutritional(ingridient);
                currentEnum=null;
                break;
            }
            default:{
                CandyEnum temp = CandyEnum.valueOf(localName.toUpperCase());
                if (withText.contains(temp)){
                    currentEnum = temp;
                } else{
                    currentEnum=null;
                }
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
        if (CandyEnum.CARAMEL.getValue().equals(localName)||CandyEnum.CHOCOLATE.getValue().equals(localName)) {
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
                case FILLING:
                    current.setFilling(FillingType.valueOf(s.toUpperCase()));
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
