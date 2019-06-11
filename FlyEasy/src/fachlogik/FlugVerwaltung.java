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

public class FlugVerwaltung {

	static List<Flug> fluege = new LinkedList<>();
	//File file = new File("fluege.ser");

	public List<Flug> getFluege() {
		return fluege;
	}
	
	
	public static int getID(Flug flug) {
		
		fluege = FlugVerwaltung.deser();
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
		
		FlugVerwaltung.ser();
	}

	public static void remove(int i) {
		fluege = FlugVerwaltung.deser();

		fluege.remove(i);

		FlugVerwaltung.ser();

	}
	
	// Methode um Flüge upzudaten
	public static void update(int i, Flug flug) {
		fluege = FlugVerwaltung.deser();
		fluege.set(i, flug);
		FlugVerwaltung.ser();
	}


	
	public static Boolean ser() {
	
		File file = new File("fluege.ser");
		try (FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(fluege);
			return true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}


	public static LinkedList<Flug> deser() {

        LinkedList<Flug> toBeReturned = new LinkedList<>();

		File file = new File("fluege.ser");

		try (FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis)) {

//			return (LinkedList<Flug>) ois.readObject();
            toBeReturned = (LinkedList<Flug>) ois.readObject();
		}
		catch (FileNotFoundException e) {
			FlugVerwaltung.ser();
			FlugVerwaltung.deser();
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		return null;
        return toBeReturned;
	}

}
