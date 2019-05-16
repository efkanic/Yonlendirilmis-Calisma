package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class girisekran {
    static JLabel label1 = new JLabel("Kullanýcý Adý:");
    static JLabel label2 = new JLabel("Þifre");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JButton giris = new JButton("Giriþ");
    static JFrame jf = new JFrame();

	public static void main(String[] args) {
		
		veritabani.veritabaniBaglantisiKur();
		veritabani.tablolariOlustur();
		veritabani.kullanicilariOlustur();
		ekraniOlustur();
		giris.addActionListener(e->giris(e));
		//OK..
		
	}
	
	private static Object giris(ActionEvent e) {
		if(veritabani.kullanicikontrol(kullaniciadi.getText().toString(), sifre.getText().toString())==true) {
			String tip =veritabani.tip;
			if (tip.equals("a")) {
			ekranigizle();
			admin_ekran.ekraniOlustur();
			}
			else if (tip.equals("p")) {
				ekranigizle();
				personel_ekran.ekraniOlustur();
			}
			else if (tip.equals("k")) {
				ekranigizle();
				kasiyer_ekran.ekraniOlustur();
			}
		}
		else {
			System.out.println("Kullanýcý bulunamadý.");
		}
		return e;
	}
	public static void geridon() {
		jf.setVisible(true);
	}
	private static void ekranigizle() {
		jf.setVisible(false);
	}
	@SuppressWarnings("deprecation")
	public static void ekraniOlustur() {
		jf.setTitle("Giriþ");
		jf.setVisible(true);
		jf.setSize(400,350);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.add(satir1);
		satir1.add(kullaniciadi);
		satir1.add(label1);
		satir1.add(label2);
		satir1.add(sifre);
		satir1.add(giris);
		label1.setBounds(0,20,90,35);
		label2.setBounds(0,60,90,35);
		kullaniciadi.setBounds(100,20,120,35);
		sifre.setBounds(100,60,120,35);
		giris.setBounds(0, 100, 100, 50);
		
		
	}

}
