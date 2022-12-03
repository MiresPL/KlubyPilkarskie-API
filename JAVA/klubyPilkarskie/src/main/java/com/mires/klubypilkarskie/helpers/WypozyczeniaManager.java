package com.mires.klubypilkarskie.helpers;

import com.mires.klubypilkarskie.KlubyPilkarskieApplication;
import com.mires.klubypilkarskie.objects.Wypozyczenie;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WypozyczeniaManager {
    private Map<Integer, Wypozyczenie> wypozyczenieMap = new HashMap<>();

    public void loadWypozyczenia() {
        wypozyczenieMap = KlubyPilkarskieApplication.getMysqlManager().loadWypozyczenia();
    }

    public boolean isWypozyczony(final int id_p) {
        for (Wypozyczenie wypozyczenie : wypozyczenieMap.values()) {
            if (wypozyczenie.getId_p() == id_p) {
                System.out.println(wypozyczenie.getDo_kiedy());
                System.out.println(new Date());
                System.out.println(new Date().before(wypozyczenie.getDo_kiedy()));
                System.out.println("----------------------");
                if (new Date().before(wypozyczenie.getDo_kiedy())) {
                    return true;
                }
            }
        }
        return false;
    }
}
