package project.cucumber.models;
import org.joda.time.DateTime;

import java.util.*;

public class Event {

    public Event(String name, String location, Double price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public Event() {
    }

    private String name;

    private DateTime date;

    private String location;

    private Double price;

    private List<Speaker> speakers;

    public Category category;

    public Set<User> user;

    public Set<Speaker> speaker;


    public String getName() {
        return this.name;
    }

    public void setName(String value) {
       this.name = value;
    }

    public DateTime getDate() {
        return this.date;
    }

    public void setDate(DateTime value) {
       this.date = value;
    }

    public String getLocation() {
       return this.location;
    }

    public void setLocation(String value) {
       this.location = value;
    }

    public Double getPrice() {
       return this.price;
    }

    public void setPrice(Double value) {
       this.price = value;
    }

    public List<Speaker> getSpeakers() {
        return this.speakers;
    }

    public void setSpeakers(List<Speaker> value) {
       this.speakers = value;
    }
}