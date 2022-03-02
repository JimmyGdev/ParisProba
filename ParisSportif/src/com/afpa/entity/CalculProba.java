package com.afpa.entity;

public class CalculProba {
    private static PersonAbsent [] tabOfAbsentPersons;
    private static int pointsBet = 0;

    public CalculProba() {
    }

    public CalculProba(PersonAbsent[] listOfAbsentPersons) {
        this.tabOfAbsentPersons = listOfAbsentPersons;
    }


    public static float calculProbaOf(PersonAbsent person){
        return (float)person.getPoints()/pointsBet;
    }


    public static void givePointsTo(PersonPresent personBetting, PersonAbsent person1, PersonAbsent person2, PersonAbsent person3){
        int pointPerson1 = person1.getPoints();
        int pointPerson2 = person2.getPoints();
        int pointPerson3 = person3.getPoints();

        personBetting.setListOfPersonBet(new PersonAbsent[]{person1, person2, person3});

        person1.setPoints(pointPerson1 + 3);
        person2.setPoints(pointPerson2 + 2);
        person3.setPoints(pointPerson3 + 1);

        personBetting.setHasVoted(true);
        pointsBet += 6;

        for (int i = 0; i < tabOfAbsentPersons.length; i++){
            tabOfAbsentPersons[i].setProbabilité(calculProbaOf(tabOfAbsentPersons[i]));
        }
    }
    //surcharge de la methode qui qui permet de prendre un tableau d'absent de taille inconnu
    public static void givePointsTo(PersonPresent personPresent, PersonAbsent[] personAbsentTab){
        for(int i = 0; i < personAbsentTab.length; i++){
            int personPoint = personAbsentTab[i].getPoints();
            //test
            personAbsentTab[i].setPoints(personPoint + i);
            pointsBet += i;

        }
        personPresent.setHasVoted(true);
        for (int i = 0; i < tabOfAbsentPersons.length; i++){
            tabOfAbsentPersons[i].setProbabilité(calculProbaOf(tabOfAbsentPersons[i]));
        }
    }



    public static int getPointsBet() {
        return pointsBet;
    }

    public static void setPointsBet(int pointsBet) {
        CalculProba.pointsBet = pointsBet;
    }

    public PersonAbsent[] getListOfAbsentPersons() {
        return tabOfAbsentPersons;
    }

    public void setListOfAbsentPersons(PersonAbsent[] listOfAbsentPersons) {
        this.tabOfAbsentPersons = listOfAbsentPersons;
    }
}
