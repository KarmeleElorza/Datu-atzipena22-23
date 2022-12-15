package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UmeaRepository {
    List<Umea> findAll();
    Umea findById(String id);
    int findOpariKopuruaUmeko(String izena);
    Umea save(Umea person);
    long delete(String izena);
}
