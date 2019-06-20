package fachlogik;


public final class IDGenerator {

    private static IDGenerator uniqueInstance = null;

    private int IDNumber = 0;


    public IDGenerator() {
    }

    public static IDGenerator instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new IDGenerator();
        }
        return uniqueInstance;
    }

    public int getIDNumber() {
        return ++IDNumber;
    }

}
