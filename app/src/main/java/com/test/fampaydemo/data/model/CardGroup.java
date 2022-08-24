package com.test.fampaydemo.data.model;

import java.util.List;

public class CardGroup {
    private int id;
    private String name;
    private DesignType designType;
    private int cardType;
    private List<Card> cards;
    private boolean isScrollable;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DesignType getDesignType() {
        return designType;
    }

    public int getCardType() {
        return cardType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean isScrollable() {
        return isScrollable;
    }
}