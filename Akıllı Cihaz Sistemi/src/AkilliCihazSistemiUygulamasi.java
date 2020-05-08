import java.sql.SQLException;

public class AkilliCihazSistemiUygulamasi {
    public static void main(String[] args) throws SQLException, InterruptedException {
        AkıllıCihazSistemi.getInstance().akilliCihazSistemiCalistir();
    }
}
