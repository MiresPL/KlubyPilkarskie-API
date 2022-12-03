package com.mires.klubypilkarskie.helpers;

import com.google.common.collect.ImmutableSet;
import com.mires.klubypilkarskie.objects.Klub;
import com.mires.klubypilkarskie.objects.Trener;
import com.mires.klubypilkarskie.objects.Zawodnik;

import java.util.HashMap;
import java.util.Map;

public class KlubyManager {
    private Map<Integer, Klub> klubMap = new HashMap<>();

    public void addKlub(Klub klub) {
        klubMap.put(klub.getId_k(), klub);
    }

    public Klub getKlub(int id_k) {
        return klubMap.get(id_k);
    }

    public ImmutableSet<Klub> getKlubs() {
        return ImmutableSet.copyOf(klubMap.values());
    }

    public Trener getTrener(final int id_k) {
        return klubMap.get(id_k).getTrener();
    }

    public void setTrener(final int id_k, final Trener trener) {
        klubMap.get(id_k).setTrener(trener);
    }

    public ImmutableSet<Zawodnik> getZawodnicy(final int id_k) {
        return ImmutableSet.copyOf(klubMap.get(id_k).getZawodnicy().values());
    }

    public void setZawodnicy(final int id_k, final Map<Integer, Zawodnik> zawodnicy) {
        klubMap.get(id_k).setZawodnicy(zawodnicy);
    }

    public Zawodnik getZawodnik(final int id_k, final int id_p) {
        return klubMap.get(id_k).getZawodnicy().get(id_p);
    }
}
