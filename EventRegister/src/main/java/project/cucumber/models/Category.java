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
    private String name;

    /**
     * 
     */
    private String description;

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

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return this.name;
    }

    /**
     * @param value
     */
    public void setName(String value) {
       this.name = value;
    }

    /**
     * @return
     */
    public String getDescription() {
        // TODO implement here
        return this.description;
    }

    /**
     * @param value
     */
    public void setDecription(String value) {
        this.description = value;
    }

}