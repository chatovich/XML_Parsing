package com.chatovich.xml.runner;

import com.chatovich.xml.builder.AbstractCandyBuilder;
import com.chatovich.xml.entity.Candy;
import com.chatovich.xml.entity.Caramel;
import com.chatovich.xml.entity.Chocolate;
import com.chatovich.xml.factory.CandyBuilderFactory;
import com.chatovich.xml.type.ParserType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Yultos_ on 17.11.2016
 */
public class OutputCandies {

    final static Logger LOGGER = LogManager.getLogger(OutputCandies.class);

    public void output (CandyBuilderFactory sFactory, String filename){
        EnumSet <ParserType> parserTypes = EnumSet.allOf(ParserType.class);
        for (ParserType parserType : parserTypes) {
            AbstractCandyBuilder builder = sFactory.createCandyBuilder(parserType);
            builder.buildSetCandies(filename);
            LOGGER.log(Level.INFO, "Using "+parserType.toString());
            printCandies(builder.getCandies());
        }

    }

    private void printCandies(Set<Candy> candies){

        LOGGER.log(Level.INFO, "Caramel candies: ");
        for (Candy candy : candies) {
            if (candy instanceof Caramel){
                LOGGER.log(Level.INFO, candy);
            }
        }
        LOGGER.log(Level.INFO, "Chocolate candies: ");
        for (Candy candy : candies) {
            if (candy instanceof Chocolate){
                LOGGER.log(Level.INFO, candy);
            }
        }
    }
}
