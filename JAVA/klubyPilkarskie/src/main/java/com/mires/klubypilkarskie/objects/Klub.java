package com.mires.klubypilkarskie.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Klub {
    private int id_k;
    private String nazwa;
    private String miasto;
    private String kraj;
    private Trener trener;
    private Map<Integer, Zawodnik> zawodnicy;
}
