package dambi.accessingmongoumeak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Pelikula {
	
	private ObjectId id; 
	private String title;
	private int year;
	private Director director;
	private List<String> cast;

	
	
	public ObjectId getId() {
		return id; 
		
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public Director getDirector() {
		return director;
	}
	public List<String> getCast() {
		return cast;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Pelikula [id=" + id + ", title=" + title + ", year=" + year + ", director=" + director + ", cast=" + cast + "]";
	}
}
