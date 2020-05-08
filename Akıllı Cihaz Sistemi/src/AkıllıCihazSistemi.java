import java.sql.SQLException;

public class AkıllıCihazSistemi {
    private static AkıllıCihazSistemi instance;
    public static synchronized AkıllıCihazSistemi getInstance(){
        if(instance == null)
            instance = new AkıllıCihazSistemi();
        return instance;
    }
    public void akilliCihazSistemiCalistir() throws SQLException, InterruptedException {
        MerkeziIslemBirimi.getInstance().mibCalistir();
    }
}
