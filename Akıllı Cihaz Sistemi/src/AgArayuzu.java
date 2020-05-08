import java.util.Random;
import java.util.Scanner;
import java.sql.*;
public class AgArayuzu implements IAgArayuzu {
    private static AgArayuzu instance;
    private boolean ilkKezMi = true;
    public static synchronized AgArayuzu getInstance(){
        if(instance == null)
            instance = new AgArayuzu();
        return instance;
    }
    public double sicaklikAl(){
        Random rand = new Random();
        double sicaklik = rand.nextInt(50);
        bildirimGoster("Yeni sicaklik degeri: " + sicaklik);
        return sicaklik;
    }
    @Override
    public int istekAl() throws SQLException, InterruptedException {
        if(ilkKezMi) {
            kullaniciGirisi();
            this.ilkKezMi = false;
        }
        int istek;
        bildirimGoster("Sistem bekleme durumunda...");
        bildirimGoster("Islem seciniz (1-Sogutucu Ac 2-Sogutucu Kapa 3-Sicaklik Degerini Goster 4- Cikis)");
        Scanner scanner = new Scanner(System.in);
        istek = scanner.nextInt();
        bildirimGoster("Sistem islemi algiliyor...");
        Thread.sleep(2000);
        return istek;
    }

    @Override
    public void bildirimGoster(String bildirim) {
        System.out.println("*** " + bildirim + " ***");
    }

    @Override
    public void kullaniciGirisi() throws SQLException {
        Connection conn = KullaniciRepositoryPostgreSQL.getInstance().baglan();
        String kullaniciAdi;
        String kullaniciSifresi;
        Scanner scanner = new Scanner(System.in);


        bildirimGoster("Kullanici adini giriniz: ");
        kullaniciAdi = scanner.nextLine();
        System.out.println("\nGirilen kullanici adi: " + kullaniciAdi);
        scanner.nextLine();
        bildirimGoster("Kullanici sifresini giriniz: ");
        kullaniciSifresi = scanner.nextLine();
        System.out.println("\nGirilen sifre: " + kullaniciSifresi);
        scanner.nextLine();
        if(KullaniciRepositoryPostgreSQL.getInstance().kullaniciAra(conn,kullaniciAdi,kullaniciSifresi)){
            bildirimGoster("Giris basarili!");
        }
        else {
            bildirimGoster("Kullanici adi/sifre yanlis!");
            System.exit(0);
        }

    }
}
