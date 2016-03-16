package com.senacor.springboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author David Schmitz
 */

@Entity
public class HelloWorld {
    @Id
    @GeneratedValue
    private String id;

    // boilerplate...


    private String greeting;

    public HelloWorld() {
    }

    public HelloWorld(String greeting) {
        this.greeting = greeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
