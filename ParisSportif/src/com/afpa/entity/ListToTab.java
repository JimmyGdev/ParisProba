package com.afpa.entity;

import java.util.ArrayList;

public class ListToTab {

    public static PersonAbsent[] ListToTabCreate(ArrayList<PersonAbsent> list){
        PersonAbsent[] personsAbsentTab = new PersonAbsent[list.size()];
        for (int i = 0; i< list.size(); i++){
            personsAbsentTab[i] = list.get(i);
        }
        return personsAbsentTab;
    }

}
