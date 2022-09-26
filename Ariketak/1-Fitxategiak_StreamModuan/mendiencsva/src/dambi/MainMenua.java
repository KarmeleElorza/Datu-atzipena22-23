package dambi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        ArrayList <String> mendiak = irakurriMendiak();
        do {
            menua();
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                bistaratu(mendiak);
                    break;
                case 2:
                bistaratuBat(mendiak,1);
                    break;
                case 3:
                    
                    break;
                case 5:
                    System.out.println("Agur eta Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.close();
    }
    public static void menua(){
        System.out.println("MENDIEN MENUA");
        System.out.println("==================");
        System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
        System.out.println("2. Mendirik altuena bistaratu");
        System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
        System.out.println("4. ...");
        System.out.println("5. Irten");
    }
    public static ArrayList <String> irakurriMendiak() throws IOException{
        FileReader inputStream = null;
        int c;
        String hitza = "";
        ArrayList <String> taula = new ArrayList<String>();
        try {
            inputStream = new FileReader("Mendiak.csv");
            while ((c = inputStream.read()) != -1) {
                if((char)c != ';' && (char)c != '\n'){
                    hitza = hitza + (char)c;
                }
                else{
                    taula.add(hitza);
                    hitza = "";
                }
                
            }
            taula.add(hitza);
        }catch(Exception ex){
            if (inputStream != null) {
                inputStream.close();
            }
        }
        ArrayList <String> mendiak = dimentsionatu(taula);
        return mendiak;
    }
    public static void bistaratu(ArrayList <String> mendiak){
        int i = 0;
        for(i = 0; i < mendiak.size(); i = i + 3){
            System.out.println(mendiak.get(i) + "\t" + mendiak.get(i + 1) + "\t" + mendiak.get(i + 2) + "\n");
        }
    }
    public static ArrayList <String> dimentsionatu(ArrayList <String> mendiak){
        int i = 0;
        ArrayList <String> mendiDimen = new ArrayList <String> ();

        for(i = 0; i < mendiak.size(); i = i + 3){
            mendiDimen.add(mendiak.get(i));
            mendiDimen.add(mendiak.get(i + 1));
            mendiDimen.add(mendiak.get(i + 2));
        }
        return mendiDimen;
    }
    public static void bistaratuBat(ArrayList <String> mendiak, int pos){
            System.out.println(mendiak.get(pos));
    }
    public static void MendirikAltueraAurkitu(ArrayList <String> mendiak){
        int i = 0;
        for(i = 0; i < mendiak.size(); i = i + 3){
            System.out.println(mendiak.get(i) + "\t" + mendiak.get(i + 1) + "\t" + mendiak.get(i + 2) + "\n");
        }
    }
}

