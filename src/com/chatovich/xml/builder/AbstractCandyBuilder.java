package com.chatovich.xml.builder;

import com.chatovich.xml.entity.Candy;
import com.chatovich.xml.entity.CandyShop;

import java.util.Set;

/**
 * Created by Yultos_ on 17.11.2016
 */
public abstract class AbstractCandyBuilder {

    protected CandyShop candyShop;

    public AbstractCandyBuilder() {
        this.candyShop = new CandyShop();
    }

    public CandyShop getCandyShop() {
        return candyShop;
    }

    public void setCandyShop(CandyShop candyShop) {
        this.candyShop = candyShop;
    }

    abstract public void buildSetCandies(String fileName);

    public Set<Candy> getCandies() {
        return candyShop.getCandies();
    }
}
