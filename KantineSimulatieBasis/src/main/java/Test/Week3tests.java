package main.java.Test;

import main.java.Administratie;
import org.junit.Test;

import java.util.Arrays;

public class Week3tests {

    @Test
    public void opgave2()
    {
        System.out.println("berekenGemiddeldAantal: " + Administratie.berekenGemiddeledAantal(new int[] {45, 56, 34, 39, 40, 31}));
        System.out.println("berekenGemiddeldeOmzet: " + Administratie.berekenGemiddeldeOmzet(new double[] {567.70, 498.25, 458.90}));
        System.out.println("berekenGemiddeldOmzet: " + Arrays.toString(Administratie.berekenDagelijkseOmzet(new double[]{321.35, 450.50, 210.45, 190.85, 193.25,
                159.90, 214.25, 220.90, 201.90, 242.70, 260.35})));
    }
}
