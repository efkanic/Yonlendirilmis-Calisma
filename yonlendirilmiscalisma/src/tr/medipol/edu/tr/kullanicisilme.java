package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class kullanicisilme {
	static JFrame jf = new JFrame();
	static JLabel label1=new JLabel("Kullanýcý Adý:");
	static JTextField kullaniciadi = new JTextField();
	static JButton sil = new JButton("Sil");
	static JButton geri = new JButton("Geri Dön");



	private static Object geri(ActionEvent e) {
		jf.dispose();
		admin_ekran.ekraniOlustur();
		return null;
	}


	private static Object sil(ActionEvent e) {
		if (kullaniciadi.getText().equals("")) {
			JOptionPane.showMessageDialog(jf,"Kullanýcý adý giriniz...");
		}else {
		veritabani.kullanicisl(kullaniciadi.getText());
		JOptionPane.showMessageDialog(kullanicisilme.jf,kullaniciadi.getText()+" Kullanýcýsý Baþarýyla Silindi... ");
		}
		return null;
	}
	
	public static void ekraniOlustur() {
		jf.setTitle("Kullanýcý Sil Ekraný");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		sil.addActionListener(e -> sil(e));
        
		geri.addActionListener(e -> geri(e));

		JPanel satir1 = new JPanel();

		satir1.setLayout(null);

		jf.setContentPane(satir1);
		satir1.add(label1);

		satir1.add(sil);

		satir1.add(geri);

		satir1.add(kullaniciadi);
		label1.setBounds(0, 20, 90, 35);

		kullaniciadi.setBounds(100, 20, 120, 35);

		sil.setBounds(0, 60, 90, 35);

		geri.setBounds(100, 60, 120, 35);
		

	}
}