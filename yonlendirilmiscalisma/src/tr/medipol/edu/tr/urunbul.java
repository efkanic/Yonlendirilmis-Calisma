package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class urunbul extends JFrame {
	private static Object menuItem1(ActionEvent e) {
		i = 1;
		veritabani.hepsinigetir();
		jf.dispose();
		urunbul.ekraniOlustur();
		return null;
	}

	private static Object menuItem2(ActionEvent e) {
		i = 1;
		jf.dispose();
		urunbull.ekraniOlustur();
		return null;
	}
	private static Object menuItem3(ActionEvent e) {
		i=1;
		jf.dispose();
		if (veritabani.tip.equals("a")) {
			admin_ekran.ekraniOlustur();
		}
		if (veritabani.tip.equals("p")) {
			personel_ekran.ekraniOlustur();
		}
		return null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JFrame jf = new JFrame();

	static JMenuBar menuBar = new JMenuBar();

	static JMenu menu = new JMenu("Ürünler");

	static JMenuItem

	menuItem1 = new JMenuItem("Tüm ürünleri getir"),

			menuItem2 = new JMenuItem("Ürün bul"),

					menuItem3 = new JMenuItem("Geri");

	static JTable tb = new JTable();

	public static String[][] dataq = new String[0][0];

	static String[] columnNames = { "Ürün Adý", "Barkod", "Renk", "Marka", "Yaþ","Fiyat","Adet","Maðaza" };

	static int i = 0;

	public static void ekraniOlustur() {
		
		jf.setTitle("Ürün Listele");

		jf.setVisible(true);

		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (i == 0) {

			menuItem1.addActionListener(e -> menuItem1(e));

			menuItem2.addActionListener(e -> menuItem2(e));

			menuItem3.addActionListener(e -> menuItem3(e));
		}

	    menu.add(menuItem1);
		if (veritabani.tip.equals("p")) {
			menu.remove(menuItem1);
		}

		menu.add(menuItem2);
		
		menu.add(menuItem3);

		menuBar.add(menu);
		
		tb = new JTable(dataq, columnNames);
		JScrollPane sp = new JScrollPane(tb);
		jf.setContentPane(sp);
		jf.setJMenuBar(menuBar);
		/*
		 * tb = new JTable(data, columnNames); JScrollPane sp = new JScrollPane(tb);
		 * jf.add(sp);
		 */
	}
}