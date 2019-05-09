package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenmodell.Flug;
import datenmodell.FlugVerwaltung;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlightDetail extends JFrame {

	private JPanel contentPane;
	JLabel lblDatumData;
	JLabel lblZielData;
	JLabel lblStartData;
	Flug flug;
	

	//this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FlightDetail frame = new FlightDetail();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FlightDetail() {
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				
				setVisible(false);
				dispose();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				setVisible(false);
				dispose();
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblStart = new JLabel("Start:");
		GridBagConstraints gbc_lblStart = new GridBagConstraints();
		gbc_lblStart.insets = new Insets(0, 0, 5, 5);
		gbc_lblStart.gridx = 1;
		gbc_lblStart.gridy = 1;
		contentPane.add(lblStart, gbc_lblStart);
		
		lblStartData = new JLabel("New label");
		GridBagConstraints gbc_lblStartData = new GridBagConstraints();
		gbc_lblStartData.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartData.gridx = 3;
		gbc_lblStartData.gridy = 1;
		contentPane.add(lblStartData, gbc_lblStartData);
		
		JLabel lblZiel = new JLabel("Ziel:");
		GridBagConstraints gbc_lblZiel = new GridBagConstraints();
		gbc_lblZiel.insets = new Insets(0, 0, 5, 5);
		gbc_lblZiel.gridx = 1;
		gbc_lblZiel.gridy = 2;
		contentPane.add(lblZiel, gbc_lblZiel);
		
		lblZielData = new JLabel("New label");
		GridBagConstraints gbc_lblZielData = new GridBagConstraints();
		gbc_lblZielData.insets = new Insets(0, 0, 5, 5);
		gbc_lblZielData.gridx = 3;
		gbc_lblZielData.gridy = 2;
		contentPane.add(lblZielData, gbc_lblZielData);
		
		JLabel lblDatum = new JLabel("Datum:");
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatum.gridx = 1;
		gbc_lblDatum.gridy = 3;
		contentPane.add(lblDatum, gbc_lblDatum);
		
		lblDatumData = new JLabel("New label");
		GridBagConstraints gbc_lblDatumData = new GridBagConstraints();
		gbc_lblDatumData.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumData.gridx = 3;
		gbc_lblDatumData.gridy = 3;
		contentPane.add(lblDatumData, gbc_lblDatumData);
		
		JButton btnFlugStornieren = new JButton("Flug stornieren");
		btnFlugStornieren.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FlugVerwaltung.remove(FlugVerwaltung.getID(flug));
			}
		});
		GridBagConstraints gbc_btnFlugStornieren = new GridBagConstraints();
		gbc_btnFlugStornieren.insets = new Insets(0, 0, 5, 5);
		gbc_btnFlugStornieren.gridx = 1;
		gbc_btnFlugStornieren.gridy = 5;
		contentPane.add(btnFlugStornieren, gbc_btnFlugStornieren);
		
		JButton btnTicketBuchen = new JButton("Ticket buchen");
		btnTicketBuchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					NewTicket frame = new NewTicket(flug);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnTicketBuchen = new GridBagConstraints();
		gbc_btnTicketBuchen.insets = new Insets(0, 0, 5, 5);
		gbc_btnTicketBuchen.gridx = 3;
		gbc_btnTicketBuchen.gridy = 5;
		contentPane.add(btnTicketBuchen, gbc_btnTicketBuchen);
		
		JButton btnDetailsAusblenden = new JButton("Details ausblenden");
		btnDetailsAusblenden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setVisible(false);
				dispose();
			}
		});
		GridBagConstraints gbc_btnDetailsAusblenden = new GridBagConstraints();
		gbc_btnDetailsAusblenden.insets = new Insets(0, 0, 5, 0);
		gbc_btnDetailsAusblenden.gridx = 4;
		gbc_btnDetailsAusblenden.gridy = 5;
		contentPane.add(btnDetailsAusblenden, gbc_btnDetailsAusblenden);
	}
	
	public FlightDetail(Flug flug) {
		
		this();
		this.flug = flug;
		lblStartData.setText(flug.getOrgin().toString());
		lblZielData.setText(flug.getDestination().toString());
		lblDatumData.setText(flug.getStartDatumString());

		
	}

}
