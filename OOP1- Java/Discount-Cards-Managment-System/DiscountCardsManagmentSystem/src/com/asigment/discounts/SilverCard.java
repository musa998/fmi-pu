package com.asigment.discounts;

public class SilverCard extends Card {

    public SilverCard(Owner owner, double turnoverForPrevMonth) {
        super(owner, turnoverForPrevMonth);
    }

    @Override
    public double getRealDiscountRate() {
        /*TO AVOID "if-else" construction we can use ternary operator
        * Anyway i will leave it with "if" beause this code is more readable*/

        // return super.getTurnoverForPrevMonth() >= 300 ? 3.5 : 2
        if (super.getTurnoverForPrevMonth() >= 300){
            return 3.5;
        }
        else{
            return 2;
        }
    }
}
