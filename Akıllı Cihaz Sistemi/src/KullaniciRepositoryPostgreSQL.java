import java.sql.*;

public class KullaniciRepositoryPostgreSQL {
    private static KullaniciRepositoryPostgreSQL instance;
    private KullaniciRepositoryPostgreSQL(){

    }
    public static synchronized KullaniciRepositoryPostgreSQL getInstance(){
        if(instance == null)
            instance = new KullaniciRepositoryPostgreSQL();
        return instance;
    }
    public Connection baglan() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KullanicilarDB",
                    "postgres", "26272xyz");
            if (conn != null) {
                return conn;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean kullaniciAra(Connection conn, String kullaniciAdi, String kullaniciSifre) throws SQLException {

        String sql1 = "SELECT \"ad\" FROM \"kullanicilarschema\".\"Kullanicilar\" WHERE ('" + kullaniciAdi + "')" + "= \"ad\" ";
        String sql2 = "SELECT \"sifre\" FROM \"kullanicilarschema\".\"Kullanicilar\" WHERE ('" + kullaniciSifre + "')" + "= \"sifre\" ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql1);
        baglan();
        stmt = conn.createStatement();
        ResultSet rs2= stmt.executeQuery(sql2);
        conn.close();
        if(rs.next()&& rs2.next())
            return true;
        rs.close();
        stmt.close();
        return false;
    }
}
