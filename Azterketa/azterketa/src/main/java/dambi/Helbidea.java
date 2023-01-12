package dambi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Helbidea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String helbidea;
    private String ordutegia;
    private float prezioa;
    @ManyToOne()
    @JoinColumn(name = "jatetxea")
    private Jatetxea jatetxea;

    public Helbidea(){

    }

    public Helbidea(int id, String helbidea, String ordutegia, Float prezioa, Jatetxea jatetxea){
        this.id = id;
        this.helbidea = helbidea;
        this.ordutegia = ordutegia;
        this.prezioa = prezioa;
        this.jatetxea = jatetxea;
    }

    public int getId() {
        return id;
    }

    public String getHelbidea() {
        return helbidea;
    }

    public String getOrdutegia() {
        return ordutegia;
    }

    public float getPrezioa() {
        return prezioa;
    }

    public void setId(Integer id2) {
        this.id = id2;
    }

    public void setHelbidea(String helbidea) {
        this.helbidea = helbidea;
    }

    public void setOrdutegia(String ordutegia) {
        this.ordutegia = ordutegia;
    }

    public void setPrezioa(Float prezioa2) {
        this.prezioa = prezioa2;
    }
}