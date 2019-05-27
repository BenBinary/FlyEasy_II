package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import fachlogik.Destinations;
import fachlogik.Flug;

public class Test_SER {
	
	
	static List<Flug> fluege = new LinkedList<>();
	File file = new File("test.ser");

	public static void main(String[] args) {
		
		Flug f1 = new Flug("01012019", Destinations.BER, Destinations.BHX, true);
		Flug f2 = new Flug("01012020", Destinations.STR, Destinations.BHX, true);
		
		fluege.add(f1);
		fluege.add(f2);
		
		System.out.println(ser());

		System.out.println(deser());
	}
	
	
	public static Boolean ser() {
		
		File file = new File("test.ser");
		
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
		
		File file = new File("test.ser");
		
		try (FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			return (LinkedList<Flug>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
