public class Passagiere {

    List<Adresse> adresse = new ArrayList<>();

    Public Passagiere(){}

    public Passagiere (String strasse, String Stadt) {
        this.adresse.add(new Adresse(strasse, Stadt));
    }
}
