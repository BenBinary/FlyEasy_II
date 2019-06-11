package daten;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.LinkedList;

import fachlogik.Flug;
import fachlogik.FlugVerwaltung;

public class Serialisierung {
	
	
	public static Boolean ser(List<Flug> fluege) {
		
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

	            toBeReturned = (LinkedList<Flug>) ois.readObject();
			}
			catch (FileNotFoundException e) {
				FlugVerwaltung.save();
				FlugVerwaltung.load();
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	        return toBeReturned;
		
		
	}

}
