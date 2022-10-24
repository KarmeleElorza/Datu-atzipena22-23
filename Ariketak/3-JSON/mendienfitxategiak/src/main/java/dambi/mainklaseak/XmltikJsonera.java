package dambi.mainklaseak;
import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;
public class XmltikJsonera {
    public static void main(String[] args){
        Mendiak mendiak = new Mendiak();

        Xmla xmla = new Xmla("data/Mendiak.xml");
        mendiak = xmla.irakurri();
        
        Jsona jsona = new Jsona("", "data/XmltikJsonera.json");
        System.out.println(jsona.idatzi(mendiak) + " Mendi idatzi dira");
    }  
}
