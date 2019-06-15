package gui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachlogik.Flug;
import fachlogik.FlugVerwaltung;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Start extends JFrame {

	private JPanel contentPane;
	FlugVerwaltung verwaltung = new FlugVerwaltung();
	static JList listFlights = new JList();
	JButton btnTicketBuchen; 

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

	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Modus");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAdmin = new JMenuItem("Admin");
		mnNewMenu.add(mntmAdmin);
		
		JMenuItem mntmKunde = new JMenuItem("Kunde");
		mnNewMenu.add(mntmKunde);
		
		JMenuItem mntmMenu = new JMenuItem("Menu");
		menuBar.add(mntmMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBitteWhlenSie = new JLabel("Bitte w\u00E4hlen Sie einen Flug aus");

		lblBitteWhlenSie.setBounds(15, 7, 264, 16);
		contentPane.add(lblBitteWhlenSie);

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
							
							btnTicketBuchen.setEnabled(true);
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

		btnTicketBuchen = new JButton("Ticket buchen");
		btnTicketBuchen.setEnabled(false);
		btnTicketBuchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					NewTicket frame = new NewTicket((Flug)listFlights.getSelectedValue());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnTicketBuchen.setBounds(303, 244, 117, 29);
		contentPane.add(btnTicketBuchen);

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

		List<Flug> fluege = FlugVerwaltung.load();
		
		if (!fluege.isEmpty()) {

			System.out.println("Deserialisieren erfolgreich");

			System.out.println("updateList deserialisieren: " + fluege);

			DefaultListModel<Flug> dlm = new DefaultListModel<>();

			for (Flug f : fluege) {

				dlm.addElement(f);
				System.out.println("Iterieren der Fl�ge");
			}

			listFlights.removeAll();
			listFlights.setModel(dlm);
			
			//listFlights = new JList<Flug>(dlm);

		}

	}
}
