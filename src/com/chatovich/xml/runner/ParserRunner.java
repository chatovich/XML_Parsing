package com.chatovich.xml.runner;

import com.chatovich.xml.builder.AbstractCandyBuilder;
import com.chatovich.xml.builder.DOM_Builder;
import com.chatovich.xml.entity.Candy;
import com.chatovich.xml.entity.Caramel;
import com.chatovich.xml.entity.Chocolate;
import com.chatovich.xml.factory.CandyBuilderFactory;
import com.chatovich.xml.type.ParserType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class ParserRunner {


    final static String FILE_NAME = "file/candies.xml";

    public static void main(String[] args) {

        OutputCandies outputCandies = new OutputCandies();
        CandyBuilderFactory sFactory = new CandyBuilderFactory();
        outputCandies.output(sFactory, FILE_NAME);
    }


}
