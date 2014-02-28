package syottopeliLogiikka;

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
import syottopeliLogiikka.Kayttis.Kayttoliittyma;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * @author Leo
 */
public class ArpojaTest {

    Arpoja arpoja;
    Kayttoliittyma kayttoliittyma;
    PeliLogiikka peli;
    private int korkeus;
    private int leveys;

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
        arpoja = new Arpoja();
        kayttoliittyma = new Kayttoliittyma(peli);
        leveys = kayttoliittyma.getFrame().getWidth();
        korkeus = kayttoliittyma.getFrame().getHeight();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

//    @Test
//    public void arpojaAntaaKorkeuksiaJotkaSijaitsevatKentalla() {
//        for (int i = 0; i < 50; i++) {
//            int luku = arpoja.satunnainenKoordinaattiY();
//            assertTrue(luku < korkeus && luku > 0);  
//        }
//    }
//
//    @Test
//    public void arpojaAntaaLeveyksiaJotkaSijaitsevatKentalla() {
//        for (int i = 0; i < 50; i++) {
//            int luku = arpoja.satunnainenKoordinaattiX();
//            assertTrue(luku < leveys && luku > 0);
//        }
//    }
}
