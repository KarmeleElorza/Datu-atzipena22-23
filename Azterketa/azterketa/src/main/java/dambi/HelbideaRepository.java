package dambi;

import org.springframework.data.repository.CrudRepository;

import dambi.Helbidea;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface HelbideaRepository extends CrudRepository<Helbidea, Integer> {

}