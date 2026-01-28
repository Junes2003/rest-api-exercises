package org.example01restapi.exercise2;

public class Publisher {

    private String name;
    private String country;
    private int founded;

    public Publisher(String name, String country, int founded) {
        this.name = name;
        this.country = country;
        this.founded = founded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }
}
