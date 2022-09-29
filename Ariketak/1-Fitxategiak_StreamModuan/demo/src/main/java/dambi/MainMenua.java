package dambi;

import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            menua();
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    
                    break;
                case 2:
                    
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
}
