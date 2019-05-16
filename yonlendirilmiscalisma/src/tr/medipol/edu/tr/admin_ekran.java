package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class admin_ekran {
    static JLabel label1 = new JLabel("Kullanýcý Adý:");
    static JLabel label2 = new JLabel("Þifre");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JButton kullaniciekle = new JButton("Kullanıcı ekle");
	static JButton urunekle = new JButton("Ürün ekle");
	static JFrame jf = new JFrame();
	
	private static Object giris(ActionEvent e) {
		ekranigizle();
		kullaniciolustur.ekraniOlustur();
		return null;
	}
	private static Object urunekle(ActionEvent e) {
		ekranigizle();
		urunolustur.ekraniOlustur();
		return null;
	}
	private static void ekranigizle() {
		jf.setVisible(false);
	}
public static void ekraniOlustur() {
	jf.setTitle("Admin Ekraný");
	jf.setVisible(true);
	jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	kullaniciekle.addActionListener(e->kullaniciekle(e));
	urunekle.addActionListener(e->urunekle(e));
	
	JPanel satir1 = new JPanel();
	satir1.setLayout(null);
	jf.add(satir1);
	satir1.add(kullaniciadi);
	satir1.add(label1);
	satir1.add(label2);
	satir1.add(kullaniciekle);
	satir1.add(urunekle);
	label1.setBounds(0,20,90,35);
	label2.setBounds(0,60,90,35);
	kullaniciadi.setBounds(100,20,120,35);
	sifre.setBounds(100,60,120,35);
	kullaniciekle.setBounds(0, 100, 100, 50);
	urunekle.setBounds(0, 150, 150, 100);
	
	
}

}
