package tr.medipol.edu.tr;
import  java.sql.*;

public class veritabani {
	public static String tip;

	
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
							+ "kullanicilar ("
								+ "kullaniciid varchar(20),"
								+ "sifre varchar(15), "
								+ "kullanicitipi varchar(10),"
								+ "PRIMARY KEY (kullaniciid)"
							+ ")"
			);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "urunler ("
								+ "urunadi varchar(20),"
								+ "barkod varchar(15) "
							+ ")"
			);
			// "uyeler" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			
			System.out.println("Tablolar basariyla olusturuldu");
			
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: "+e.getMessage());
		}
		
		
		return true;
	}
	public static void kullanicilariOlustur() {
		try  {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			// efkan 123 a
			// mehmet 123 p
			// ayþe 123 k
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'ayþe', '123', 'k'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
			//veritabaniStatement.executeUpdate("TRUNCATE TABLE kullanicilar");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	public static boolean kullaniciekle(String id,String sifre,String tipi) {
		try  {
			if (id ==null||sifre==null||tipi==null) {
				return false;
			}
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'"+id+"', '"+sifre+"', '"+tipi+"'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
		    return true;
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		return false;
	}
	public static boolean urunekle(String urunadi,String barkod) {
		try  {
			if (urunadi ==null||barkod==null) {
				return false;
			}
			veritabaniStatement.executeUpdate("INSERT INTO urunler VALUES ( "
					+ "'"+urunadi+"', '"+barkod+"'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
		    return true;
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		return false;
	}
	public static boolean kullanicikontrol(String k,String s) {
		try {
			ResultSet sonuclar = veritabaniStatement.executeQuery(
					"SELECT * FROM kullanicilar");
			while (sonuclar.next()) {
				String kul=sonuclar.getString("kullaniciid");
				String sif=sonuclar.getString("sifre");
				if (kul.equals(k) && sif.equals(s)) {
				    tip=sonuclar.getString("kullanicitipi");
					return true;
				}
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}
}
