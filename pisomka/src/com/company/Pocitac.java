package com.company;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;



class Pocitac {
 private String name;
 private String password;
 private String time;
 private String input;
 private ArrayList<String> files;
 private boolean jePrihlaseny = false;


 public void run() {
     boolean faktJePrihlaseny = false;
     while (faktJePrihlaseny == false) {
         faktJePrihlaseny = login();
     }

     String prikaz = "";
     Scanner nevem = new Scanner(System.in);
    while (!(prikaz.equals("exit"))) {
        System.out.println("Zadaj prikaz: ");
        prikaz = nevem.nextLine();


         switch (prikaz) {
             case "help":
                 help();
                 break;
             case "dir":
                 dir();
                 break;
             case "countInputLetters":
                 countInputLetters();
                 break;
             case "makeFile":
                 makeFile();
                 break;
             case "delete":
                 delete();
                 break;
             case "logout":
                 logout();
                 break;

         }
     }


 }

    private void dir() {
        for(String name:files) {
            System.out.println(name);
        }
    }

    private void logout() {
     jePrihlaseny = false;
     System.out.println("Uzivatel je odhlaseny");
    }

    private void delete() {
     System.out.println("Zadaj nazov suboru ktory chces vymazat: ");
     Scanner jano = new Scanner(System.in);
     String vymazat = jano.nextLine();
        files.remove(vymazat);

    }

    private void makeFile() {
        System.out.println("Zadaj nazov suboru ktory chces vytvorit: ");
        Scanner peter = new Scanner(System.in);
        String novySubor = peter.nextLine();
        boolean neplatny = false;

        for (int i = 0; i < novySubor.length(); ++i) {
            char ch = novySubor.charAt(i);

            if (ch == ' ' || ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4'
                    || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {

                System.out.println(ch);
                neplatny = true;
            }

        }
        if (neplatny == false) {
            files.add(novySubor);
            System.out.println("Vytvoril sa novy subor");
        }

        /* files.add(novySubor);
        for(String name:files) {
            System.out.println(name);
        }*/
    }



    public boolean login() {
        System.out.println("Zadaj meno: ");
        System.out.println("Zadaj heslo: ");
        Scanner sc = new Scanner(System.in);
        String prihlasenie = sc.nextLine();
        String heslo = sc.nextLine();

     if (name.equals(prihlasenie) && (password.equals(heslo)) ) {
         jePrihlaseny = true;
         System.out.println("Uzivatel je prihlaseny");
         hello();
         return true;
     }
     System.out.println("Uzivatel sa neprihlasil");
     return false;

 }



public String getName(){
    return name;
}

 public String getPassword(){
     return password;
 }

 public String getTime(){
     return time;
 }

 public String getInput(){
     return input;
 }

 public ArrayList<String> getFiles(){
     return files;
 }

 public void setName(String newName) {
     this.name = newName;
 }

 public void setPassword(String newPassword) {
     this.password = newPassword;
 }

 public void setTime(String newTime) {
     this.time = newTime;
 }

 public void setInput(String newInput) {
     this.input = newInput;
 }

 public void setFiles(ArrayList<String> newFiles) {
     this.files = newFiles;
 }

 public Pocitac(String name, String password, String input) {

     LocalTime time = LocalTime.now();

     this.name = name;
     this.password = password;
     this.time = time.toString();
     this.input = input;
     this.files = new ArrayList<String>(40);

     run();

 }

 public void hello(){
     System.out.println("Vitaj uzivatel: " + name);
     System.out.println(time);

 }
 public void help(){
     System.out.println("Vsetky prikazy su: countInputLetters, makeFile, dir, delete, logout");
 }

 public void countInputLetters(){
     System.out.println("Zadaj vystup nejaky: ");
     Scanner scan = new Scanner(System.in);
     String vystupNejakyMore = scan.nextLine();
     System.out.println("Vystup obsahuje: " + vystupNejakyMore.length() + " znakov.");

     int samohlasky = 0;
    int spoluhlasky = 0;
    int cisla = 0;
    int ostatne = 0;

     for (int i = 0; i < vystupNejakyMore.length(); ++i) {
         char ch = vystupNejakyMore.charAt(i);

         if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch == 'y'
                 || ch == 'á' || ch == 'é' || ch == 'í' || ch == 'ó' || ch == 'ú'|| ch == 'ý'|| ch == 'ô'|| ch == 'ä') {
             samohlasky++;
         }
         else if ((ch >= 'a' && ch <= 'z')) {
             spoluhlasky++;
         }
         else if (ch >= '0' && ch <= '9') {
             cisla++;
         }
         ostatne = vystupNejakyMore.length() - samohlasky - spoluhlasky - cisla;

     }
     System.out.println("Pocet samohlasek je: " + samohlasky);
     System.out.println("Pocet spoluhlasek je: " + spoluhlasky);
     System.out.println("Pocet cisel je: " + cisla);
     System.out.println("Pocet ostatnych znakov je: " + ostatne);
 }




}
