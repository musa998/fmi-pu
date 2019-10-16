package com.asigment.discounts;

/*Abstract  class that contains all main properties for one card*/
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
    /*Needs to be overriden because there are a different types of cards with different "Discount rate" */
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
