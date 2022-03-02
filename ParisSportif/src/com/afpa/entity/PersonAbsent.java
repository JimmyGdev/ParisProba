package com.afpa.entity;

import java.util.ArrayList;

public class PersonAbsent {
    private String name;
    private int points = 0;
    private float probabilité;
    private static ArrayList<String> namesOfAllAbsent = new ArrayList<String>();;

    public PersonAbsent() {
    }

    public PersonAbsent(String name) {
        this.name = name;
    }

    public static void nameAdd(String name){
        namesOfAllAbsent.add(name);
    }

    public static ArrayList<String> getNames(){
        return namesOfAllAbsent;
    }















    //************************getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getProbabilité() {
        return probabilité;
    }

    public void setProbabilité(float probabilité) {
        this.probabilité = probabilité;
    }
}
