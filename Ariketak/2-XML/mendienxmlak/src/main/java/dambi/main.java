package dambi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        ArrayList<String> mendiak = irakurriMendiak();
        if(mendiak != null){
            do {
                menua();
                aukera = in.nextInt();
                switch (aukera) {
                    case 1:
                    bistaratu(mendiak);
                        break;
                    case 2:
                        
                        break;
                    case 3:
    
                        break;
                    case 4:
    
                        break;
                    case 5:
                        System.out.println("Agur eta Eskerrik asko programa hau erabiltzeagatik.");
                        break;
                    default:
                        System.out.println("Aukera okerra. Saiatu berriz.");
                }
            } while (aukera != 5);
        }  
        in.close();
    }
    public static void menua() {
        System.out.println("MENDIEN MENUA");
        System.out.println("==================");
        System.out.println("1. Sortu mendia objektu bat eta dagokion xml fitxategia sortu ( mendibat.xml)");
        System.out.println("2. Sortu hiru mendiko zerrenda (List<Mendia>) eta dagokion xml fitxategia sortu (hirumendi.xml)");
        System.out.println("3. MKargatu memorian (unmarshal) aurreko programan sortu duzun xml fitxategia, eta gorde (mendiakaltueraoinatan.xml, gipuzkoakomendiak.xml)");
        System.out.println("4. Mendiak.csv fitxategia irakurri eta dagokion Mendiak.xml fitxategia idatzi.");
        System.out.println("5. Irten");
    }
    public static ArrayList<String> irakurriMendiak()
    {
        ArrayList<String> taula = new ArrayList<>(); //Create the ArrayList so it can be detected everywhere
        try (FileReader fr = new FileReader("Mendiak.csv")) { //Try finding the file and creating the FileReader
            //ArrayListera hitzak sartu
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            while (line != null) { //while there are new lines
                String[] gehitu; //new array of strings (mendi baten datu denak)
                gehitu = line.split(";");
                Collections.addAll(taula, gehitu);
                line = br.readLine();
            }
            //System.out.println("* /sys/ File successfully read!"); 
        } catch (IOException e) {
            System.out.println("* /sys/ An error has occurred.");
        }
        
        return taula;
    }
    public static void bistaratu(ArrayList<String> taula){
        for (int i = 0; i < taula.size(); i += 3) { //grabs groups of 3
            for (int j = 0; j <= 2; ++j) { //prints the group of 3
                System.out.printf("%15s", taula.get(i + j));
            }
            System.out.println(); //newline after the group is printed
        }
    }
}

