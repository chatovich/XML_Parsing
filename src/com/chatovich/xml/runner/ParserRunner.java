package com.chatovich.xml.runner;


import com.chatovich.xml.factory.CandyBuilderFactory;


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
