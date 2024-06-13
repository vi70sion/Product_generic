package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

//        Klasės struktūra:
//        Sukurkite bazinę klasę Produktas, kuri turi šiuos laukus: id (unikalus produkto identifikatorius, tipas – int),
//        pavadinimas (produkto pavadinimas, tipas – String), ir kaina (produkto kaina, tipas – double).
//        Išplėskite klasę Produktas, sukuriant dvi išvestines klases: Maistas (papildomas laukas – galiojimoData,
//        tipas – LocalDate) ir BuitineTechnika (papildomi laukai – garantija metų skaičius, tipas – int, ir
//        energijosKlase, tipas – String).
//        Sąrašų valdymas:
//        Sukurkite klasę ProduktuKatalogas<T extends Produktas>, kuri turėtų privatų sąrašą produktais, saugantį produktus.
//                ProduktuKatalogas klasėje implementuokite šiuos metodus:
//        pridetiProdukta(T produktas): metodas, leidžiantis pridėti naują produktą į katalogą.
//        pašalintiProdukta(int id): metodas, leidžiantis pašalinti produktą pagal nurodytą ID.
//        gautiProduktusPagalKaina(double minKaina, double maxKaina): metodas, grąžinantis sąrašą produktų, kurių kaina yra nurodytame diapazone.
//        spausdintiVisusProduktus(): metodas, atspausdinantis visus katalogo produktus.

        ProduktuKatalogas katalogas = new ProduktuKatalogas<>();
        katalogas.pridetiProdukta(new BuitineTechnika(10, "Televizorius",399.90,24,"A+"));
        katalogas.pridetiProdukta(new BuitineTechnika(11, "Šaldytuvas",599.90,36,"B"));
        katalogas.pridetiProdukta(new Maistas(12, "Sausainiai",5.99, LocalDate.parse("2024-12-31")));
        katalogas.pridetiProdukta(new Maistas(13, "Duona",0.99, LocalDate.parse("2024-06-30")));

        katalogas.spausdintiVisusProduktus();
        System.out.println("-".repeat(50));

        katalogas.pasalintiProdukta(12);
        katalogas.spausdintiVisusProduktus();
        System.out.println("-".repeat(50));

        katalogas.pridetiProdukta(new Maistas(12, "Sausainiai",5.99, LocalDate.parse("2024-12-31")));
        System.out.println(katalogas.gautiProduktusPagalKaina(0.0, 100.0));
        System.out.println("-".repeat(50));

//        1. Užduotis – Produkto ieškojimas pagal pavadinimą
//        Sukurkite metodą gautiProduktaPagalPavadinima(String pavadinimas), kuris grąžina pirmąjį rastą produktą,
//        kurio pavadinimas atitinka nurodytą reikšmę. Jei tokio produkto kataloge nėra, metodas turėtų grąžinti null.
//        2. Užduotis – Produktų rūšiavimas
//        Pridėkite funkcionalumą, leidžiantį rūšiuoti produktus pagal kainą ar pavadinimą. Sukurkite du metodus
//        rusiuotiPagalKaina() ir rusiuotiPagalPavadinima(), kurie atitinkamai rūšiuoja produktus ProduktuKatalogas sąraše.
//        3. Užduotis – Produktų filtravimas pagal galiojimo datą
//        Maistas klasėje pridėkite metodą, kuris leidžia gauti visus produktus, kurių galiojimo data yra artimesnė nei
//        nurodytas laikotarpis (pvz., artėjantys pasibaigti per 7 dienas). Metodas turėtų būti
//        gautiProduktusArtiGaliojimoPabaigos(int dienos).
//
//        4. Užduotis – Duomenų išsaugojimas į failą
//        Įgyvendinkite funkcionalumą, kuris leidžia eksportuoti visų produktų sąrašą į tekstinius failus.
//        Sukurkite metodus issaugotiProduktus(String failoVardas), kuris įrašytų visus produktų katalogo įrašus į failą.

        System.out.println(katalogas.gautiProduktaPagalPavadinima("Šald"));
        System.out.println(katalogas.gautiProduktaPagalPavadinima("aaa"));
        System.out.println("-".repeat(50));

        katalogas.pridetiProdukta(new Maistas(14, "Kava",8.99, LocalDate.parse("2024-12-31")));
        katalogas.rusiuotiPagalKaina();
        katalogas.spausdintiVisusProduktus();
        System.out.println("-".repeat(50));

        katalogas.rusiuotiPagalPavadinima();
        katalogas.spausdintiVisusProduktus();
        System.out.println("-".repeat(50));

        System.out.println(katalogas.gautiProduktusArtiGaliojimoPabaigos(30));
        System.out.println(katalogas.gautiProduktusArtiGaliojimoPabaigos(300));
        System.out.println("-".repeat(50));

    }
}