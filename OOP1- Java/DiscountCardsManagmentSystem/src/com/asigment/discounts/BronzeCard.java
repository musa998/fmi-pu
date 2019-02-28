package com.asigment.discounts;

public class BronzeCard extends Card {

    public BronzeCard(Owner owner, double turnoverForPrevMonth) {
        super(owner, turnoverForPrevMonth);
    }

    @Override
    public double getRealDiscountRate() {
        if (super.getTurnoverForPrevMonth() < 100) {
            return  0;
        } else if (super.getTurnoverForPrevMonth() >= 100 && super.getTurnoverForPrevMonth() <= 300) {
           return  1;
        } else {
            return  2.5;
        }
    }

}
