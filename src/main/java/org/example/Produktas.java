package org.example;

public class Produktas {
    private int id;
    private String pavadinimas;
    private double kaina;

    public Produktas(int id, String pavadinimas, double kaina) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
    }

    public int getId() { return id; }
    public double getKaina() { return kaina; }
    public String getPavadinimas() { return pavadinimas; }

    @Override
    public String toString(){
        return "ID: " + id + ", pavadinimas: " + pavadinimas + ", kaina: " + kaina;
    }
}
