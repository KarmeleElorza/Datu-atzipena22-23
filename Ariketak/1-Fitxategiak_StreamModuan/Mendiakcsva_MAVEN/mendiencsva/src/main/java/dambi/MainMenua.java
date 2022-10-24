package dambi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        ArrayList<String> mendiak = irakurriMendiak();
        do {
            menua();
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    bistaratu(mendiak);
                    break;
                case 2:
                    int altuenaPos = MendirikAltueraAurkitu(mendiak);
                    if (altuenaPos != -1) {
                        bistaratuBat(mendiak, altuenaPos);
                    } else {
                        System.out.println("Errorea");
                    }
                    break;
                case 3:
                    sailkatuProbintziaz(mendiak);
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

    public static void menua() {
        System.out.println("MENDIEN MENUA");
        System.out.println("==================");
        System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
        System.out.println("2. Mendirik altuena bistaratu");
        System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
        System.out.println("4. ...");
        System.out.println("5. Irten");
    }

    public static ArrayList<String> irakurriMendiak() throws IOException {
        FileReader inputStream = null;
        int c;
        String hitza = "";
        ArrayList<String> taula = new ArrayList<String>();
        try {
            inputStream = new FileReader("Mendiak.csv");
            while ((c = inputStream.read()) != -1) {
                if ((char) c != ';' && (char) c != '\n') {
                    hitza = hitza + (char) c;
                } else {
                    taula.add(hitza);
                    hitza = "";
                }

            }
            taula.add(hitza);
        } catch (Exception ex) {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        ArrayList<String> mendiak = dimentsionatu(taula);
        return mendiak;
    }

    public static void bistaratu(ArrayList<String> mendiak) {
        int i = 0;
        for (i = 0; i < mendiak.size(); i = i + 3) {
            System.out.println(mendiak.get(i) + "\t" + mendiak.get(i + 1) + "\t" + mendiak.get(i + 2));
        }
    }

    public static ArrayList<String> dimentsionatu(ArrayList<String> mendiak) {
        int i = 0;
        ArrayList<String> mendiDimen = new ArrayList<String>();

        for (i = 0; i < mendiak.size(); i = i + 3) {
            mendiDimen.add(mendiak.get(i));
            mendiDimen.add(mendiak.get(i + 1));
            mendiDimen.add(mendiak.get(i + 2));
        }
        return mendiDimen;
    }

    public static void bistaratuBat(ArrayList<String> mendiak, int pos) {
        System.out.println(mendiak.get(pos - 1) + " mendia da altuena " + mendiak.get(pos) + " metrorekin");
    }

    public static int MendirikAltueraAurkitu(ArrayList<String> mendiak) {
        int i = 0, pos = 0;
        ArrayList<Integer> altuerak = new ArrayList<Integer>();
        for (i = 1; i < mendiak.size(); i = i + 3) {
            if (i != 1) {
                altuerak.add(Integer.parseInt(mendiak.get(i)));
            }
        }
        altuerak.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        String zenbAltuena = String.valueOf(altuerak.get(altuerak.size() - 1));
        pos = AurkituPos(zenbAltuena, mendiak);
        return pos;
    }

    public static int AurkituPos(String zenbAltuena, ArrayList<String> mendiak) {
        int pos = -1;
        for (int i = 0; i < mendiak.size(); i++) {
            if (zenbAltuena.equals(mendiak.get(i))) {
                pos = i;
            }
        }
        return pos;
    }

    public static void sailkatuProbintziaz(ArrayList<String> mendiak) {
        ArrayList<String> araba = new ArrayList<String>();
        ArrayList<String> bizkaia = new ArrayList<String>();
        ArrayList<String> gipuzkoa = new ArrayList<String>();
        for (int i = 0; i < mendiak.size() - 3; i++) {
            if (i == 0) {
                araba.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
                bizkaia.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
                gipuzkoa.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
            }
            if (i > 2) {
                if (mendiak.get(i + 2).toLowerCase().startsWith("araba")) {
                    araba.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
                } else if (mendiak.get(i + 2).toLowerCase().startsWith("bizkaia")) {
                    bizkaia.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
                } else if (mendiak.get(i + 2).toLowerCase().startsWith("gipuzkoa")) {
                    gipuzkoa.add(mendiak.get(i) + ";" + mendiak.get(i + 1) + ";" + mendiak.get(i + 2));
                }
            }
        }
        idatziCSV(araba, gipuzkoa, bizkaia);
    }

    public static void idatziCSV(ArrayList<String> Araba, ArrayList<String> Gipuzkoa, ArrayList<String> Bizkaia) {
        idatziBakoitza("Araba.csv", Araba);
        idatziBakoitza("Gipuzkoa.csv", Gipuzkoa);
        idatziBakoitza("Bizkaia.csv", Bizkaia);
    }

    public static void idatziBakoitza(String fileName, ArrayList<String> probintzia){
        File csvFile = new File(fileName);
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile));) {
            for (int i = 0; i < probintzia.size(); i++) {
                csvWriter.println(probintzia.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}