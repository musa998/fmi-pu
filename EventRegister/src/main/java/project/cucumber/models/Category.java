package project.cucumber.models;

import java.util.*;

/**
 * 
 */
public class Category {

    /**
     * Default constructor
     */
    public Category() {
    }

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public Set<Event> event;

    /**
     * 
     */
    public Set<Category> children;

    /**
     * 
     */
    public Category parent;

}