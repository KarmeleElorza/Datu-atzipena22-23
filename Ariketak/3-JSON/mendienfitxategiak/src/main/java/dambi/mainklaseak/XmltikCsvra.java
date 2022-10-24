package dambi.mainklaseak;

import java.io.File;
import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class XmltikCsvra {
    public static void main(String args[]) throws Exception {
        Mendiak mendiak = new Mendiak();

        Xmla xmla = new Xmla("data/Mendiak.xml");
        mendiak = xmla.irakurri();
        
        Csva csva = new Csva("LOREMIPSUM", "data/XmltikCsvra.csv");
        System.out.println(csva.idatzi(mendiak) + " Mendi idatzi dira");
    }
}
    
    

