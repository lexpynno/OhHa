/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

/**
 *
 * Luo kellon kayttajan toiveiden mukaan, joka saataa vaikeustasoa ja pelin nopeutta.
 */
public class Ajastin {

    private int aika;

    public Ajastin() {
        this.aika = 2000;
    }

    public void asetaAika(int i) {
        this.aika = i;
    }

    public int getAika() {
        return aika;
    }
}