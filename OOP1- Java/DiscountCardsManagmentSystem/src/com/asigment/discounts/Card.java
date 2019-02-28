package com.asigment.discounts;

public abstract class Card {

    private Owner owner;
    private double turnoverForPrevMonth;


    public Card(Owner owner, double turnoverForPrevMonth) {
        this.owner = owner;
        this.turnoverForPrevMonth = turnoverForPrevMonth;
    }

    // Calculates discount of the current purchase
    public double calculateDiscount(double purchaseValue) {
        return (purchaseValue * this.getRealDiscountRate()) / 100;
    }

    public abstract double getRealDiscountRate ();


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getTurnoverForPrevMonth() {
        return turnoverForPrevMonth;
    }

    public void setTurnoverForPrevMonth(double turnoverForPrevMonth) {
        this.turnoverForPrevMonth = turnoverForPrevMonth;
    }

}
