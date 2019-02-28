package com.asigment.discounts;

public class SilverCard extends Card {

    public SilverCard(Owner owner, double turnoverForPrevMonth) {
        super(owner, turnoverForPrevMonth);
    }

    @Override
    public double getRealDiscountRate() {
        if (super.getTurnoverForPrevMonth() >= 300){
            return 3.5;
        }
        else{
            return 2;
        }
    }
}
