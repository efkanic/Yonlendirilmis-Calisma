package tr.medipol.edu.tr;
import  java.sql.*;

public class veritabani {

	
	private static Statement veritabaniStatement;
	
	public static Statement veritabaniBaglantisiKur() {
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					+ "./.efkanicdb/"
					+ ";create=true;"
					);
			
			veritabaniStatement = veritabaniBaglantisi.createStatement();
			
			return veritabaniStatement;
			
		} catch(Exception e) {
			System.out.println("Veritabanina baglanirken hata olustu");
		}
		
		return null;
	}
	
	public static boolean tablolariOlustur() {
		
		try  {
			//"urunler" tablosu: urunid eþsiz , urunadi, urunkategori, fiyat tl 
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "kullanicilarr ("
								+ "kullaniciadi varchar(20),"
								+ "sifre varchar(15), "
								+ "kullanicitipi varchar(10) "
							+ ")"
			);
			// "uyeler" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			
			System.out.println("Tablolar basariyla olsuturuldu");
			
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: ");
		}
		
		return true;
	}
	public static void kullanicilariOlustur() {
		try  {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilarr VALUES ( "
					+ "'efkan', '123', 'e'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	public static boolean kullanicikontrol(String k,String s) {
		try {
			ResultSet sonuclar = veritabaniStatement.executeQuery(
					"SELECT * FROM kullanicilarr");
			while (sonuclar.next()) {
				String kul=sonuclar.getString("kullaniciadi");
				String sif=sonuclar.getString("sifre");
				System.out.println("Efkan");
				if (kul.equals(k) && sif.equals(s)) {
					return true;
				}
			}
		}catch (Exception e){
			
		}
		return false;
	}
}
