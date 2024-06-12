package org.example;

import java.time.LocalDate;
import java.util.List;

public class Maistas extends Produktas{

    private LocalDate galiojimoData;
    public Maistas(int id, String pavadinimas, double kaina, LocalDate galiojimoData) {
        super(id, pavadinimas, kaina);
        this.galiojimoData = galiojimoData;
    }

    public LocalDate getGaliojimoData() { return galiojimoData; }

    @Override
    public String toString(){
        return super.toString() + ", galiojimo data: " + galiojimoData;
    }


}
