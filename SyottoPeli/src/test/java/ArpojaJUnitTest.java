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
import syottopelii.com.mycompany.syottopeli.Arpoja;
import syottopelii.com.mycompany.syottopeli.Kayttoliittyma;
import syottopelii.com.mycompany.syottopeli.PeliLogiikka;
import syottopelii.com.mycompany.syottopeli.PelinAlustus;

/**
 *
 * @author Leo
 */
public class ArpojaJUnitTest {

    Arpoja arpoja;
    Kayttoliittyma kayttoliittyma;
    PeliLogiikka peli;
    int korkeus;
    int leveys;
    boolean testi;

    public ArpojaJUnitTest() {
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
        if (korkeus > arpoja.satunnainenKoordinaattiX()) {
            testi = true;
        } else {
            testi = false;
            assertEquals(testi, true);
        }
    }

    @Test
    public void arpojaAntaaLeveyksiaJotkaSijaitsevatKentalla() {
        if (leveys > arpoja.satunnainenKoordinaattiX()) {
            testi = true;
        } else {
            testi = false;
        }
        assertEquals(testi, true);
    }
}
