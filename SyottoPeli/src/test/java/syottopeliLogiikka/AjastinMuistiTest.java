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
import syottopeli.syottopeliLogiikka.Ajastin;

/**
 *
 * @author Leo
 */
public class AjastinTest {

    Ajastin ajastin;

    public AjastinTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
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
        assertNotNull(ajastin.getAika());
    }

    public void ajastimenArvoSamaKuinAsetettu() {
        ajastin.asetaAika(3000);
        assertEquals(ajastin.getAika(), 3000);
    }

    public void ajastimenArvoSamaKuinAsetettu2() {
        ajastin.asetaAika(30000);
        assertEquals(ajastin.getAika(), 30000);
    }
}