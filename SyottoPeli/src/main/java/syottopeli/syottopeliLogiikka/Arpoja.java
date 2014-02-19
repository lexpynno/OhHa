/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

import java.util.Random;

/**
 *
 * Arpoja antaa metodiensa avulla satunnaislukuja koordinaatistoon.
 */
public class Arpoja {

    private Random random;

    public Arpoja() {
        this.random = new Random();
    }

    /**
     * palauttaa koordinatin valilta 30 - 530
     */
    public int satunnainenKoordinaattiX() {
        return random.nextInt(500) + 30;
    }

    /**
     * palauttaa koordinaatin valilta 50 - 680
     */
    public int satunnainenKoordinaattiY() {
        return random.nextInt(630) + 50;
    }
}
