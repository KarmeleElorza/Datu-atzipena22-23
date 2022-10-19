package dambi.mainklaseak;

import java.io.File;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Mendiak;

public class CsvkoDanakXmletaJsonera {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Csva csva = new Csva("mendienfitxategiak/data/Mendiak.csv");
        //System.out.println(new File("").getAbsolutePath());
        
        Xmla xmla = new Xmla("", "mendienfitxategiak/data/Mendiak.xml");
        Jsona jsona = new Jsona("", "mendienfitxategiak/data/Mendiak.json");
        mendiak = csva.irakurri();
        xmla.idatzi(mendiak);
        jsona.idatzi(mendiak);   
    }
}
