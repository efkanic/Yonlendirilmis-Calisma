package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class urunolustur {

	static JLabel label1 = new JLabel("Ürün Adi:");

	static JLabel label2 = new JLabel("Barkod:");

	static JLabel label3 = new JLabel("Renk:");

	static JLabel label4 = new JLabel("Marka:");

	static JLabel label5 = new JLabel("Yas:");

	static JLabel label6 = new JLabel("Fiyat:");

	static JLabel label7 = new JLabel("Adet:");

	static JLabel label8 = new JLabel("Mağaza:");

	static JTextField textfield1 = new JTextField();

	static JTextField textfield2 = new JTextField();

	static JTextField textfield3 = new JTextField();

	static JTextField textfield4 = new JTextField();

	static JTextField textfield5 = new JTextField();

	static JTextField textfield6 = new JTextField();

	static JTextField textfield7 = new JTextField();

	static JTextField textfield8 = new JTextField();

	static JButton urunekle = new JButton("Ekle");

	static JButton iptal = new JButton("iptal");

	static JFrame jf = new JFrame();

	private static Object urunekle(ActionEvent e) {
		if (textfield1.getText().equals("") || textfield2.getText().equals("") || textfield3.getText().equals("")
				|| textfield4.getText().equals("") || textfield5.getText().equals("") || textfield6.getText().equals("")
				|| textfield7.getText().equals("")|| textfield8.getText().equals("")) {
			Uyarı();
		} else {
			textfield6.getText();
			textfield7.getText();
			if (veritabani.urunekle(textfield1.getText(), textfield2.getText(), textfield3.getText(),
					textfield4.getText(), textfield5.getText(),cevir(textfield6.getText()),ceviri(textfield7.getText()),textfield8.getText()) == true) {
				
				JOptionPane.showMessageDialog(jf,"Ürün Oluşturuldu.");

			}

			else {
				JOptionPane.showMessageDialog(jf,"Aynı Barkodlu ürün oluşturulamaz.");
			}

		}
		return null;
	}
	public static double a=-1;
	public static int b=-1;
	private static double cevir(String deger) {
		try {
			a=-1;
			a=Double.parseDouble(deger);
			System.out.println(a);
			return a;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(jf, "Sayı giriniz");
			return a;
		}
	}
	private static int ceviri(String deger) {
		try {
			b=-1;
			b=Integer.parseInt(deger);
			System.out.println(b);
			return b;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(jf, "Sayı giriniz");
			return b;
		}
	}
	private static Object iptal(ActionEvent e) {
		jf.dispose();
		admin_ekran.ekraniOlustur();
		return null;
	}

	private static void Uyarı() {
		JOptionPane.showMessageDialog(jf, "Tüm alanları doldurunuz.");
	}

	public static void ekraniOlustur() {

		jf.setTitle("Ürün ekle");
		
		jf.setVisible(true);

		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		urunekle.addActionListener(e -> urunekle(e));

		iptal.addActionListener(e -> iptal(e));

		JPanel satir1 = new JPanel();

		satir1.setLayout(null);

		jf.setContentPane(satir1);

		satir1.add(label1);

		satir1.add(label2);

		satir1.add(label3);

		satir1.add(label4);

		satir1.add(label5);

		satir1.add(label6);

		satir1.add(label7);

		satir1.add(label8);

		satir1.add(textfield1);

		satir1.add(textfield2);

		satir1.add(textfield3);

		satir1.add(textfield4);

		satir1.add(textfield5);

		satir1.add(textfield6);

		satir1.add(textfield7);

		satir1.add(textfield8);

		satir1.add(urunekle);

		satir1.add(iptal);

		label1.setBounds(0, 20, 90, 35);

		label2.setBounds(0, 60, 90, 35);

		label3.setBounds(0, 100, 90, 35);

		label4.setBounds(0, 140, 90, 35);

		label5.setBounds(0, 180, 90, 35);

		label6.setBounds(0, 220, 90, 35);

		label7.setBounds(0, 260, 90, 35);

		label8.setBounds(0, 300, 90, 35);

		textfield1.setBounds(100, 20, 120, 35);

		textfield2.setBounds(100, 60, 120, 35);

		textfield3.setBounds(100, 100, 120, 35);

		textfield4.setBounds(100, 140, 120, 35);

		textfield5.setBounds(100, 180, 120, 35);

		textfield6.setBounds(100, 220, 120, 35);

		textfield7.setBounds(100, 260, 120, 35);

		textfield8.setBounds(100, 300, 120, 35);

		urunekle.setBounds(0, 340, 100, 50);

		iptal.setBounds(150, 340, 100, 50);

	}
}