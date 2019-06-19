package tr.medipol.edu.tr;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class admin_ekran extends JFrame{
	/**
	 * a
	 */
	private static final long serialVersionUID = 1L;
	static JButton kullaniciekle = new JButton("Kullanýcý ekle");
	static JButton kullanicisil = new JButton("Kullanýcý sil");
	static JButton urunekle = new JButton("Ürün ekle");
	static JButton urunbl = new JButton("Ürün Bul");
	static JButton urunsl = new JButton("Ürün Sil");
	static JButton satis = new JButton("Satýþlar");
	static JButton cikis = new JButton("Çýkýþ");
	static JFrame jf = new JFrame();

	private static Object kullaniciekle(ActionEvent e) {
		ekranikapat();
		kullaniciolustur.ekraniOlustur();
		return null;
	}
	private static Object kullanicisil(ActionEvent e) {
		ekranikapat();
		kullanicisilme.ekraniOlustur();
		return null;
	}

	private static Object urunekle(ActionEvent e) {
		ekranikapat();
		urunolustur.ekraniOlustur();
		return null;
	}
	private static Object urunbl(ActionEvent e) {
		ekranikapat();
		urunbul.ekraniOlustur();
		return null;
	}
	private static Object urunsl(ActionEvent e) {
		ekranikapat();
		urunsil.ekraniOlustur();
		return null;
	}
	private static void ekranikapat() {
		jf.dispose();
	}

	private static Object cikis(ActionEvent e) {
		ekranikapat();
		girisekran.ekraniOlustur();
		return null;
	}
	private static Object satis(ActionEvent e) {
		ekranikapat();
		satisekran.ekraniOlustur();
		return null;
	}

	public static void ekraniOlustur() {
		jf.setTitle("Admin Ekraný");
		jf.setVisible(true);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kullaniciekle.addActionListener(e -> kullaniciekle(e));
		kullanicisil.addActionListener(e -> kullanicisil(e));
		urunekle.addActionListener(e -> urunekle(e));
		urunbl.addActionListener(e -> urunbl(e));
		urunsl.addActionListener(e -> urunsl(e));
		cikis.addActionListener(e -> cikis(e));
		satis.addActionListener(e -> satis(e));

		JPanel satir1 = new JPanel();
		satir1.setLayout(null);
		jf.setContentPane(satir1);
		satir1.add(kullaniciekle);
		satir1.add(kullanicisil);
		satir1.add(urunekle);
		satir1.add(urunbl);
		satir1.add(urunsl);
		satir1.add(cikis);
		satir1.add(satis);
		kullaniciekle.setBounds(0, 50, 150, 100);
		kullanicisil.setBounds(0, 350, 150, 100);
		urunsl.setBounds(200,50,150,100);
		urunekle.setBounds(0, 150, 150, 100);
		urunbl.setBounds(200,150,150,100);
		cikis.setBounds(0,250,150,100);
		satis.setBounds(200,250,150,100);
		/*
		 * BufferedImage img = null; try { img = ImageIO.read(new
		 * File("C:\\Users\\Efkanic\\Desktop\\stok.jpg")); } catch (IOException e) {
		 * e.printStackTrace(); } Image dimg = img.getScaledInstance(800, 800,
		 * Image.SCALE_DEFAULT); jf.setContentPane(new JLabel(new ImageIcon(dimg)));
		 * jf.setContentPane(new JLabel(new
		 * ImageIcon("C:\\Users\\Efkanic\\Desktop\\stok.jpg")));
		 */
	}
}