package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class kullaniciolustur {
	static JLabel label1 = new JLabel("Kullanýcý Adý:");
	static JLabel label2 = new JLabel("Þifre:");
	static JLabel label3 = new JLabel("Kullanýcý Tipi:");
	static JLabel label4 = new JLabel("Maðaza:");
	static JTextField kullaniciadi = new JTextField();
	static JTextField sifre = new JTextField();
	static JTextField tipi = new JTextField();
	static JTextField magaza = new JTextField();
	static JButton ekle = new JButton("Ekle");
	static JButton geri = new JButton("Geri");
	static JFrame jf = new JFrame();
	public static int i = 0;

	private static Object ekle(ActionEvent e) {
		i=1;
		if (kullaniciadi.getText().equals("") || sifre.getText().equals("") || tipi.getText().equals("")||magaza.getText().equals("")) {
			JOptionPane.showMessageDialog(jf, "Bütün alanlarý doldurunuz.");
		}
		else if (veritabani.kullaniciekle(kullaniciadi.getText(), sifre.getText(), tipi.getText(),magaza.getText()) == true) 
		{
			JOptionPane.showMessageDialog(jf, "Kullanýcý OLuþturduldu.");
		} else
		{
			JOptionPane.showMessageDialog(jf, "kullanýcýadý zaten var.");
		}
		return null;
	}
	private static Object geri(ActionEvent e) {
		i=1;
		jf.dispose();
		admin_ekran.ekraniOlustur();
		return null;
	}

	public static void ekraniOlustur() {
		jf.setTitle("Kullanýcý Ekle"); 
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (i==0) {
		ekle.addActionListener(e -> ekle(e));
		geri.addActionListener(e -> geri(e));
		}
		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.setContentPane(satir1);
		satir1.add(kullaniciadi);
		satir1.add(label1);
		satir1.add(label2);
		satir1.add(label3);
		satir1.add(label4);
		satir1.add(sifre);
		satir1.add(tipi);
		satir1.add(ekle);
		satir1.add(geri);
		satir1.add(magaza);
		label1.setBounds(0, 20, 90, 35);
		label2.setBounds(0, 60, 90, 35);
		label3.setBounds(0, 100, 90, 35);
		label4.setBounds(0, 140, 90, 35);
		kullaniciadi.setBounds(100, 20, 120, 35);
		sifre.setBounds(100, 60, 120, 35);
		magaza.setBounds(100, 140, 120, 35);
		tipi.setBounds(100, 100, 120, 35);
		ekle.setBounds(0, 180, 100, 50);
		geri.setBounds(100, 180, 100, 50);

	}
}
