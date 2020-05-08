import java.sql.SQLException;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    private static MerkeziIslemBirimi instance;
    public static synchronized MerkeziIslemBirimi getInstance(){
        if(instance == null)
            instance = new MerkeziIslemBirimi();
        return instance;
    }
    @Override
    public void eyleyiciCalistir(IEyleyici eyleyici, int istek) {
        if(istek == 1) {
            double sicaklik = agArayuzuCalistir(AgArayuzu.getInstance()).sicaklikAl();
            eyleyici.sogutucuAc(sicaklik);
            agArayuzuCalistir(AgArayuzu.getInstance()).bildirimGoster("Sogutucu basarili bir sekilde calisti!");
        }
        else if(istek == 2){
            eyleyici.sogutucuKapa();
        }
        else
            return;
    }

    @Override
    public IAgArayuzu agArayuzuCalistir(IAgArayuzu agArayuzu) {
        return agArayuzu;
    }

    @Override
    public void algilayiciCalistir(ISicaklikAlgilayici algilayici) {
        double okunanSicaklik = algilayici.sicaklikOlc();
        agArayuzuCalistir(AgArayuzu.getInstance()).bildirimGoster("Okunan sicaklik degeri: "+ okunanSicaklik);
    }

    @Override
    public void mibCalistir() throws SQLException, InterruptedException {
        int istek;
        do {
            istek = agArayuzuCalistir(AgArayuzu.getInstance()).istekAl();
            if (istek == 1) {
                eyleyiciCalistir(Eyleyici.getEyleyici(), 1);
            } else if (istek == 2) {
                eyleyiciCalistir(Eyleyici.getEyleyici(), 2);
            } else if (istek == 3) {
                algilayiciCalistir(SicaklikAlgilayici.getInstance());
            } else if(istek == 4){
                agArayuzuCalistir(AgArayuzu.getInstance()).bildirimGoster("Cikis yapiliyor. Sistem kapalı duruma geciyor.");
                return;
            }
        }while(istek != 4);
    }
}
