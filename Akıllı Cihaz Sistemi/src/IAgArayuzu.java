import java.sql.SQLException;

public interface IAgArayuzu {
    public int istekAl() throws SQLException, InterruptedException;
    public void bildirimGoster(String bildirim);
    public void kullaniciGirisi() throws SQLException;
    public double sicaklikAl();
}
