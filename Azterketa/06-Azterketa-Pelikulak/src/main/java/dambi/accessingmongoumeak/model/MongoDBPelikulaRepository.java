package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;


import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBPelikulaRepository implements PelikulaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private PelikulaRepository pelikulaRepository;
    private MongoClient client;
    private MongoCollection<Pelikula> pelikulaCollection;

    @PostConstruct
    void init() {
        pelikulaCollection = client.getDatabase("filmoteka").getCollection("pelikulak", Pelikula.class);
    }

    @Override
    public List<Pelikula> findAll() {
        return pelikulaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Pelikula findById(String id) {
        return pelikulaCollection.find(eq("_id", new ObjectId(id))).first();        
    }

    @Override
    public Pelikula findByActor(String actor) {
        return pelikulaCollection.find(eq("cast", new String(actor))).first();        
    }

    @Override
    public Pelikula findByYear(int year) {
        return pelikulaCollection.find(eq("year", new Integer(year))).first();        
    }

    @Override
    public Pelikula findByDirector(String director) {
        return pelikulaCollection.find(eq("director", new String(director))).first();
    }

    @PostMapping(path = "/peliberria") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String titulua, @RequestParam Integer urtea, @RequestParam Director direktorea, @RequestParam List<String> aktoreak) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Pelikula u = new Pelikula();
		u.setTitle(titulua);
        u.setYear(urtea);
        u.setDirector(direktorea);
        u.setCast(aktoreak);

		pelikulaRepository.save(u);
		return "Saved";
	}

    @Override
    public Pelikula save(Pelikula person) {
        person.setId(new ObjectId());
        pelikulaCollection.insertOne(person);
        return person;
    }
}
