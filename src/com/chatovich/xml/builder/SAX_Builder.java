package com.chatovich.xml.builder;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Yultos_ on 17.11.2016
 */
public class SAX_Builder extends AbstractCandyBuilder {

    final static Logger LOGGER = LogManager.getLogger(SAX_Builder.class);
    CandyHandler candyHandler;
    XMLReader reader;

    public SAX_Builder(){
        super();
        candyHandler = new CandyHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);

        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "factory parcer mistake "+ e);
        }
    }

    @Override
    public void buildSetCandies(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        candyShop.getCandies().addAll(candyHandler.getCandyShop());

    }

}
