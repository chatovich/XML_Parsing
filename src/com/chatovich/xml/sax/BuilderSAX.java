package com.chatovich.xml.sax;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class BuilderSAX {

    final static String FILE_NAME = "file/candies.xml";
    final static Logger LOGGER = LogManager.getLogger(BuilderSAX.class);

    public static void main(String[] args) {

        CandyHandler candyHandler = new CandyHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(candyHandler);
            reader.parse(FILE_NAME);

        } catch (SAXException e) {
            LOGGER.log(Level.ERROR, "sax parcer mistake "+ e);
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "i/o mistake "+e);
        }
    }
}
