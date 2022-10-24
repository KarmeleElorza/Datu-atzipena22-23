package dambi.mainklaseak;

import java.util.ArrayList;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvtikJsonera {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        Mendiak gipuzkoakoak = new Mendiak();
        Csva csva = new Csva("mendienfitxategiak/data/Mendiak.csv");
        Jsona jsona = new Jsona("","mendienfitxategiak/data/Gipuzkoakoak.json");
        mendiak = csva.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getProbintzia().equals("Gipuzkoa")) {
                    gipuzkoakoak.add(m);
                }
            }
            System.out.println(jsona.idatzi(gipuzkoakoak)+" mendi idatzi dira json fitxategian.");
            //System.out.println(jsona.idatzi_Formatua(gipuzkoakoak)+" mendi idatzi dira json fitxategian.");
        }

    }
}
