package tr.medipol.edu.tr;

import java.sql.*;
import javax.swing.JOptionPane;

public class veritabani {
	public static String tip;
	public static String magaza;

	private static Statement veritabaniStatement;
	public static Connection veritabaniBaglantisi;

	public static Statement veritabaniBaglantisiKur() {
		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

			veritabaniBaglantisi = DriverManager
					.getConnection("jdbc:derby:" + "./.efkanicdb/" + ";create=true;");

			veritabaniStatement = veritabaniBaglantisi.createStatement();
			
			return veritabaniStatement;

		} catch (Exception e) {
			System.out.println("Veritabanina baglanirken hata olustu");
		}

		return null;
	}

	public static boolean tablolariOlustur() {

		try {
			// "urunler" tablosu: urunid eþsiz , urunadi, urunkategori, fiyat tl
			/*veritabaniStatement
					.executeUpdate("CREATE TABLE " + "urunler (" + "urunadi varchar(20)," + "barkod varchar(20),"

							+ "renk varchar(20),"

							+ "marka varchar(20)," + "yas varchar(20),fiyat Integer,adet Integer,magaza varchar(20)," + "PRIMARY KEY(barkod) " + ")");
			/*veritabaniStatement.executeUpdate("CREATE TABLE " + "kullanicilar (" + "kullaniciid varchar(20),"
					+ "sifre varchar(15), " + "kullanicitipi varchar(10),magaza varchar(20)," + "PRIMARY KEY (kullaniciid)" + ")");
			/*veritabaniStatement.executeUpdate("DROP TABLE urunler");
			veritabaniStatement.executeUpdate("DROP TABLE kullanicilar");*/
			// "uyeler" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate("CREATE TABLE " + "satis (" + "urunadi varchar(20)," + "barkod varchar(20),"

							+ "renk varchar(20),"

							+ "marka varchar(20)," + "yas varchar(20),fiyat Integer,adet Integer,magaza varchar(20)" + " " + ")");

			System.out.println("Tablolar basariyla olusturuldu");
		} catch (Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}

		return true;
	}
	public static int kalan;
	public static boolean satisyap(String barkod,int adet) {
		try {
			ResultSet sonuclar = veritabaniStatement.executeQuery("Select * From urunler Where barkod='"+barkod+"'");
			while(sonuclar.next()) {
				kasiyer_ekran.label3.setText(String.valueOf(sonuclar.getInt("fiyat")));
				String urunad = sonuclar.getString("urunadi");
				String bark = sonuclar.getString("barkod");
				String ren = sonuclar.getString("renk");
				String ya = sonuclar.getString("yas");
				String mar = sonuclar.getString("marka");
				int fiyat = sonuclar.getInt("fiyat");
			    kalan = sonuclar.getInt("adet");
				kalan=kalan-adet;
			    if (kalan<=-1) {
			    	JOptionPane.showMessageDialog(kasiyer_ekran.jf,"Maðazanýzda "+adet+" adet ürün kalmamýþtýr.");
			    	return false;
			    }
				String mag = sonuclar.getString("magaza");
				veritabaniStatement.executeUpdate("INSERT INTO satis VALUES ( " + "'" + urunad + "', '" + bark + "',"
						+ "'" + ren + "', '" + mar + "'," + "'" + ya + "',"+fiyat + ","+adet+",'"+mag+"')");
				veritabaniStatement.executeUpdate("Update urunler Set adet="+ kalan+ " WHERE barkod='"+barkod+"'");
				break;
			}
				return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(kasiyer_ekran.jf, "Satýþ baþarýsýz."+e.getMessage());
		}
		return false;
	}
	public static boolean satisgetir() {
		try {
			int a=0;
			ResultSet sonuclar = veritabaniStatement.executeQuery("Select * FROM satis");
			while (sonuclar.next()) {
				a++;
			}
			satisekran.dataq = new String[a][8];
			a=0;
			sonuclar.clearWarnings();
			sonuclar = veritabaniStatement.executeQuery("Select * FROM satis");
			while (sonuclar.next()) {
					for (int j = 0 ; j<8;j++) {
						String row ;
						row=sonuclar.getString(j+1);
						satisekran.dataq[a][j]=row;
					}
					a++;
			}
			sonuclar.clearWarnings();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static void kisitlisatisgetir() {
		try {
		      int a=0;
		      ResultSet sonuclar = veritabaniStatement.executeQuery("Select * FROM satis WHERE magaza='"+magaza+"'");
		while (sonuclar.next()) {
			a++;
		}
		satisekran.dataq = new String[a][8];
		a=0;
		sonuclar.clearWarnings();
		sonuclar = veritabaniStatement.executeQuery("Select * FROM satis");
		while (sonuclar.next()) {
				for (int j = 0 ; j<8;j++) {
					String row ;
					row=sonuclar.getString(j+1);
					satisekran.dataq[a][j]=row;
				}
				a++;
		}
		sonuclar.clearWarnings();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
	}
	public static void kullanicilariOlustur() {
		try {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			// efkan 123 a
			// mehmet 123 p
			// ayþe 123 k
			// ertu 1234 ert yanlýþ giriþ için
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ('ayþe', '123', 'k','eminönü')");
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ('efkan', '123', 'a','Kavacýk')");
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ('mehmet', '123', 'p','ankara')");
			System.out.println("Sistem kullanicilari olusturuldu.");
			// veritabaniStatement.executeUpdate("TRUNCATE TABLE kullanicilar");
		} catch (Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}

	public static boolean kullaniciekle(String id, String sifre, String tipi,String magaza) {
		try {
			veritabaniStatement.executeUpdate(
					"INSERT INTO kullanicilar VALUES ( " + "'" + id + "', '" + sifre + "', '" + tipi + "','"+magaza + "')");
			
			return true;
		} catch (Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		return false;
	}

	public static boolean urunekle(String urunadi, String barkod, String renk, String marka, String yas,double fiyat,int adet,String magaza) {
		try {
			if (urunolustur.a==-1||urunolustur.b==-1) {
				return false;
			}
			else {
			veritabaniStatement.executeUpdate("INSERT INTO urunler VALUES ( " + "'" + urunadi + "', '" + barkod + "',"
					+ "'" + renk + "', '" + marka + "'," + "'" + yas + "',"+fiyat + ","+adet+",'"+magaza+"')");
			JOptionPane.showMessageDialog(urunolustur.jf,"Ürün Oluþturuldu.");
			return true;
			}
		} catch (Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		return false;
	}
	public static void kullanicisl(String kullaniciad) {
		try {
			veritabaniStatement.executeUpdate("DELETE FROM kullanicilar Where kullaniciid='"+kullaniciad+"'");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(kullanicisilme.jf,"Bir þey oldu. "+e.getMessage());
		}
	}
	/*
	while (sonuclar.next()) {
		ArrayList<String> row = new ArrayList<>();
		for (int i = 1; i <= c; i++) {
			row.add(sonuclar.getString(i));
		}
		System.out.println(row);
		data.add(row);
	}
	System.out.println(data);*/
	public static boolean hepsinigetir() {
		try {
			int a=0;
			ResultSet sonuclar = veritabaniStatement.executeQuery("Select * FROM urunler");
			while (sonuclar.next()) {
				a++;
			}
			urunbul.dataq = new String[a][8];
			a=0;
			sonuclar.clearWarnings();
			sonuclar = veritabaniStatement.executeQuery("Select * FROM urunler");
			while (sonuclar.next()) {
					for (int j = 0 ; j<8;j++) {
						String row ;
						row=sonuclar.getString(j+1);
						urunbul.dataq[a][j]=row;
					}
					a++;
				/*
				String urunad = sonuclar.getString("urunadi");
				String bark = sonuclar.getString("barkod");
				String ren = sonuclar.getString("renk");
				String ya = sonuclar.getString("yas");
				String mar = sonuclar.getString("marka");
				System.out.println(urunad + bark + ren + ya + mar);*/
			}
		  /*00 01 02 03 04
			10 11 12 13 14
			while (sonuclar.next()) {
				String row ;
				for (int i = 0; i < c; i++) {
					row=sonuclar.getString(i+1);
					System.out.println(row);
				}
			}
			System.out.println(data);*/
			sonuclar.clearWarnings();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean urunara(String urunadi, String barkod, String renk, String marka, String yas,String magaza) {
		try {
			int a=0;
			ResultSet sonuclar = veritabaniStatement.executeQuery("Select * FROM urunler Where urunadi LIKE '" + urunadi
					+ "'and barkod LIKE '" + barkod + "'and renk LIKE " + "'" + renk + "'and marka LIKE '" + marka
					+ "'and yas LIKE " + "'" + yas + "'and magaza LIKE '"+magaza+"'");
			while (sonuclar.next()) {
				a++;
			}
			System.out.println(a);
			urunbul.dataq = new String[a][8];
			a=0;
			sonuclar.clearWarnings();
			sonuclar = veritabaniStatement.executeQuery("Select * FROM urunler Where urunadi LIKE '" + urunadi
					+ "'and barkod LIKE '" + barkod + "'and renk LIKE " + "'" + renk + "'and marka LIKE '" + marka
					+ "'and yas LIKE " + "'" + yas + "'and magaza LIKE '"+magaza+"'");
			while (sonuclar.next()) {
					for (int j = 0 ; j<8;j++) {
						String row ;
						row=sonuclar.getString(j+1);
						urunbul.dataq[a][j]=row;
					}
					a++;
			}
			sonuclar.clearWarnings();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(urunbull.jf, e.getMessage());
		}
		return false;
	}
	public static boolean urunsil(String barkod) {
		try {
			veritabaniStatement.executeUpdate("DELETE * FROM urunler Where barkod='"+barkod+"'");
			JOptionPane.showMessageDialog(urunsil.jf, "Ürün silindi.");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean kullanicikontrol(String k, String s) {
		try {
			ResultSet sonuclar = veritabaniStatement.executeQuery("SELECT * FROM kullanicilar");
			while (sonuclar.next()) {
				String kul = sonuclar.getString("kullaniciid");
				String sif = sonuclar.getString("sifre");
				if (kul.equals(k) && sif.equals(s)) {
					tip = sonuclar.getString("kullanicitipi");
					magaza = sonuclar.getString("magaza");
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
