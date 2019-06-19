package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class personel_ekran {
	static JButton urunbl = new JButton("Ürün bul");
	static JButton cikis = new JButton("Çıkış");
	static JButton satis = new JButton("Satislar");
	static JFrame jf = new JFrame();

	private static Object urunbl(ActionEvent e) {
		jf.dispose();
		urunbull.ekraniOlustur();
		return null;
	}
	private static Object cikis(ActionEvent e) {
		jf.dispose();
		girisekran.ekraniOlustur();
		return null;
	}
	private static Object satis(ActionEvent e) {
		jf.dispose();
		satisekran.ekraniOlustur();
		return null;
	}

	public static void ekraniOlustur() {
		jf.setTitle("Personel Ekranı");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		urunbl.addActionListener(e -> urunbl(e));
		cikis.addActionListener(e -> cikis(e));
		satis.addActionListener(e -> satis(e));

		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.setContentPane(satir1);
		satir1.add(urunbl);
		satir1.add(cikis);
		satir1.add(satis);
		urunbl.setBounds(0, 100, 100, 50);
		cikis.setBounds(150, 100, 100, 50);
		satis.setBounds(300, 100, 100, 50);
	}
}