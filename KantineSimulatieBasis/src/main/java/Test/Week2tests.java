package main.java.Test;

import main.java.*;
import org.junit.Test;

import java.math.BigDecimal;

public class Week2tests {

    Kantine kantine;

    // articles
    private static final String[] artikelNamen =
            new String[] {"Coffee", "PB sandwich", "Cheese sandwich", "Apple juice"};

    // prices
    private static BigDecimal[] artikelPrijzen = new BigDecimal[] {new BigDecimal("1.50"), new BigDecimal("2.10"), new BigDecimal("1.65"), new BigDecimal("1.65")};


    @Test
    public void opgave1()
    {
        kantine = new Kantine();
        int[] amount = {15, 15, 15, 15};
        kantine.setKantineAanbod(new KantineAanbod(artikelNamen, artikelPrijzen, amount));

        for (int i = 0; i < 5; i++) {
            kantine.loopPakSluitAan();
        }
        kantine.verwerkRijVoorKassa();

        System.out.println("Geld in Kassa: " + kantine.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kantine.getAantalArtikelen());

        kantine.resetKassa();
        System.out.println("Geld in Kassa: " + kantine.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kantine.getAantalArtikelen());
    }

    @Test
    public void opgave2()
    {
        int dagen = 7;
        KantineSimulatie_1 kantineSimulatie1 = new KantineSimulatie_1();
        kantineSimulatie1.simuleer(dagen);
    }

    @Test
    public void opgave4()
    {
        kantine = new Kantine();
        int[] amount = {15, 15, 15, 15};
        kantine.setKantineAanbod(new KantineAanbod(artikelNamen, artikelPrijzen, amount));

        for (int i = 0; i < 5; i++) {
            kantine.loopPakSluitAan();
        }
        kantine.verwerkRijVoorKassa();

        Kassa kassa = kantine.getKassa();
        System.out.println("Geld in Kassa: " + kassa.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kassa.getAantalArtikelen());

        kassa.resetKassa();
        System.out.println("Geld in Kassa: " + kassa.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kassa.getAantalArtikelen());
    }

    @Test
    public void opgave5()
    {
        kantine = new Kantine();
        int[] amount = {15, 15, 15, 15};
        kantine.setKantineAanbod(new KantineAanbod(artikelNamen, artikelPrijzen, amount));

        for (int i = 0; i < 5; i++) {
            Persoon customer = new Persoon(String.valueOf(i), "Anne Pier", "Merkus", new Datum(10, 7, 1998), 'M');
            Dienblad dienblad = new Dienblad(customer);

            String[] artikelen = {"Coffee"};
            kantine.loopPakSluitAan(dienblad, artikelen);
        }
        kantine.verwerkRijVoorKassa();

        Kassa kassa = kantine.getKassa();
        System.out.println("Geld in Kassa: " + kassa.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kassa.getAantalArtikelen());

        kassa.resetKassa();
        System.out.println("Geld in Kassa: " + kassa.getHoeveelheidGeldInKassa());
        System.out.println("Artikelen langs Kassa: " + kassa.getAantalArtikelen());
    }
}
