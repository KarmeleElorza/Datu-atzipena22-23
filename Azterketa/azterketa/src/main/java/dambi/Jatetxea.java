package dambi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Jatetxea {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String izena;
  private String mota;
  @OneToMany(mappedBy = "jatetxea", cascade = CascadeType.ALL, orphanRemoval =  true)
  private List<Helbidea> helbidea = new ArrayList<>();
  public void setIzena(String izena) {
    this.izena = izena;
  }
  public void setMota(String mota) {
    this.mota = mota;
  }
  public String getIzena() {
    return izena;
  }
  public String getMota() {
    return mota;
  }

  public List<Helbidea> getHelbidea() {
    return helbidea;
  }

  public void setHelbidea(ArrayList<Helbidea> helbidea) {
    this.helbidea = helbidea;
  }
}
