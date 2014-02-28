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
import syottopeli.syottopeliLogiikka.AjastinMuisti;

/**
 *
 * @author Leo
 */
public class AjastinMuistiTest {

    AjastinMuisti ajastin;

    public AjastinMuistiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ajastin = new AjastinMuisti(5000);
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
    public void ajastimessaOletusarvo() {
        assertNotNull(ajastin.getAikaString());
    }
    @Test
    public void ajastimenArvoSamaKuinAsetettu() {
        ajastin.setAika(3000);
        assertEquals(ajastin.getAikaInt(), 3000);
    }
    @Test
    public void ajastimenArvoSamaKuinAsetettu2() {
        ajastin.setAika(30000);
        assertEquals(ajastin.getAikaInt(), 30000);
    }
    @Test
    public void ajanKulutusVahentaaSekunnin() {
        ajastin.kulutaAikaa();
        assertEquals(ajastin.getAikaInt(), 4000);
    }
    @Test
    public void ajanKulutusEiVahennaAlleNollan() {
        ajastin.kulutaAikaa();
        ajastin.kulutaAikaa();
        ajastin.kulutaAikaa();
        ajastin.kulutaAikaa();
        ajastin.kulutaAikaa();
        ajastin.kulutaAikaa();
        assertEquals(ajastin.getAikaInt(), 0);
    }
    
}