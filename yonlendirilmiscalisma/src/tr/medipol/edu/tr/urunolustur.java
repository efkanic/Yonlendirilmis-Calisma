package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class urunolustur {

    static JLabel label1 = new JLabel("Ürün Adý:");

    static JLabel label2 = new JLabel("Barkod:");

	static JTextField urunadi = new JTextField();

	static JTextField barkod = new JTextField();

	static JButton urunekle = new JButton("Ekle");

	static JFrame jf = new JFrame();

	

	private static Object urunekle(ActionEvent e) {

		if (veritabani.kullaniciekle(urunadi.getText(), barkod.getText())==true){

			System.out.println("oluþturuldu");

		}

		else 
{
			System.out.println("Oluşturulamadı.");
}
		return null;

	}

	

	public static void ekraniOlustur() {

		jf.setTitle("Ürün ekle");

		jf.setVisible(true);

		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		urunekle.addActionListener(e->urunekle(e));

		

		JPanel satir1 = new JPanel();

		satir1.setLayout(null);

		jf.add(satir1);

		satir1.add(urunadi);

		satir1.add(label1);

		satir1.add(label2);

		satir1.add(barkod);

		satir1.add(urunekle);

		label1.setBounds(0,20,90,35);

		label2.setBounds(0,60,90,35);

		urunadi.setBounds(100,20,120,35);

		barkod.setBounds(100,60,120,35);

		urunekle.setBounds(0, 100, 100, 50);

	}

}
