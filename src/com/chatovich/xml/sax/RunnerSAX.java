package com.chatovich.xml.sax;

import com.chatovich.xml.entity.Candy;
import com.chatovich.xml.entity.Caramel;
import com.chatovich.xml.entity.Chocolate;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class RunnerSAX {

    final static String FILE_NAME = "file/candies.xml";
    final static Logger LOGGER = LogManager.getLogger(RunnerSAX.class);

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

        Set<Candy> candies = candyHandler.getCandyShop();
        LOGGER.log(Level.INFO, "Caramel candies:");
        for (Candy candy : candies) {
            if (candy instanceof Caramel){
                System.out.println(candy);
            }
        }
        LOGGER.log(Level.INFO, "Chocolate candies:");
        for (Candy candy : candies) {
            if (candy instanceof Chocolate){
                System.out.println(candy);
            }
        }
    }
}
