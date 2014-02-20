/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * Luo kellon kayttajan toiveiden mukaan, joka saataa vaikeustasoa ja pelin
 * nopeutta.
 */
public class Ajastin extends Timer {

    private int aika;

    public Ajastin(ActionListener al) {
        super(2000, al);
        aika = 2000;
        super.setDelay(200);
        super.setRepeats(true);
        super.start();
    }

    /**
     *
     * @return
     */
    public void kaynnisty() {
        super.restart();
    }

    public void pysahdy() {
        super.stop();
    }

    public void uudelleenKaynnistys() {
        super.restart();
    }

    public void asetaAika(int i) {
        super.setDelay(i);
        aika = i;
    }

    public String getAika() {
        return "" + aika;
    }

    public int getAikaInt() {
        return aika;
    }

    public void ajanKulutus() {
        aika -= 200;
        if (aika < 0) {
        }
    } 

//    public void Piirra(Graphics g, int x, int y) {
//        g.fillRect(x, y - 30, 5 + aika, 20);
//    }
}
