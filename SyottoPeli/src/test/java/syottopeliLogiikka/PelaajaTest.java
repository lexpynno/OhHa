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
import syottopeli.syottopeliLogiikka.Pelaaja;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * @author Leo
 */
public class PelaajaTest {

    Arpoja arpoja;
    PeliLogiikka peli;
    Pelaaja pelaaja;
    Pelaaja A;
    Kayttoliittyma kayttoliittyma;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new Arpoja();
        peli = new PeliLogiikka();
        pelaaja = new Pelaaja(1, 2);
        A = new Pelaaja(40, 30);
        kayttoliittyma = new Kayttoliittyma(peli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajallaKiekkoMetodiToimiiKunTrue() {
        pelaaja.setKiekko(true);
        assertEquals(pelaaja.onkoKiekkoHallussa(), true);
    }

    @Test
    public void pelaajallaKiekkoMetodiToimiiKunFalse() {
        assertEquals(pelaaja.onkoKiekkoHallussa(), false);
    }

    @Test
    public void pelaajatOikeissaKoordinaateissa() {
        assertEquals(pelaaja.getX(), 1);
        assertEquals(pelaaja.getY(), 2);
    }
    @Test
    public void LuokkaMuistaaKiekonHallussaPidon() {
        pelaaja.setKiekko(true);
        pelaaja.setKiekko(false);
        assertEquals(pelaaja.OnkoKiekkoOllutHallussa(), true);
    }
    @Test
    public void kiekkoHallussaFalseAluksi() {
        assertEquals(pelaaja.OnkoKiekkoOllutHallussa(), false);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}