package syottopeli.syottopeliLogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import syottopeli.syottopeliLogiikka.Arpoja;
import syottopeli.syottopeliLogiikka.Kayttis.Kayttoliittyma;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * @author Leo
 */
public class ArpojaTest {

    Arpoja arpoja;
    Kayttoliittyma kayttoliittyma;
    PeliLogiikka peli;
    int korkeus;
    int leveys;
    boolean testi;

    public ArpojaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new PeliLogiikka();
        kayttoliittyma = new Kayttoliittyma(peli);
        arpoja = new Arpoja();
        leveys = kayttoliittyma.getFrame().getWidth();
        korkeus = kayttoliittyma.getFrame().getHeight();
        testi = true;
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void arpojaAntaaKorkeuksiaJotkaSijaitsevatKentalla() {
        if (600 > arpoja.satunnainenKoordinaattiX()) {
            testi = true;
        } else {
            testi = false;
            assertTrue(testi);
        }
    }

    @Test
    public void arpojaAntaaLeveyksiaJotkaSijaitsevatKentalla() {
        if (800 > arpoja.satunnainenKoordinaattiX()) {
            testi = true;
        } else {
            testi = false;
        }
        assertTrue(testi);
    }
}
