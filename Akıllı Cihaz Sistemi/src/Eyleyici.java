public class Eyleyici implements IEyleyici {

    private static Eyleyici instance;
    private Eyleyici(){
    }
    public static synchronized Eyleyici getEyleyici(){
        if(instance == null)
            instance = new Eyleyici();
        return instance;
    }
    @Override
    public void sogutucuAc(double sicaklikDegeri) {
        SicaklikAlgilayici.getInstance().setSicaklik(sicaklikDegeri);
    }

    @Override
    public void sogutucuKapa() {
        AgArayuzu.getInstance().bildirimGoster("Sogutucu Kapandi. Oda sicakligi normal degerine donuyor");
    }
}
