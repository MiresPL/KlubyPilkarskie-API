package com.mires.klubypilkarskie.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trener {
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private int id_k;
}
