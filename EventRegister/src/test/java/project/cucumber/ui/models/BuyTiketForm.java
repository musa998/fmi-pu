package project.cucumber.ui.models;

import project.cucumber.models.Event;
import project.cucumber.services.BuyTiketsService;

public class BuyTiketForm {

    private boolean isPaymentMethodChoosen;
    private String username;
    private String email;
    private String message;
    private Event event;


    public void choosePaymentMethod(boolean value) {
        this.isPaymentMethodChoosen = value;
    }
    public void addUserName(String value) {
        this.username = value;
    }
    public void addEmail(String value) {
        this.email = value;
    }
    public void addEvent(Event value) {this.event = value;}

    public void checkout(Event event) {
       // boolean isUsernameNotValid = username == null || username.isEmpty();
        boolean notValidEmail = email == null || email.isEmpty();

        if (notValidEmail || isPaymentMethodChoosen == false){
            message = "Попълнете всички полета!!!!";
        }else {
            message = new BuyTiketsService().buyTiket(event, isPaymentMethodChoosen, email);
        }
    }
    public String getMessage() {
        return message;
    }

}
