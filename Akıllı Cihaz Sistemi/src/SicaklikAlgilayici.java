import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private static SicaklikAlgilayici instance;
    private SicaklikAlgilayici(){
        Random random = new Random();
        //Baslangic degeri oda sicakligidir.
        this.sicaklik = random.nextInt(50);
    }
    public static synchronized SicaklikAlgilayici getInstance(){
        if(instance == null)
            instance = new SicaklikAlgilayici();
        return instance;
    }

    public void setSicaklik(double sicaklik) {
        this.sicaklik = sicaklik;
    }

    private double sicaklik;
    @Override
    public double sicaklikOlc() {
        return this.sicaklik;
    }
}
