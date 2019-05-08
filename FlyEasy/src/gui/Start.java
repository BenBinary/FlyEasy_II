package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenmodell.Destinations;
import datenmodell.Flug;
import datenmodell.FlugVerwaltung;

import javax.swing.JLabel;
import javax.swing.JList;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Scrollbar;

public class Start extends JFrame {

	private JPanel contentPane;
	FlugVerwaltung verwaltung = new FlugVerwaltung();
	static JList listFlights = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBitteWhlenSie = new JLabel("Bitte w\u00E4hlen Sie einen Flug aus");

		lblBitteWhlenSie.setBounds(15, 7, 264, 16);
		contentPane.add(lblBitteWhlenSie);

		//FlugVerwaltung.add(new Flug("20190505", Destinations.FRA, Destinations.DTM, false));
		//FlugVerwaltung.add(new Flug("20190505", Destinations.FRA, Destinations.MIA, true));
		//FlugVerwaltung.add(new Flug("20190505", Destinations.MUC, Destinations.GRU, true));

		//verwaltung.ser();

		updateList();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 34, 405, 199);
		contentPane.add(scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(listFlights);
		listFlights.setToolTipText("Eine Liste mit Fl\u00FCgen");
		
				listFlights.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
		
						try {
							FlightDetail frame = new FlightDetail((Flug)listFlights.getSelectedValue());
							frame.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
						System.out.println("es wurde etwas gecklickt");
					}
				});

		JButton btnNewFlight = new JButton("Neuer Flug");
		btnNewFlight.setBounds(15, 244, 126, 29);
		btnNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// NewFlight nf = new NewFlight();
				try {
					NewFlight nf = new NewFlight();
					nf.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				System.out.println("Neuer Flug soll angelegt werden");

			}
		});

		contentPane.add(btnNewFlight);

		JButton btnNeuerPassagier = new JButton("Neuer Passagier");
		btnNeuerPassagier.setBounds(155, 244, 136, 29);
		contentPane.add(btnNeuerPassagier);

		JButton btnNeueBuchung = new JButton("Neue Buchung");
		btnNeueBuchung.setBounds(303, 244, 117, 29);
		contentPane.add(btnNeueBuchung);

		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					updateList();
			}
		});
		btnRefresh.setBounds(303, 0, 117, 29);
		contentPane.add(btnRefresh);

		// System.out.println(listFlights.getSelectedIndices());
		// System.out.println(listFlights.getSelectedValuesList().toString());

	}

	public static void updateList() {

		List<Flug> fluege = FlugVerwaltung.deser();
		
		if (!fluege.isEmpty()) {

			System.out.println("Deserialisieren erfolgreich");

			System.out.println("updateList deserialisieren: " + fluege);

			DefaultListModel<Flug> dlm = new DefaultListModel<>();

			for (Flug f : fluege) {

				dlm.addElement(f);
				System.out.println("Iterieren der Flüge");
			}

			
			listFlights.removeAll();
			listFlights.setModel(dlm);
			//listFlights = new JList<Flug>(dlm);

		}

	}
}
