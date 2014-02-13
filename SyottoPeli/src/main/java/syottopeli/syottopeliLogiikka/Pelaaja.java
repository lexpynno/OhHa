/*
 * 
 */
package syottopeli.syottopeliLogiikka;

import java.awt.Graphics;

/**
 *
 *
 *
 * Pelaaja luo koordinaatistoon arvojen x ja y perusteella pallon "pelaajan",
 * jolla on totuusarvo kiekko.
 */
public class Pelaaja {

    private Ajastin ajastin;
    private int x;
    private int y;
    private boolean kiekko;
    private boolean kiekkoOllutHallussa;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * muuttaa totuusarvoa kiekko kyseisella pelaajalla
     *
     * @param kiekko Kayttajan antama arvo
     *
     */
    public void setKiekko(boolean kiekko) {
        if (kiekko == true) {
            kiekkoOllutHallussa = true;
        }
        this.kiekko = kiekko;
    }
    public boolean OnkoKiekkoOllutHallussa() {
        return this.OnkoKiekkoOllutHallussa();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * kertoo arvolla true jos kyseisella pelaajalla on kiekko hallussaan
     *
     * @return boolean kiekko
     */
    public boolean onkoKiekkoHallussa() {

        return kiekko;
    }

    /**
     * luo pelaajan koordinaateilla x ja y
     */
    public Pelaaja(int x, int y) {
        this.kiekkoOllutHallussa = false;
        this.x = x;
        this.y = y;
        this.kiekko = false;
        ajastin = new Ajastin();
    }

    /**
     * kertoo ovatko kyseiset koordinaatit vapaina pelaajista
     *
     * @param x ja
     * @param y
     *
     * @return totuusarvo true jos koordinaatit kayttamattomia
     */
    public boolean ovatkotKoordinaatitVapaina(int x, int y) {
        int absX = Math.abs(this.x - x);
        int absY = Math.abs(this.y - y);
        if (absX < 10 && absY < 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * piirtaa pallon pelaajan koordinaatteihin ja viela lisaksi kaaren pallon
     * ymparille mikali pelaajalla on kiekko hallussaan
     */
    public void piirra(Graphics graphics) {

        if (onkoKiekkoHallussa()) {
            graphics.fillOval(x, y, 10, 10);
            graphics.drawOval(x - 10, y - 10, 30, 30);
        }
        graphics.fillOval(x, y, 10, 10);
    }
}