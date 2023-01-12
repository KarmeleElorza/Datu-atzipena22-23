package dambi.accessingmongoumeak.model;

public class Director {
    private String name;
	private int born;
    public void setName(String name) {
        this.name = name;
    }
    public void setBorn(int born) {
        this.born = born;
    }
    public String getName() {
        return name;
    }
    public int getBorn() {
        return born;
    }
    @Override
    public String toString() {
        return "Director [name=" + name + ", born=" + born + "]";
    }
}
