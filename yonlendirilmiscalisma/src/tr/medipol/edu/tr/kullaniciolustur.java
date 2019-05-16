package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class kullaniciolustur {
	//OKK..
    static JLabel label1 = new JLabel("Kullanýcý Adý:");
    static JLabel label2 = new JLabel("Þifre");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JTextField tipi = new JTextField();
	static JButton giris = new JButton("Ekle");
	static JFrame jf = new JFrame();
	
	private static Object giris(ActionEvent e) {
		if (veritabani.kullaniciekle(kullaniciadi.getText(), sifre.getText(), tipi.getText())==true){
			System.out.println("oluþturuldu");
		}
		else 
			System.out.println("Boþ yapmayýnýz.");
		return null;
	}
	
	public static void ekraniOlustur() {
		jf.setTitle("Kullanýcý Ekle");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giris.addActionListener(e->giris(e));
		
		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.add(satir1);
		satir1.add(kullaniciadi);
		satir1.add(label1);
		satir1.add(label2);
		satir1.add(sifre);
		satir1.add(tipi);
		satir1.add(giris);
		label1.setBounds(0,20,90,35);
		label2.setBounds(0,60,90,35);
		kullaniciadi.setBounds(100,20,120,35);
		sifre.setBounds(100,60,120,35);
		tipi.setBounds(100,120,120,35);
		giris.setBounds(0, 100, 100, 50);
		
		
	}


}
