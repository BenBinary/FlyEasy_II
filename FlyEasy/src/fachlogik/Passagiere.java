package fachlogik;

// import noch ergänzen

public class Passagiere {

    String name;
    List<Adresse> adresse = new ArrayList<>();

    Public Passagiere(){}

    public Passagiere (String name, String strasse, String stadt) {
        this.name = name;
        this.adresse.add(new Adresse(strasse, stadt));
    }
}
