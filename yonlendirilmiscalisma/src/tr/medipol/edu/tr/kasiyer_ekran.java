package tr.medipol.edu.tr;

import javax.swing.*;

public class kasiyer_ekran {
    static JLabel label1 = new JLabel("Kullanýcý Adý:");
    static JLabel label2 = new JLabel("Þifre");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JButton giris = new JButton("Giriþ");
	//satış için düzenlenecek...
public static void ekraniOlustur() {
	JFrame jf = new JFrame();
	jf.setTitle("Giriþ");
	jf.setVisible(true);
	jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	JPanel satir1 = new JPanel();
	satir1.setLayout(null);
	jf.add(satir1);
	satir1.add(kullaniciadi);
	satir1.add(label1);
	satir1.add(sifre);
	satir1.add(giris);
	label1.setBounds(0,20,90,35);
	label2.setBounds(0,60,90,35);
	kullaniciadi.setBounds(100,20,120,35);
	sifre.setBounds(100,60,120,35);
	giris.setBounds(0, 100, 100, 50);
	
	
}

}
