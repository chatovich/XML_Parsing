package com.chatovich.xml.builder;

import com.chatovich.xml.entity.Candy;
import com.chatovich.xml.entity.Caramel;
import com.chatovich.xml.entity.Chocolate;
import com.chatovich.xml.entity.Ingridient;
import com.chatovich.xml.type.FillingType;
import com.chatovich.xml.type.FlavorType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Yultos_ on 17.11.2016
 */
public class StAX_Builder extends AbstractCandyBuilder {

    final static Logger LOGGER = LogManager.getLogger(StAX_Builder.class);
    private XMLInputFactory inputFactory;
    public StAX_Builder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetCandies(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CandyEnum.CARAMEL.getValue().equals(name)||CandyEnum.CHOCOLATE.getValue().equals(name)) {
                        Candy candy = buildCandy(reader, name);
                        candyShop.addCandy(candy);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.log(Level.ERROR, "StAX error "+ ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.log(Level.ERROR, "file not found "+ ex);
        } finally {
            try {if (inputStream != null) {
                inputStream.close();
            }
            } catch (IOException e) {
                LOGGER.log(Level.ERROR, "impossible to close file "+ e);
            }
        }
    }

    private Candy buildCandy(XMLStreamReader reader, String candyType) throws XMLStreamException {

        Candy candy;
        if (candyType.equals(CandyEnum.CARAMEL.getValue())){
            candy = new Caramel();
        } else {
            candy = new Chocolate();
        }

        String name = reader.getAttributeValue(null, CandyEnum.NAME.getValue());
        String flavor = reader.getAttributeValue(null, CandyEnum.FLAVOR.getValue());
        candy.setName(name);
        if (flavor!=null){
            candy.setFlavor(FlavorType.valueOf(flavor.toUpperCase()));
        }

        String s;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    s = reader.getLocalName();
                    switch (CandyEnum.valueOf(s.toUpperCase())) {
                        case CALORIES:
                            candy.setCcal(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PRODUCTION:
                            candy.setProduction(getXMLText(reader));
                            break;
                        case FILLING:
                            candy.setFilling(FillingType.valueOf(getXMLText(reader).toUpperCase()));
                            break;
                        case INGRIDIENTS:
                            getIngridients(reader, candy);
                            break;
                        case NUTRITIONAL:
                            getIngridients(reader, candy);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.CARAMEL.getValue().equals(name)||CandyEnum.CHOCOLATE.getValue().equals(name)) {
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private void getIngridients(XMLStreamReader reader, Candy candy) throws XMLStreamException {
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    Ingridient ingridient = new Ingridient();
                    ingridient.setName(reader.getAttributeValue(null, CandyEnum.NAME.getValue()));
                    if (reader.getAttributeValue(null, CandyEnum.WEIGHT.getValue())!=null) {
                        ingridient.setWeight(Integer.parseInt(reader.getAttributeValue(null, CandyEnum.WEIGHT.getValue())));
                    }
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case INGRIDIENT: {
                            candy.addIngridient(ingridient);
                            break;
                        }
                        case VALUE:
                            candy.addNutritional(ingridient);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.INGRIDIENTS.getValue().equals(name)||CandyEnum.NUTRITIONAL.getValue().equals(name)){
                        return;}
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
