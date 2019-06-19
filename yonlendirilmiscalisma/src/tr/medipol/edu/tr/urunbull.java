package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class urunbull {

	static JLabel label1 = new JLabel("Ürün Adi:");

	static JLabel label2 = new JLabel("Barkod:");

	static JLabel label3 = new JLabel("Renk:");

	static JLabel label4 = new JLabel("Marka:");

	static JLabel label5 = new JLabel("Yas:");

	static JLabel label6 = new JLabel("Maðaza:");

	static JTextField textfield1 = new JTextField();

	static JTextField textfield2 = new JTextField();

	static JTextField textfield3 = new JTextField();

	static JTextField textfield4 = new JTextField();

	static JTextField textfield5 = new JTextField();

	static JTextField textfield6 = new JTextField();

	static JButton urunbulbuton = new JButton("Bul");

	static JButton geri = new JButton("Geri");
	
	static JFrame jf = new JFrame();

	private static Object urunbulbuton(ActionEvent e) {

		if (textfield1.getText().equals("")) {
			textfield1.setText("%");
		}
		if (textfield2.getText().equals("")) {
			textfield2.setText("%");
		}
		if (textfield3.getText().equals("")) {
			textfield3.setText("%");
		}
		if (textfield4.getText().equals("")) {
			textfield4.setText("%");
		}
		if (textfield5.getText().equals("")) {
			textfield5.setText("%");
		}
		if (textfield6.getText().equals("")) {
			textfield6.setText("%");
		}
	    if (veritabani.urunara(textfield1.getText(), textfield2.getText(), textfield3.getText(), textfield4.getText(),
				textfield5.getText(),textfield6.getText()) == true) {
	    	JOptionPane.showMessageDialog(jf, "Ürün Bulundu.");
			jf.dispose();
			urunbul.ekraniOlustur();
		}

		else {
			JOptionPane.showMessageDialog(jf,"Ürün Bulunamadý.");
		}

		return e;
	}

	public static void ekraniOlustur() {

		jf.setTitle("Ürün Bul");
		
		jf.setIgnoreRepaint(false);

		jf.setVisible(true);

		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		urunbulbuton.addActionListener(e -> urunbulbuton(e));
        
		geri.addActionListener(e -> geri(e));

		JPanel satir1 = new JPanel();

		satir1.setLayout(null);

		jf.setContentPane(satir1);

		satir1.add(label1);

		satir1.add(label2);

		satir1.add(label3);

		satir1.add(label4);

		satir1.add(label5);

		satir1.add(label6);

		satir1.add(textfield1);

		satir1.add(textfield2);

		satir1.add(textfield3);

		satir1.add(textfield4);

		satir1.add(textfield5);

		satir1.add(textfield6);

		satir1.add(urunbulbuton);

		satir1.add(geri);

		label1.setBounds(0, 20, 90, 35);

		label2.setBounds(0, 60, 90, 35);

		label3.setBounds(0, 100, 90, 35);

		label4.setBounds(0, 140, 90, 35);

		label5.setBounds(0, 180, 90, 35);

		label6.setBounds(0, 220, 90, 35);

		textfield1.setBounds(100, 20, 120, 35);

		textfield2.setBounds(100, 60, 120, 35);

		textfield3.setBounds(100, 100, 120, 35);

		textfield4.setBounds(100, 140, 120, 35);

		textfield5.setBounds(100, 180, 120, 35);

		textfield6.setBounds(100, 220, 120, 35);

		urunbulbuton.setBounds(0, 260, 100, 50);

		geri.setBounds(150, 260, 100, 50);
		if (veritabani.tip.equals("p")) {
			textfield6.setText(veritabani.magaza);
			textfield6.disable();
		}

	}

	private static Object geri(ActionEvent e) {
		jf.dispose();
		if (veritabani.tip.equals("a")) {
			admin_ekran.ekraniOlustur();
		}
		if (veritabani.tip.equals("p")) {
			personel_ekran.ekraniOlustur();
		}
		return null;
	}
}
