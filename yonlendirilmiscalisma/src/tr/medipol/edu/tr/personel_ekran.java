package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;
public class personel_ekran {
    static JLabel label1 = new JLabel("Kullan�c� Ad�:");
    static JLabel label2 = new JLabel("�ifre");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JButton giris = new JButton("��k��");
	static JFrame jf = new JFrame();
	
	
private static Object giris(ActionEvent e) {
	jf.setVisible(false);
	girisekran.geridon();
	return null;
}

public static void ekraniOlustur() {
	jf.setTitle("Personel Ekran�");
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
	satir1.add(giris);
	label1.setBounds(0,20,90,35);
	label2.setBounds(0,60,90,35);
	kullaniciadi.setBounds(100,20,120,35);
	sifre.setBounds(100,60,120,35);
	giris.setBounds(0, 100, 100, 50);
	
	
}

}