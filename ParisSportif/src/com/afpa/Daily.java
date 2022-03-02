package com.afpa;
import com.afpa.entity.CalculProba;
import com.afpa.entity.ListToTab;
import com.afpa.entity.PersonAbsent;
import com.afpa.entity.PersonPresent;

import java.util.ArrayList;
import java.util.Scanner;


public class Daily {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String  listeComplete = "O";
        int compteurAbsent = 1;


        ArrayList<PersonAbsent> listPersonsAbsent = new ArrayList<PersonAbsent>();
        ArrayList<PersonPresent> listPersonsPresente = new ArrayList<PersonPresent>();
        ArrayList<PersonAbsent> listPersonsParie= new ArrayList<PersonAbsent>();

        //implémentation des personnes absente:
        do {
            System.out.println("Liste des absents jusque la: \n" + PersonAbsent.getNames());
            System.out.println("Qui est absent? Si la liste est complète, taper X");
            String nameAbsent = sc.nextLine();
            if(!nameAbsent.equalsIgnoreCase("X")) {
                System.out.println(nameAbsent + " entre dans la liste des absents!");
                PersonAbsent personAbsent = new PersonAbsent(nameAbsent);
                listPersonsAbsent.add(personAbsent);
                PersonAbsent.nameAdd(nameAbsent);
            }
            else {
                listeComplete = "X";
            }
        }while (!listeComplete.equalsIgnoreCase("X")); //tant qu'il reste des personnes absente à implementer

        //conversion du tableau tableau d'absent dynamique en statique
        PersonAbsent[] personsAbsentTab = ListToTab.ListToTabCreate(listPersonsAbsent);

        //construction de la classe calcul avec le tableau ainsi crée
        CalculProba calculProba = new CalculProba(personsAbsentTab);

        listeComplete = "O";
        //implémentation des parieurs
        do {
            System.out.println("Liste des présents jusque la: \n" + PersonPresent.getNames());
            System.out.println("Qui est présent? Si la liste est complète, taper X");
            String namePresent = sc.nextLine();
            if (!namePresent.equalsIgnoreCase("X")) {
                System.out.println(namePresent + " entre dans la liste des présents");
                PersonPresent personPresent = new PersonPresent(namePresent);
                listPersonsPresente.add(personPresent);
                PersonPresent.nameAdd(namePresent);
                //le parieur va donner l'ordre d'arrivée des absents
                do {
                    System.out.println("Pour qui voulez vous parier " + namePresent + "?");
                    String nameAbsentParie = sc.nextLine();
                    System.out.println(namePresent + " choisi " + nameAbsentParie + " dans l'ordre " + compteurAbsent + " d'arrivée ");
                    compteurAbsent++;
                    //fait une liste de personnes absente dans un ordre en utilisant les personnes absentes objet créé précédemment
                    for (int j = 0; j < personsAbsentTab.length; j++) {
                        if (personsAbsentTab[j].getName().equalsIgnoreCase(nameAbsentParie)) {
                            listPersonsParie.add(personsAbsentTab[j]);    // ajout dans la liste des personne absente parié
                        }
                    }
                }
                while (compteurAbsent <= personsAbsentTab.length); //tant que le parieurs n'a pas fini de miser en fonction du nombre maximal d'absent
                PersonAbsent personAbsentParieTab[] = ListToTab.ListToTabCreate(listPersonsParie);
                listPersonsParie.clear();
                personPresent.setListOfPersonBet(personAbsentParieTab);  //implémentation de la liste des personnes precemment creer dans l'objet personne present
                CalculProba.givePointsTo(personPresent, personPresent.getListOfPersonBet());
                compteurAbsent = 1;
            }
            else {
                listeComplete = "X";
            }
        }
            while (!listeComplete.equalsIgnoreCase("X")) ; //tant qu'il reste des personnes presentes à implémenter
            System.out.println("Les paris sont fermés, voila les résultats: ");

            for (int i = 0; i < personsAbsentTab.length; i++) {
                System.out.println(personsAbsentTab[i].getName() + " a pour points " + personsAbsentTab[i].getPoints() + " avec une probabilité de " + personsAbsentTab[i].getProbabilité());
            }
        System.out.println("Plus le candidat a de points, plus il est considéré comme retardataire");
            System.out.println(CalculProba.getPointsBet() + " points ont été attribués dans la manche");
    }
}
