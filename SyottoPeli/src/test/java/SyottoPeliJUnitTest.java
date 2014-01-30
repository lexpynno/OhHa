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
import syottopelii.com.mycompany.syottopeli.Pelaaja;
import syottopelii.com.mycompany.syottopeli.Peli;

/**
 *
 * @author Leo
 */
public class SyottoPeliJUnitTest {

    Peli peli;
    Pelaaja pelaaja;
    Pelaaja A;

    public SyottoPeliJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
        pelaaja = new Pelaaja(1, 2);
        A = new Pelaaja(4, 3);
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
    public void pelaajallaKiekkoToimiiKunTrue() {
        pelaaja.setKiekko(true);
        assertEquals(pelaaja.onkoKiekkoHallussa(), true);
    }

    @Test
    public void pelaajallaKiekkoToimiiKunFalse() {
        assertEquals(pelaaja.onkoKiekkoHallussa(), false);
    }

    @Test
    public void pelaajatPaallekkainTosi() {
        A.setX(1);
        A.setY(2);
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(A);
        assertEquals(peli.pelaajatPaallekkain(), true);
    }

    @Test
    public void pelaajatPaallekkainEpatosi() {
        peli.lisaaPelaaja(pelaaja);
        peli.lisaaPelaaja(A);
        assertEquals(peli.pelaajatPaallekkain(), false);
    }
}