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
import syottopelii.com.mycompany.syottopeli.Kaukalo;
import syottopelii.com.mycompany.syottopeli.Pelaaja;
import syottopelii.com.mycompany.syottopeli.Peli;

/**
 *
 * @author Leo
 */
public class SyottoPeliJUnitTest {

    Peli syottoPeli;
    Pelaaja pelaaja;
    Kaukalo kaukalo;
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
        syottoPeli = new Peli();
        kaukalo = new Kaukalo();
        pelaaja = new Pelaaja(1, 2);
        A = new Pelaaja(4, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajienMaaranSyottoToimii() {
        kaukalo.luoPelaajat(4);
        assertEquals(kaukalo.getPelaajat(), 4);
    }

    @Test
    public void pelaajienMaaranSyottoToimii2() {
        kaukalo.luoPelaajat(11);
        assertEquals(kaukalo.getPelaajat(), 11);
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
        kaukalo.lisaaPelaaja(pelaaja);
        kaukalo.lisaaPelaaja(A);
        assertEquals(kaukalo.pelaajatPaallekkain(), true);
    }

    @Test
    public void pelaajatPaallekkainEpatosi() {
        kaukalo.lisaaPelaaja(pelaaja);
        kaukalo.lisaaPelaaja(A);
        assertEquals(kaukalo.pelaajatPaallekkain(), true);
    }

    @Test
    public void pelaajienLuontiOnnistuuJarkevillaLuvuilla() {
        kaukalo.luoPelaajat(1000);
    }
}