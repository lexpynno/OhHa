package syottopeli.syottopeliLogiikka;

import syottopeli.syottopeliLogiikka.Kayttis.PelinAlustus;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Kaynnistaa kaskysarjan, joka johtaa pelin kaynnistymiseen.
 *
 */
public class Paaohjelma {

    public static void main(String[] args) {
        PelinAlustus alustus = new PelinAlustus();
        SwingUtilities.invokeLater(alustus);
    }
}
