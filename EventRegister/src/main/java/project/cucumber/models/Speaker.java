package project.cucumber.models;

import java.util.*;

/**
 * 
 */
public class Speaker {

    /**
     * Default constructor
     */
    public Speaker() {
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String genre;



    /**
     * 
     */
    public Set<Event> event;

    /**
     * @return
     */
    public String getName() {
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
    public Integer getAge() {
        return this.age;
    }

    /**
     * @param value
     */
    public void setAge(Integer value) {
        this.age = value;
    }

    /**
     * @return
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * @param value
     */
    public void setGenre(String value) {
       this.genre = value;
    }

}