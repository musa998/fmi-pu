package com.asigment.discounts;

public class GoldCard extends Card {

    public GoldCard(Owner owner, double turnoverForPrevMonth) {
        super(owner, turnoverForPrevMonth);
    }

    @Override
    public double getRealDiscountRate() {
        double discountRate = 2;
        double turnOverCount = super.getTurnoverForPrevMonth();
        while (turnOverCount >= 100) {
            if (discountRate >= 10) break;
            discountRate++;
            turnOverCount -= 100;
        }
        return discountRate;
    }
}
