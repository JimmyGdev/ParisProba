package com.afpa.entity;

import java.util.ArrayList;

public class PersonPresent {
    private String name;
    private PersonAbsent [] listOfPersonBet;
    private boolean hasVoted = false;

    private static ArrayList<String> namesOfAllPresent = new ArrayList<String>();;

    public PersonPresent() {
    }

    public PersonPresent(String name) {
        this.name = name;
    }


    public static void nameAdd(String name){
        namesOfAllPresent.add(name);
    }

    public static ArrayList<String> getNames() {
        return namesOfAllPresent;
    }

    //getter setter
    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonAbsent[] getListOfPersonBet() {
        return listOfPersonBet;
    }

    public void setListOfPersonBet(PersonAbsent[] listOfPersonBet) {
        this.listOfPersonBet = listOfPersonBet;
    }
}
