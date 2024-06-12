package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProduktuKatalogas <T extends Produktas>{

    private List<T> produktai;

    public ProduktuKatalogas() {
        produktai = new ArrayList<>();
    }

    public void pridetiProdukta(T produktas){
        produktai.add(produktas);
    }

    public void pasalintiProdukta(int id){
        for(T item: produktai)
            if(item.getId() == id) produktai.remove(item);
    }

    public List<T> gautiProduktusPagalKaina(double minKaina, double maxKaina){
        List<T> atrinkta = new ArrayList<>();
        for(T item: produktai)
            if(item.getKaina() >= minKaina && item.getKaina() <= maxKaina) atrinkta.add(item);
        return atrinkta;
    }

    public void spausdintiVisusProduktus(){
        for(T item: produktai)
            System.out.println(item);
    }

    public T gautiProduktaPagalPavadinima(String pavadinimas){
        for(T item: produktai)
            if(item.getPavadinimas().contains(pavadinimas)) return item;
        return null;
    }

    public void rusiuotiPagalKaina(){
        produktai.sort(Comparator.comparingDouble(Produktas::getKaina));
    }

    public void rusiuotiPagalPavadinima(){
        produktai.sort(Comparator.comparing(Produktas::getPavadinimas));
    }

    public List<T> gautiProduktusArtiGaliojimoPabaigos(int dienos){
        List<T> tempList = new ArrayList<>();
        for(T item: produktai){
            if(item instanceof Maistas)
                if(!((Maistas) item).getGaliojimoData().isBefore(LocalDate.now()) &&
                        !((Maistas) item).getGaliojimoData().isAfter(LocalDate.now().plusDays(dienos)))
                    tempList.add(item);
        }
        return tempList;
    }

}
