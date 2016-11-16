package com.chatovich.xml.dom;

import com.chatovich.xml.entity.Candy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class RunnerDOM {

    final static Logger LOGGER = LogManager.getLogger(RunnerDOM.class);
    final static String FILE_NAME = "file/candies.xml";

    public static void main(String[] args) {
        BuilderDOM builderDOM = new BuilderDOM();
        builderDOM.buildSetCandies(FILE_NAME);
        Set<Candy> candies = builderDOM.getCandies();
        candies.forEach(System.out::println);
    }


}
