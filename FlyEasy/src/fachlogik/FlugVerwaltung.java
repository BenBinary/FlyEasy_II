package fachlogik;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import daten.Serialisierung;
import daten.testConnection;

public class FlugVerwaltung {

	static List<Flug> fluege = new LinkedList<>();
	//File file = new File("fluege.ser");

	public List<Flug> getFluege() {
		return fluege;
	}
	
	
	public static int getID(Flug flug) {
		
		fluege = FlugVerwaltung.load();
		int i = 0;
		
		for (Flug f: fluege) {
			
			//  && f.getStartDatumString() == flug.getStartDatumString()
			
			
			
			if (f.destination == flug.destination && f.origin == flug.origin && f.getStartDatumString().equals(flug.getStartDatumString())) {
				return i;
			}
			i++;
		}
		
		return -1;
			
			
		//if (fluege.equals(flug)) {
		
		//return fluege.indexOf(flug);
			
		
		// }
		//return -1;
		
	}

	public static void add(Flug flug) {
		
		

		fluege.add(flug);
		
		FlugVerwaltung.save();
	}

	public static void remove(int i) {
		fluege = FlugVerwaltung.load();

		fluege.remove(i);

		FlugVerwaltung.save();

	}
	
	// Methode um Flüge upzudaten
	public static void update(int i, Flug flug) {
		fluege = FlugVerwaltung.load();
		fluege.set(i, flug);
		FlugVerwaltung.save();
	}


	
	public static Boolean save() {
	
	
		
		return Serialisierung.ser(fluege);
		
		//return testConnection.saveFlights(fluege);
	}


	public static LinkedList<Flug> load() {

		
		return testConnection.loadFlights();
	}

}
