package ksiazka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Osoba menu = new Osoba();
        Scanner sc=new Scanner(System.in);
        //Menu
        do {
            System.out.println("Witam w ksiazce telefonicznej");
            System.out.println("1.Zaczynajmy");
            System.out.println("2.Wylacz");
            String wybor = sc.nextLine();
            switch (wybor)
            {
                case "1":
                {
                    menu.menuplik();
                }
                case "2":
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Nie ma takiej opcji");
                }
            }
        }while(true);
    }
}
