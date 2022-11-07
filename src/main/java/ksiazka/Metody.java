package ksiazka;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Metody {
    String nazwaPliku;
    void menuplik()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Stworz plik");
        System.out.println("2.Otworz plik");
        String wybor = sc.nextLine();
        switch (wybor)
        {
            case "1":
            {
                    nazwaPliku = sc.nextLine();
                    String sciezkplik= nazwaPliku + ".txt";
                    String sciezkpliktel= nazwaPliku + "_tel.txt";
                    File plik = new File(sciezkplik);
                    if(!plik.exists()) {
                        try{
                            plik.createNewFile();
                            System.out.println("Gratulacje utworzyles plik");
                        }
                        catch (IOException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("Plik istnieje");
                    }
                    File plik_tel = new File(sciezkpliktel);
                    if(!plik_tel.exists()) {
                        try{
                            plik_tel.createNewFile();
                            System.out.println("Gratulacje utworzyles plik");
                        }
                        catch (IOException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        System.out.println("Plik istnieje");
                    }

                    break;
            }

            case "2":
            {
                    System.out.println("Podaj nazwe:");
                    nazwaPliku = sc.nextLine();
                    String sciezkplik= nazwaPliku + ".txt";
                    String sciezkpliktel= nazwaPliku + "_tel.txt";
                    File plik = new File(sciezkplik);
                    File pliktel = new File(sciezkpliktel);
                    if(plik.exists() && pliktel.exists())
                    {
                        System.out.println("jest");
                        mainMenu();
                    }
                    else
                    {
                        System.out.println("nie ma takiego pliku");
                    }
                    break;
            }

            default:
            {
                    System.out.println("Nie ma takiej opcji");
                    break;
            }

        }
    }
    void mainMenu()
    {
        System.out.println("1.Dodaj osobe");
        System.out.println("2.Usun osobe");
        System.out.println("3.Edytuj osobe");
        System.out.println("4.Wyswietl wszystkie osoby");
        System.out.println("5.Wyszukaj osobe");
        System.out.println("6.Zamknij program");

    }
    void dodawanie()
    {



    }




}
