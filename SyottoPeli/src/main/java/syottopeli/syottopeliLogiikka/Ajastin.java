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
        super.setDelay(200);
        super.setRepeats(true);
    }

    /**
     *
     * @return
     */
    public void AjastinKaynnisty() {
        super.start();
    }

    public void AjastinPysahdy() {
        super.stop();
    }

    public void uudelleenKaynnistys() {
        aika = 0;
    }

    public void asetaAika(int i) {
        super.setDelay(i);
    }

    public int getAika() {
        return aika;
    }

    public void ajanKulutus() {
        aika -= 200;
        if (aika < 0) {
        }
    }

    public void setAika(int i) {
        aika = i;
    }

    public void Piirra(Graphics g, int x, int y) {

        g.fillRect(x, y - 30, 5 - aika, 20);

    }

    private void piirraHavio(Graphics g) {
        g.drawLine(aika, aika, 99, 99);
    }
}