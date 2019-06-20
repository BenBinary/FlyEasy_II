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
import daten.dbConnection;
import gui.Start;
import daten.dbConnection;

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
			
		
			if (f.destination == flug.destination && f.origin == flug.origin && f.getStartDatumString().equals(flug.getStartDatumString())) {
				return i;
			}
			i++;
		}
		
		return -1;
			
		
	}

	public static void add(Flug flug) {
		
		
		// Hinzufgüen des Flugs zur Liste
		fluege.add(flug);
		
		
		// Aufrufen der statishcen Methode um das ganze zu sichern
		FlugVerwaltung.save();
	}

	public static void remove(int i) {
		fluege = FlugVerwaltung.load();

		fluege.remove(i);

		FlugVerwaltung.save();

	}
	
	public static void insert(Flug flug) {
		dbConnection.insertFlight(flug);
		//Start.updateList();
	}
	
	// Methode um FlÃ¼ge upzudaten
	public static void update(int i, Flug flug) {
		//fluege = FlugVerwaltung.load();
		//fluege.set(i, flug);
		//FlugVerwaltung.save();
		
		dbConnection.updateFlight(i, flug);
	}


	
	public static Boolean save() {
	
		//return Serialisierung.ser(fluege);
		return dbConnection.saveFlights(fluege);
		
	}


	public static LinkedList<Flug> load() {
		
		//return Serialisierung.deser();
		return dbConnection.loadFlights();
	}

}
