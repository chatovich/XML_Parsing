package com.chatovich.xml.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yultos_ on 16.11.2016
 */
public class CandyShop {

    private Set<Candy> candies;

    public CandyShop() {
        this.candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void addCandy(Candy candy) {
        this.candies.add(candy);
    }
}
