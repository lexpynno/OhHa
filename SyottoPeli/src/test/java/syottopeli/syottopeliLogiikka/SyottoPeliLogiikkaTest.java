package syottopeli.syottopeliLogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Frame;
import java.awt.image.ImageObserver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import syottopeli.syottopeliLogiikka.Arpoja;
import syottopeli.syottopeliLogiikka.Kayttis.Kayttoliittyma;
import syottopeli.syottopeliLogiikka.Pelaaja;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * @author Leo
 */
public class SyottoPeliLogiikkaTest {

    Arpoja arpoja;
    PeliLogiikka peli;
    Pelaaja pelaaja;
    Pelaaja A;
    Kayttoliittyma kayttoliittyma;

    public SyottoPeliLogiikkaTest() {
    }

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
    public void pelaajienMaaranSyottoToimii() {
        peli.luoPelaajat(4);
        assertEquals(peli.getPelaajat(), 4);
    }

    @Test
    public void pelaajienMaaranSyottoToimii2() {
        peli.luoPelaajat(11);
        assertEquals(peli.getPelaajat(), 11);
    }

    @Test
    public void kaynnistysKaynnistaaPelin() {
        peli.kaynnista();
        assertEquals(peli.getKaynnissa(), true);
    }

    @Test
    public void kaynnissaFalseAlussa() {
        assertEquals(peli.getKaynnissa(), false);
    }

    @Test
    public void keskeytysAsettaaKaynnistysarvonFalse() {
        peli.kaynnista();
        peli.keskeyta();
        assertEquals(peli.getKaynnissa(), false);
    }

    @Test
    public void setPelaajienMaaraAsettaaMuuttujanMaaraArvon() {
        peli.setPelaajienMaara(4);
        assertEquals(peli.getMaara(), 4);
    }

    @Test
    public void pelaajiaPaallekkain() {
        peli.luoPelaajat(1000);
        assertTrue(peli.pelaajatPaallekkain());
    }
}