package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class urunsil {
	static JLabel label1 = new JLabel("Barkod:");
	static JTextField barkod = new JTextField();
	static JButton sil = new JButton("Sil");
	static JButton cikis = new JButton("Çýkýþ");
	static JFrame jf = new JFrame();
	
	private static Object sil(ActionEvent e) {
		if (veritabani.urunsil(barkod.getText())==true) {
			JOptionPane.showMessageDialog(jf, "Ürün Silindi.");
		}
		else {
			JOptionPane.showMessageDialog(jf, "Ürün Silinemedi!.");
		}
		return null;
	}
	private static Object cikis(ActionEvent e) {
		jf.dispose();
		admin_ekran.ekraniOlustur();
		return null;
	}
	
	public static void ekraniOlustur() {
	jf.setTitle("Ürün Sil");
	jf.setVisible(true);
	jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cikis.addActionListener(e -> cikis(e));
	sil.addActionListener(e -> sil(e));

	JPanel satir1 = new JPanel();
	satir1.setLayout(null);
	jf.setContentPane(satir1);
	satir1.add(barkod);
	satir1.add(label1);
	satir1.add(cikis);
	satir1.add(sil);
	label1.setBounds(0, 20, 90, 35);
	barkod.setBounds(50, 20, 120, 35);
	sil.setBounds(0, 60, 100, 50);
	cikis.setBounds(150, 60, 100, 50);
}

}
