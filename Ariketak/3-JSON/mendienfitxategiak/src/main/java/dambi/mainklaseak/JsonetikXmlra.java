package dambi.mainklaseak;
import java.io.File;
import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;
public class JsonetikXmlra { //errorea
    public static void main(String args[]) throws Exception {
        Mendiak mendiak = new Mendiak();

        Jsona json = new Jsona("data/Mendiak.json");
        mendiak = json.irakurri();
        
        Xmla xmla = new Xmla("", "data/JsonetikXmlra.xml");
        System.out.println(xmla.idatzi(mendiak) + " Mendi idatzi dira");
    }
}
