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
public class PeliLogiikkaTest {

    Arpoja arpoja;
    PeliLogiikka peli;
    Pelaaja pelaaja;
    Pelaaja A;
    Kayttoliittyma kayttoliittyma;

    public PeliLogiikkaTest() {
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajienMaaranSyottoToimii() {
        peli.setPelaajienMaara(4);
        peli.luoPelaajat(4);
        assertEquals(peli.getPelaajienMaara(), 4);
    }

    @Test
    public void pelaajienMaaranSyottoToimii2() {
        peli.setPelaajienMaara(11);
        peli.luoPelaajat(11);
        assertEquals(peli.getPelaajienMaara(), 11);
    }

    @Test
    public void setPelaajienMaaraAsettaaMuuttujanMaaraArvon() {
        peli.setPelaajienMaara(4);
        assertEquals(peli.getPelaajienMaara(), 4);
    }

    @Test
    public void kaynnistysLuoLuoAjastimen() {
        peli.kaynnista(5000);
        assertNotNull(peli.getAjastin());
    }

    @Test
    public void kaynnistysLuoOletusMaaranPelaajia() {
        peli.kaynnista(5000);
        assertEquals(peli.getPelaajienMaara(), 5);
    }

    @Test
    public void KaikillaOllutKiekkoPalauttaaFalseAlussa() {
        peli.kaynnista(2000);
        assertEquals(peli.kaikillaOllutKiekko(), false);
    }

    @Test
    public void arpojaOnOlemassa() {
        assertNotNull(peli.getArpoja());
    }

    @Test
    public void KaikillaOllutKiekkoTrueKunTosi() {
        peli.luoPelaajat(1);
        assertEquals(peli.kaikillaOllutKiekko(), true);
    }

    @Test
    public void KunPeliOnKaynnissaPelissaOnKiekollinen() {
        peli.kaynnista(4500);
        assertNotNull(peli.getKiekollinen());
    }

    @Test
    public void VaaraSyottoKulutttaaAjastimenAikaaSekunnilla() {
        peli.kaynnista(5000);
        peli.vaaraSyotto();
        assertEquals(peli.getAjastin().getAikaInt(), 4000);
    }

    @Test
    public void pelaajaOnIdassaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnIdassa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnEtelassaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnEtelassa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnLannessaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnLannessa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnPohjoisessaVaihtaaKiekollista() {
        peli.luoPelaajat(9999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnEtelassa();
        peli.pelaajaOnEtelassa();
        peli.pelaajaOnPohjoisessa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnKoillisessaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnEtelassa();
        peli.pelaajaOnKoilisessa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnKaakossaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnKaakossa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnLounaassaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnLounaassa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }

    @Test
    public void pelaajaOnLuoteessaVaihtaaKiekollista() {
        peli.luoPelaajat(999);
        pelaaja = peli.getKiekollinen();
        peli.pelaajaOnEtelassa();
        peli.pelaajaOnLuoteessa();
        assertNotSame(pelaaja, peli.getKiekollinen());
    }
}