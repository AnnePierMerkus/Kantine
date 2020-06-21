package main.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Iterator;

@Entity
public class Factuur implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime datum;

    private BigDecimal korting;

    private BigDecimal totaal;

    public Factuur()
    {
        totaal = BigDecimal.ZERO;
        korting = BigDecimal.ZERO;
    }

    public Factuur(Dienblad klant, LocalDateTime datum)
    {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     * Verwerk artikelen en pas kortingen toe.
     *
     * Zet het totaal te betalen bedrag en het
     * totaal aan ontvangen kortingen.
     *
     * @param klant
     */
    private void verwerkBestelling(Dienblad klant){
        totaal = BigDecimal.ZERO;
        BigDecimal kortingTotaal = BigDecimal.ZERO;

        Iterator<Artikel> it = klant.getArtikelenIter();
        while (it.hasNext()) {
            Artikel a = it.next();
            if (a.getKorting().doubleValue() > 0)
            {
                kortingTotaal = kortingTotaal.add(a.getPrijs().subtract(a.getKorting()));
            }
            else {
                totaal = totaal.add(a.getPrijs());
            }
        }

        Persoon persoon = klant.getKlant();

        if (persoon instanceof KortingskaartHouder)
        {
            KortingskaartHouder kaartHouder = (KortingskaartHouder) persoon;
            BigDecimal kortingKaart = totaal.divide(Kassa.ONE_HUNDRED, 2, RoundingMode.DOWN).multiply(BigDecimal.valueOf(kaartHouder.geefKortingsPercentage()));
            kortingKaart = kaartHouder.heeftMaximum() ? kortingKaart.min(BigDecimal.valueOf(kaartHouder.geefMaximum())) : kortingKaart;

            korting = korting.add(kortingKaart);
        }

        korting = korting.add(kortingTotaal);
        totaal = totaal.add(korting);
    }

    /**
     * @return het totaalbedrag
     */
    public BigDecimal getTotaal() {
        return totaal;
    }

    /**
     * @return de toegepaste korting
     */
    public BigDecimal getKorting() {
        return korting;
    }

    /**
     * @return een printbaar bonnetje
     */
    @Override
    public String toString() {
        return "Factuur{" +
                "id=" + id +
                ", datum=" + datum +
                ", korting=" + korting +
                ", totaal=" + totaal +
                '}';
    }
}
