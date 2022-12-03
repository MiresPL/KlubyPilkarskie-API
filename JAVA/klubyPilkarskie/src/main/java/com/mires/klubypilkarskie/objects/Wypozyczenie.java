package com.mires.klubypilkarskie.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Wypozyczenie {
    private int id_k;
    private int id_p;
    private Date do_kiedy;
}
