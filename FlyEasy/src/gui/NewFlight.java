package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenmodell.Destinations;
import datenmodell.Flug;
import datenmodell.FlugVerwaltung;

import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Calendar;

import java.util.Iterator;
import java.awt.event.ActionEvent;


import java.util.Date;

public class NewFlight extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFlight frame = new NewFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	
	/**
	 * Create the frame.
	 */
	public NewFlight() {
		
		
		// Globale Variablen
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(32, 41, 61, 16);
		contentPane.add(lblStart);

		JLabel lblZiel = new JLabel("Ziel");
		lblZiel.setBounds(32, 80, 61, 16);
		contentPane.add(lblZiel);

		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(32, 125, 61, 16);
		contentPane.add(lblDatum);

		Checkbox checkbox = new Checkbox("Internationaler Flug");
		checkbox.setState(true);
		checkbox.setBounds(34, 172, 210, 23);
		contentPane.add(checkbox);

		// CB ORIGIN
		JComboBox cbOrigin = new JComboBox();
		cbOrigin.setBounds(149, 37, 174, 27);
		contentPane.add(cbOrigin);
		for (Destinations d : Destinations.values()) {

			cbOrigin.addItem(d);

		}

		// CB DEST
		JComboBox cbDest = new JComboBox();
		cbDest.setBounds(149, 76, 174, 27);
		contentPane.add(cbDest);
		for (Destinations d : Destinations.values()) {

			cbDest.addItem(d);

		}
		

		// CB DATE
		JComboBox cbDate = new JComboBox();
		cbDate.setBounds(149, 121, 174, 27);
		contentPane.add(cbDate);
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		for (int i = 0; i < 10; i++) {
			
			
			
			cbDate.addItem(df.format(date));
			
			c.add(Calendar.DATE, 1);
			date = c.getTime();
			
		}

		JButton btnSaveFlight = new JButton("Flug anlegen");
		btnSaveFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
			System.out.println(cbOrigin.getSelectedItem());
				
		
			Flug flug = new Flug(cbDate.getSelectedItem().toString(), (Destinations)cbOrigin.getSelectedItem(), (Destinations)cbDest.getSelectedItem(), checkbox.isEnabled());
			
			//FlugVerwaltung fw = new FlugVerwaltung();
			
			FlugVerwaltung.add(flug);
			System.out.println(FlugVerwaltung.ser());

			
			Start.updateList();
				
				
			}
		});
		btnSaveFlight.setBounds(32, 233, 291, 29);
		contentPane.add(btnSaveFlight);

	}
}
