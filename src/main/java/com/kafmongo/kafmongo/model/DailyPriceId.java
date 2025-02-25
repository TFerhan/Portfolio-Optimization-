package com.kafmongo.kafmongo.model;
import java.io.Serializable;
import java.time.LocalDate;

public class DailyPriceId implements Serializable {
    private String libelleFR;
    private LocalDate created;

    // Constructeurs, getters, setters et equals/hashCode

    public DailyPriceId() {
    }

    public DailyPriceId(String libelleFR, LocalDate created) {
        this.libelleFR = libelleFR;
        this.created = created;
    }
}
