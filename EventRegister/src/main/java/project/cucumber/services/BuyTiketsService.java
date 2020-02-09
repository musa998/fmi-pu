package project.cucumber.services;

import project.cucumber.models.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyTiketsService {

    List<Event> events = new ArrayList<Event>();

    public BuyTiketsService(){
        Event event  = new Event();
        event.setName("PlovDev");
        event.setLocation("Plovdiv");
        event.setPrice(0d);
        events.add(event);
    }

    public String buyTiket(Event currentEvent, boolean isPaySelected, String email){

        boolean validEmail = validate(email);

        boolean result = events.stream()
                .anyMatch(event -> event.getName().equals(currentEvent.getName())
                                    && validEmail);

        return result ? "Успешно закупен!!!!" : "Невалидни данни!!!!";

    }
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


}
