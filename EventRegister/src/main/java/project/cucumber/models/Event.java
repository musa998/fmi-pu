package project.cucumber.models;

import org.joda.time.DateTime;

import java.util.*;

/**
 * 
 */
public class Event {

    /**
     * Default constructor
     */
    public Event() {
    }

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public DateTime date;

    /**
     * 
     */
    public String location;

    /**
     * 
     */
    public Category category;

    /**
     * 
     */
    public Set<User> user;

}