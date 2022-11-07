package ksiazka;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;


public class Osoba {
    //plik
    String nazwaPliku;
    Scanner sc = new Scanner(System.in);
    int id;
    void menuplik()
    {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Stworz plik");
            System.out.println("2.Otworz plik");
            String wybor = sc.nextLine();
            switch (wybor) {
                case "1": {
                    nazwaPliku = sc.nextLine();
                    String sciezkplik = nazwaPliku + ".txt";
                    File plik = new File(sciezkplik);
                    if (!plik.exists()) {
                        try {
                            plik.createNewFile();
                            System.out.println("Gratulacje utworzyles plik");
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Plik istnieje");
                    }
                    break;
                }

                case "2": {
                    System.out.println("Podaj nazwe:");
                    nazwaPliku = sc.nextLine();
                    String sciezkplik = nazwaPliku + ".txt";
                    File plik = new File(sciezkplik);
                    if (plik.exists()) {
                        System.out.println("jest");
                        mainMenu();
                    } else {
                        System.out.println("nie ma takiego pliku");
                    }
                    break;
                }

                default: {
                    System.out.println("Nie ma takiej opcji");
                    break;
                }

            }
        }while(true);
    }
    void mainMenu()
    {
        do {
            System.out.println("1.Dodaj osobe");
            System.out.println("2.Usun osobe");
            System.out.println("3.Edytuj osobe");
            System.out.println("4.Wyswietl wszystkie osoby");
            System.out.println("5.Wyszukaj osobe");
            System.out.println("6.Zamknij program");
            String wyborp = sc.nextLine();
            switch (wyborp) {
                case "1": {
                    dodawanie();
                    break;
                }
                case "2": {

                    break;
                }
                case "3": {
                    edytowanie();
                    break;
                }
                case "4": {
                    wyswietlanie();
                    break;
                }
                case "5": {
                    break;
                }
                case "6": {
                    System.exit(0);
                }
            }
        }while(true);


    }
    void dodawanie()
    {
        try {
            File plik1 = new File(nazwaPliku+".txt");
            Scanner sc1 = new Scanner(plik1);
            FileWriter fw = new FileWriter(nazwaPliku + ".txt", true);
            Formatter fm = new Formatter(fw);
            //pobranie ilosci linijek
            long count = 0;

            Path path1 = Paths.get(nazwaPliku + ".txt");
            try {
                count = Files.lines(path1).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(count);
            if(count>0) {
                for (int i = 1; i < count - 6; i++) {
                    sc1.nextLine();

                }
                String s = (sc1.nextLine());
                System.out.println(s);
                int foo = Integer.parseInt(s);
                id = foo + 1;
            }
            else
            {
                id=1;
            }

                fm.format("%s\r\n",id);
                System.out.println("Imie:");
                String imie = sc.nextLine();
                fm.format("%s\r\n",imie);
                System.out.println("Nazwisko:");
                String nazwisko = sc.nextLine();
                fm.format("%s\r\n",nazwisko);
                System.out.println("Miejscowosc:");
                String miejscowosc = sc.nextLine();
                fm.format("%s\r\n",miejscowosc);
                System.out.println("Tel_1:");
                String tel_1 = sc.nextLine();
                fm.format("%s\r\n",tel_1);
                System.out.println("Tel_2:");
                String tel_2 = sc.nextLine();
                fm.format("%s\r\n",tel_2);
                System.out.println("Tel_3:");
                String tel_3 = sc.nextLine();
                fm.format("%s\r\n",tel_3);
                fm.close();
                fw.close();



            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        void wyswietlanie()
        {
            try {
                long count = 0;
                Path path1 = Paths.get(nazwaPliku + ".txt");
                try {
                    count = Files.lines(path1).count();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                BufferedReader reader= new BufferedReader(new FileReader(nazwaPliku+".txt"));

                List<String> lista = new ArrayList<String>();
                for(int j=1;j<=count/7;j++) {
                    for (int i = 0; i < 7; i++) {
                        String line = reader.readLine();
                        lista.add(line);
                        System.out.println(lista.get(i));
                    }
                    lista.clear();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        void edytowanie()
        {

            try {
                Scanner scf = new Scanner(System.in);

                //pobranie ilosci linijek
                long count = 0;
                Path path1 = Paths.get(nazwaPliku + ".txt");
                try {
                    count = Files.lines(path1).count();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int countint=(int)count;
                int liczbaid=countint/7;
                System.out.println(liczbaid);

                //reszta
                System.out.println("Podaj id do edycji: ");
                int podaneid= scf.nextInt();
                if(podaneid==1)
                {
                    id=1;
                    File f = new File(nazwaPliku+"b.txt");
                    f.createNewFile();

                    FileWriter fw = new FileWriter(nazwaPliku + "b.txt", true);
                    Formatter fm = new Formatter(fw);
                    fm.format("%s\r\n",id);
                    System.out.println("Nowe imie:");
                    String imie = sc.nextLine();
                    fm.format("%s\r\n",imie);
                    System.out.println("Nowe nazwisko:");
                    String nazwisko = sc.nextLine();
                    fm.format("%s\r\n",nazwisko);
                    System.out.println("Nowa miejscowosc:");
                    String miejscowosc = sc.nextLine();
                    fm.format("%s\r\n",miejscowosc);
                    System.out.println("Nowy tel_1:");
                    String tel_1 = sc.nextLine();
                    fm.format("%s\r\n",tel_1);
                    System.out.println("Nowy tel_2:");
                    String tel_2 = sc.nextLine();
                    fm.format("%s\r\n",tel_2);
                    System.out.println("Nowy tel_3:");
                    String tel_3 = sc.nextLine();
                    fm.format("%s\r\n",tel_3);

                    BufferedReader reader= new BufferedReader(new FileReader(nazwaPliku+".txt"));
                    for (int i = 0; i < 7; i++) {
                        reader.readLine();
                    }
                    List<String> lista = new ArrayList<String>();
                    for(int j=1;j<=(count/7)-1;j++) {
                        for (int i = 0; i < 7; i++) {
                            String line = reader.readLine();
                            lista.add(line);
                            fm.format("%s\r\n",lista.get(i));
                        }
                        lista.clear();

                    }
                    reader.close();
                    fm.close();
                    fw.close();
                    Files.copy(Paths.get(nazwaPliku+"b.txt"), Paths.get(nazwaPliku+".txt"), StandardCopyOption.REPLACE_EXISTING);
                    f.delete();


                }
                else
                {
                    File f = new File(nazwaPliku+"b.txt");
                    f.createNewFile();

                    FileWriter fw = new FileWriter(nazwaPliku + "b.txt", true);
                    Formatter fm = new Formatter(fw);
                    List<String> lista = new ArrayList<>();

                    BufferedReader reader= new BufferedReader(new FileReader(nazwaPliku+".txt"));
                    for(int j=0;j<podaneid-1;j++) {
                        for (int i = 0; i < 7; i++) {
                            String line = reader.readLine();
                            lista.add(line);
                            fm.format("%s\r\n", lista.get(i));
                        }
                        lista.clear();
                    }
                    fm.format("%s\r\n",reader.readLine());
                    System.out.println("Nowe imie:");
                    String imie = sc.nextLine();
                    fm.format("%s\r\n",imie);
                    System.out.println("Nowe nazwisko:");
                    String nazwisko = sc.nextLine();
                    fm.format("%s\r\n",nazwisko);
                    System.out.println("Nowa miejscowosc:");
                    String miejscowosc = sc.nextLine();
                    fm.format("%s\r\n",miejscowosc);
                    System.out.println("Nowy tel_1:");
                    String tel_1 = sc.nextLine();
                    fm.format("%s\r\n",tel_1);
                    System.out.println("Nowy tel_2:");
                    String tel_2 = sc.nextLine();
                    fm.format("%s\r\n",tel_2);
                    System.out.println("Nowy tel_3:");
                    String tel_3 = sc.nextLine();
                    fm.format("%s\r\n",tel_3);
                    for (int i = 1; i < 7; i++) {
                        reader.readLine();
                    }
                    for(int j=1;j<=(count/7)-podaneid;j++) {
                        for (int i = 0; i < 7; i++) {
                            String line = reader.readLine();
                            lista.add(line);
                            fm.format("%s\r\n", lista.get(i));
                        }
                        lista.clear();
                    }

                    reader.close();
                    fm.close();
                    fw.close();
                    Files.copy(Paths.get(nazwaPliku+"b.txt"), Paths.get(nazwaPliku+".txt"), StandardCopyOption.REPLACE_EXISTING);
                    f.delete();
                }


            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }




    }

