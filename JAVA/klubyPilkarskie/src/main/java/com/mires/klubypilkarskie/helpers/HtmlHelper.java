package com.mires.klubypilkarskie.helpers;

import com.mires.klubypilkarskie.KlubyPilkarskieApplication;
import com.mires.klubypilkarskie.objects.Klub;
import com.mires.klubypilkarskie.objects.Wypozyczenie;
import com.mires.klubypilkarskie.objects.Zawodnik;

import java.util.Date;

public class HtmlHelper {
    public static String getHtmltable() {
        KlubyPilkarskieApplication.getMysqlManager().loadKluby();
        final StringBuilder sb = new StringBuilder();

        final KlubyManager klubyManager = KlubyPilkarskieApplication.getKlubyManager();
        final WypozyczeniaManager wypozyczeniaManager = KlubyPilkarskieApplication.getWypozyczeniaManager();

        for (final Klub klub : klubyManager.getKlubs()) {
            sb.append("<h1> " + klub.getNazwa() + " </h1>");
            sb.append("<li> Miasto: " + klub.getMiasto());
            sb.append("<li> Kraj: " + klub.getKraj() + " </li>");

            sb.append("<h3> Trener </h3>");
            sb.append("<li> Imie: " + klub.getTrener().getImie());
            sb.append("<li> Nazwisko: " + klub.getTrener().getNazwisko());
            sb.append("<li> Data urodzenia: " + klub.getTrener().getDataUrodzenia() + "</li><br>");

            sb.append("<table style = 'border: 1px solid black'>");
            sb.append("<tr style = 'border: 1px solid black'>");
            sb.append("<td style = 'border: 1px solid black'> Lp. </td>");
            sb.append("<td style = 'border: 1px solid black'> Imie </td>");
            sb.append("<td style = 'border: 1px solid black'> Nazwisko </td>");
            sb.append("<td style = 'border: 1px solid black'> Data urodzenia </td>");
            sb.append("</tr>");
            int id = 1;
            for (Zawodnik zawodnik : klubyManager.getZawodnicy(klub.getId_k())) {
                if (!wypozyczeniaManager.isWypozyczony(zawodnik.getId_p())) {
                    sb.append("<tr style = 'border: 1px solid black'>");
                    sb.append("<td style = 'border: 1px solid black'> " + id + " </td>");
                    sb.append("<td style = 'border: 1px solid black'> " + zawodnik.getImie() + " </td>");
                    sb.append("<td style = 'border: 1px solid black'> " + zawodnik.getNazwisko() + " </td>");
                    sb.append("<td style = 'border: 1px solid black'> " + zawodnik.getDataUrodzenia() + " </td>");
                    sb.append("</tr>");
                    id++;
                }
            }
            sb.append("</table>");
            sb.append("<br><br>");
        }


        return sb.toString();
    }
}
