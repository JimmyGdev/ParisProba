package com.afpa;


import com.afpa.entity.*;

public class Main {

    public static void main(String[] args) {

        //parieurs
        PersonPresent thierry = new PersonPresent("Thierry");
        PersonPresent martin = new PersonPresent("Martin");
        PersonPresent jeanne = new PersonPresent("Jeanne");
        PersonPresent carole = new PersonPresent("Carole");
        PersonPresent pierre = new PersonPresent("Pierre");
        PersonPresent cindy = new PersonPresent("Cindy");


        //criminels
        PersonAbsent samantha =  new PersonAbsent("Samantha");
        PersonAbsent serge =  new PersonAbsent("Serge");
        PersonAbsent bertrand =  new PersonAbsent("Bertrand");


        //creation de la wanted list
        CalculProba calculProba = new CalculProba(new PersonAbsent[]{samantha, serge, bertrand});


        System.out.println("Les paris sont ouvert!");

        //liste des paris
        thierry.setListOfPersonBet(new PersonAbsent[]{samantha, serge, bertrand});
        martin.setListOfPersonBet(new PersonAbsent[]{serge, samantha, bertrand});
        carole.setListOfPersonBet(new PersonAbsent[]{samantha, serge, bertrand});
        cindy.setListOfPersonBet(new PersonAbsent[]{bertrand, serge, samantha});

        CalculProba.givePointsTo(thierry, thierry.getListOfPersonBet()[0],thierry.getListOfPersonBet()[1],thierry.getListOfPersonBet()[2]);
        CalculProba.givePointsTo(martin, martin.getListOfPersonBet()[0],martin.getListOfPersonBet()[1],martin.getListOfPersonBet()[2] );
        CalculProba.givePointsTo(carole, carole.getListOfPersonBet()[0],carole.getListOfPersonBet()[1],carole.getListOfPersonBet()[2] );
        CalculProba.givePointsTo(cindy, cindy.getListOfPersonBet()[0],cindy.getListOfPersonBet()[1],cindy.getListOfPersonBet()[2] );

        System.out.println("Les paris sont fermés, voilà les résultats:");


        System.out.println(samantha.getName() + " a pour points " + samantha.getPoints() + " avec une probabilité de " + samantha.getProbabilité());
        System.out.println(serge.getName() + " a pour points " + serge.getPoints() + " avec une probabilité de " + serge.getProbabilité());
        System.out.println(bertrand.getName() + " a pour points " + bertrand.getPoints() + " avec une probabilité de " + bertrand.getProbabilité());
        System.out.println(CalculProba.getPointsBet());


    }
}
