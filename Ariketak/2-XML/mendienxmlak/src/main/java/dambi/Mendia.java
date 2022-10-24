package dambi;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.XmlAttribute;
import java.util.List;

public class Mendia {

    String    izena;
    int       altuera;
    String    probintzia;

    @XmlElement( name = "izena" )
    public String getizena()
    {
        return izena;
    }
    public void setizena( List mendiak )
    {
        this.izena = izena;
    }
}
