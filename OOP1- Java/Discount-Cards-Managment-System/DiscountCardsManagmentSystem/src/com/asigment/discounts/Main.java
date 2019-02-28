package com.asigment.discounts;

public class Main {

    public static void main(String[] args) {

        // Creating card owners
        Owner pesho = new Owner("Pesho", "Peshov", "99999999", "Plovdiv");
        Owner stamat = new Owner("Stamat", "Stamat", "8888888", "Sofiq");
        Owner gosho = new Owner("Gosho", "Goshov", "7777777", "Varna");

        // Creating bronz cards
        BronzeCard bronzeCard1 = new BronzeCard(gosho, 0);
        Card bronzeCard2 = new BronzeCard(stamat, 200);
        BronzeCard bronzeCard3 = new BronzeCard(pesho, 1000);
        Card bronzeCard4 = new BronzeCard(pesho, 130);

        // Creating silver cards
        Card silverCard1 = new SilverCard(pesho, 600);
        SilverCard silverCard2 = new SilverCard(stamat, 299);

        // Creating a gold cards
        GoldCard goldCard1 = new GoldCard(pesho, 1500);
        Card goldCard2 = new GoldCard(gosho, 0);

        // base case 1
        //System.out.println(PayDesk.manageOrder(bronzeCard1, 150));

        // base case 2
        //System.out.println(PayDesk.manageOrder(silverCard1, 850));

        // base case 3
        //System.out.println(PayDesk.manageOrder(goldCard1, 1300));

        // other cases
        //System.out.println(PayDesk.manageOrder(bronzeCard3, 10));
        //System.out.println(PayDesk.manageOrder(bronzeCard4, 560));

        //System.out.println(PayDesk.manageOrder(silverCard2, 31));

        //System.out.println(PayDesk.manageOrder(goldCard2, 100));

    }
}
