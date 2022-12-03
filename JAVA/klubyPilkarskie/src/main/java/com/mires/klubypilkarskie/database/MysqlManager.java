package com.mires.klubypilkarskie.database;


import com.mires.klubypilkarskie.KlubyPilkarskieApplication;
import com.mires.klubypilkarskie.objects.Klub;
import com.mires.klubypilkarskie.objects.Trener;
import com.mires.klubypilkarskie.objects.Wypozyczenie;
import com.mires.klubypilkarskie.objects.Zawodnik;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MysqlManager {

    private ConnectionPoolManager pool;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;

    public MysqlManager() throws SQLException {
        this.pool = new ConnectionPoolManager();
    }

    public String getClubs() {
        final JSONObject json = new JSONObject();
        try {
            con = pool.getConnection();
            ps = con.prepareStatement("SELECT * FROM kluby");
            rs = ps.executeQuery();
            int idKlubu = 0;
            while (rs.next()) {
                final JSONObject klub = new JSONObject();
                klub.put("Miejscowosc", rs.getString("Miasto"));
                klub.put("Kraj", rs.getString("Kraj"));
                idKlubu = rs.getInt("Id_k");
                PreparedStatement ps2 = con.prepareStatement("SELECT * FROM Trener WHERE Id_k = ?");
                ps2.setInt(1, idKlubu);
                ResultSet rs2 = ps2.executeQuery();
                final JSONObject trener = new JSONObject();
                if (rs2.next()) {
                    trener.put("Imie", rs2.getString("Imie"));
                    trener.put("Nazwisko", rs2.getString("Nazwisko"));
                    trener.put("Rok_urodzenia", rs2.getString("Rok_urodzenia"));
                    klub.put("Trener", trener);
                }

                ps2 = con.prepareStatement("SELECT * FROM Pilkarze WHERE Id_k = ?");
                ps2.setInt(1, idKlubu);
                rs2 = ps2.executeQuery();
                final JSONObject pilkarze = new JSONObject();
                int i = 1;
                while (rs2.next()) {
                    final JSONObject pilkarz = new JSONObject();
                    pilkarz.put("Imie", rs2.getString("Imie"));
                    pilkarz.put("Nazwisko", rs2.getString("Nazwisko"));
                    pilkarz.put("Rok_urodzenia", rs2.getString("Rok_urodzenia"));
                    pilkarze.put(String.valueOf(i), pilkarz);
                    i++;
                }
                klub.put("Pilkarze", pilkarze);
                json.put(rs.getString("Nazwa"), klub);
            }
            pool.close(con, ps, rs);
            return json.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            pool.close(con, ps, rs);
            return new JSONObject().toString();
        }
    }

    public void loadKluby() {
        KlubyPilkarskieApplication.getWypozyczeniaManager().loadWypozyczenia();
        try {
            con = pool.getConnection();
            ps = con.prepareStatement("SELECT * FROM kluby");
            rs = ps.executeQuery();
            while (rs.next()) {
                int idKlubu = rs.getInt("Id_k");
                PreparedStatement ps2 = con.prepareStatement("SELECT * FROM Trener WHERE Id_k = ?");
                ps2.setInt(1, idKlubu);
                ResultSet rs2 = ps2.executeQuery();
                Trener trener = null;
                if (rs2.next()) {
                    trener = new Trener(rs2.getString("Imie"), rs2.getString("Nazwisko"), rs2.getString("Rok_urodzenia"), idKlubu);
                }
                ps2 = con.prepareStatement("SELECT * FROM Pilkarze WHERE Id_k = ?");
                ps2.setInt(1, idKlubu);
                rs2 = ps2.executeQuery();
                final Map<Integer, Zawodnik> zawodnikMap = new ConcurrentHashMap<>();
                while (rs2.next()) {
                    final Zawodnik zawodnik = new Zawodnik(rs2.getInt("Id_p"), rs2.getString("Imie"), rs2.getString("Nazwisko"), rs2.getString("Rok_urodzenia"), rs2.getInt("Id_k"));
                    zawodnikMap.put(zawodnik.getId_p(), zawodnik);
                }
                KlubyPilkarskieApplication.getKlubyManager().addKlub(new Klub(idKlubu, rs.getString("Nazwa"), rs.getString("Miasto"), rs.getString("Kraj"), trener, zawodnikMap));
             }
            pool.close(con, ps, rs);
        } catch (final SQLException e) {
            e.printStackTrace();
            pool.close(con, ps, rs);
        }
    }

    public Map<Integer, Wypozyczenie> loadWypozyczenia() {
        final Map<Integer, Wypozyczenie> wypozyczenia = new HashMap<>();
        try {
            con = pool.getConnection();
            ps = con.prepareStatement("SELECT * FROM wypozyczenia");
            rs = ps.executeQuery();
            while (rs.next()) {
                wypozyczenia.put(rs.getInt("Id_w"), new Wypozyczenie(rs.getInt("id_k"), rs.getInt("id_p"), new Date(rs.getDate("Do_kiedy").getTime())));
            }
            pool.close(con, ps, rs);
            return wypozyczenia;
        } catch (final SQLException e) {
            e.printStackTrace();
            pool.close(con, ps, rs);
            return wypozyczenia;
        }
    }


}
