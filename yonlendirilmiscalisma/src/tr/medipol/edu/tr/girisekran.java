package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class girisekran extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel label1 = new JLabel("Kullan�c� Ad�:");
	static JLabel label2 = new JLabel("�ifre");
	static JTextField kullaniciadi = new JTextField();
	static JPasswordField sifre = new JPasswordField();
	static JButton giris = new JButton("Giri�");
	static JFrame jf = new JFrame();

	public static void main(String[] args) {

		veritabani.veritabaniBaglantisiKur();
		veritabani.tablolariOlustur();
		veritabani.kullanicilariOlustur();
		ekraniOlustur();
		giris.addActionListener(e -> giris(e));
	}
	
	@SuppressWarnings("deprecation")
	private static Object giris(ActionEvent e) {
		if (veritabani.kullanicikontrol(kullaniciadi.getText().toString(), sifre.getText().toString()) == true) {
			String tip = veritabani.tip;
			if (tip.equals("a")) {
				jf.dispose();
				ekranitemizle();
				admin_ekran.ekraniOlustur();
			} else if (tip.equals("p")) {
				jf.dispose();
				ekranitemizle();
				personel_ekran.ekraniOlustur();
			} else if (tip.equals("k")) {
				jf.dispose();
				ekranitemizle();
				kasiyer_ekran.ekraniOlustur();
			} else {
				JOptionPane.showMessageDialog(jf, "Kullan�c� tipi Yanl�� girilmi�...  \n Y�neticinize ba�vurunuz...");
			}
		} else {
			JOptionPane.showMessageDialog(jf,"Kullan�c� Bulunamad�.");
		}
		return e;
	}
	
	private static void ekranitemizle() {
		kullaniciadi.setText("");
		sifre.setText("");
	}


	public static void ekraniOlustur() {
		sifre.setEchoChar('@');
		jf.setTitle("Giri�");
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(400, 350);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.setContentPane(satir1);
		satir1.add(kullaniciadi);
		satir1.add(label1);
		satir1.add(label2);
		satir1.add(sifre);
		satir1.add(giris);
		label1.setBounds(0, 20, 90, 35);
		label2.setBounds(0, 60, 90, 35);
		kullaniciadi.setBounds(100, 20, 120, 35);
		sifre.setBounds(100, 60, 120, 35);
		giris.setBounds(0, 100, 100, 50);

	}

}