package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class satisekran {

	static JMenuBar menuBar = new JMenuBar();

	static JMenu menu = new JMenu("�r�nler");

	static JMenuItem

	menuItem1 = new JMenuItem("T�m sat��lar� getir."), menuItem2 = new JMenuItem("Geri");
	static JFrame jf = new JFrame();
	static JTable tb;
	static String[] columnNames = { "�r�n Ad�", "Barkod", "Renk", "Marka", "Ya�", "Fiyat", "Adet", "Ma�aza" };

	public static String[][] dataq = new String[0][0];

	public static int i = 0;

	private static Object menuItem1(ActionEvent e) {
		if (veritabani.tip.equals("a")) {
			veritabani.satisgetir();
			tb = new JTable(dataq, columnNames);
			JScrollPane sp = new JScrollPane(tb);
			jf.setContentPane(sp);
			jf.setVisible(true);
		}
		if (veritabani.tip.equals("p")) {
			veritabani.kisitlisatisgetir();
			tb = new JTable(dataq, columnNames);
			JScrollPane sp = new JScrollPane(tb);
			jf.setContentPane(sp);
			jf.setVisible(true);
		}
		return null;
	}

	private static Object menuItem2(ActionEvent e) {
		jf.dispose();
		if (veritabani.tip.equals("a")) {
			admin_ekran.ekraniOlustur();
		}
		if (veritabani.tip.equals("p")) {
			personel_ekran.ekraniOlustur();
		}
		return null;
	}

	public static void ekraniOlustur() {
		jf.setTitle("Sat�� Ekran�");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuItem1.addActionListener(e -> menuItem1(e));
		menuItem2.addActionListener(e -> menuItem2(e));
		menuBar.add(menuItem1);
		menuBar.add(menuItem2);
		jf.setJMenuBar(menuBar);

	}
}