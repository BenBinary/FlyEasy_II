package fachlogik;

import java.util.ArrayList;
import java.util.List;

public class Passagiere {

    String name;
    List<Adresse> adresse = new ArrayList<>();

    public Passagiere(){
    }

    public Passagiere (String name, String strasse, String stadt) {
        this.name = name;
        this.adresse.add(new Adresse(strasse, stadt));
    }
}
