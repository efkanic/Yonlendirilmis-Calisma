package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class kasiyer_ekran {
	static JLabel label1 = new JLabel("Barkod:");
	static JLabel label4 = new JLabel("Adet:");
	static JTextField barkod = new JTextField();
	static JTextField adet = new JTextField();
	static JLabel label2= new JLabel("Fiyat:");
	static JLabel label3= new JLabel("0 TL");
	static JButton satis = new JButton("Satýþ");
	static JButton cikis = new JButton("Çýkýþ");
	static JFrame jf = new JFrame();

	public static void ekraniOlustur() {
		jf.setTitle("Giriþ");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		satis.addActionListener(e->AddActionListener(e));
		cikis.addActionListener(e->cikis(e));

		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.setContentPane(satir1);
		satir1.add(barkod);
		satir1.add(label1);
		satir1.add(label2);
		satir1.add(label3);
		satir1.add(label4);
		satir1.add(satis);
		satir1.add(cikis);
		satir1.add(adet);
		label1.setBounds(0, 20, 90, 35);
		barkod.setBounds(100, 20, 120, 35);
		label4.setBounds(0, 60, 90, 35);
		adet.setBounds(100, 60, 120, 35);
		label2.setBounds(0, 100, 90, 35);
		label3.setBounds(100, 100, 90, 35);
		satis.setBounds(0, 140, 100, 50);
		cikis.setBounds(150, 140, 100, 50);

	}

	private static Object cikis(ActionEvent e) {
		jf.dispose();
		girisekran.ekraniOlustur();
		return null;
	}

	private static Object AddActionListener(ActionEvent e) {
		if (barkod.getText().equals("")||adet.getText().equals("")) {
			JOptionPane.showMessageDialog(jf, "Tüm alanlarý doldurunuz.");
		}
		else {
			if (veritabani.satisyap(barkod.getText(),Integer.parseInt(adet.getText()))==true){
			    JOptionPane.showMessageDialog(jf,"Satýþ Yapýldý.");
			}
			else{
				JOptionPane.showMessageDialog(jf, "Satýþ Yapýlamadý.");
			}
		}
		return null;
	}
}
