package com.asigment.discounts;

public class PayDesk {

    public static String manageOrder(Card clientCard, double purchaseValue) {
        String res = "Purchase value: $" + purchaseValue +
                "\nDiscount Rate: " + clientCard.getRealDiscountRate() + "%"
                + "\nDiscount: $" + clientCard.calculateDiscount(purchaseValue)
                + "\nTotal: $" + getTotalPrice(clientCard, purchaseValue);

        return res;
    }

    public static double getTotalPrice(Card card, double purchaseValue) {
        return purchaseValue - card.calculateDiscount(purchaseValue);
    }

}
