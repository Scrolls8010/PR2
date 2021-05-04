package EinwohnerManager;

public class Einwohner {

    private int id;
    private String name;
    private String Bundesland;
    private int Geburtsjahr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBundesland() {
        return Bundesland;
    }

    public void setBundesland(String bundesland) {
        Bundesland = bundesland;
    }

    public int getGeburtsjahr() {
        return Geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        Geburtsjahr = geburtsjahr;
    }

    public Einwohner(int id, String name, String bundesland, int geburtsjahr) {
        this.id = id;
        this.name = name;
        Bundesland = bundesland;
        Geburtsjahr = geburtsjahr;
    }

    @Override
    public String toString() {
        return "Einwohner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Bundesland='" + Bundesland + '\'' +
                ", Geburtsjahr=" + Geburtsjahr +
                '}';
    }


}
