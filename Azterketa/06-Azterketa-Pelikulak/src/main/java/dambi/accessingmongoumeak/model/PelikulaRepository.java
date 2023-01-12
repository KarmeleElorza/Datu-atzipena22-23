package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PelikulaRepository {
    List<Pelikula> findAll();
    Pelikula findById(String id);
    Pelikula findByActor(String actor);
    Pelikula findByYear(int year);
    Pelikula findByDirector(String director);
    Pelikula save(Pelikula person);
}
