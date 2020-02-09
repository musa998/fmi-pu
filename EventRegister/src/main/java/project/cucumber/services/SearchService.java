package project.cucumber.services;

import project.cucumber.models.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchService {

    List<Event> events = new ArrayList<Event>();

    public SearchService(){
        Event event  = new Event();
        event.setName("PlovDev");
        event.setLocation("Plovdiv");
        event.setPrice(0d);
        events.add(event);
    }

    public String search(String input) {

        boolean isToLong = input.length() > 30 ? false : true;
        boolean isLegalWord = legalKeyword(input);
        boolean eventExists = events.stream()
                .anyMatch(event -> event.getName().equals(input)
                        && isToLong
                        && isLegalWord);

         return eventExists ? "Намерено!!!!" : "Невалидни входни данни!!!!";
    }
    public boolean legalKeyword(String input){
        boolean res = false;
        Pattern p = Pattern.compile("[A-Za-z]{2,30}.*");
        Matcher m = p.matcher(input);
        if (m.find()){
            res = true;
        }
        return res;
    }

}
