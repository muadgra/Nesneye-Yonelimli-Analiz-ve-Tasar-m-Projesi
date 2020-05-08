import java.sql.SQLException;

public interface IMerkeziIslemBirimi {
    public void eyleyiciCalistir(IEyleyici eyleyici, int istek);
    public IAgArayuzu agArayuzuCalistir(IAgArayuzu agArayuzu);
    public void algilayiciCalistir(ISicaklikAlgilayici algilayici);
    public void mibCalistir() throws SQLException, InterruptedException;
}
