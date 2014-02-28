/*
 * 
 */
package syottopeli.syottopeliLogiikka;

import java.awt.Graphics;

/**
 *
 * Pelaaja luo koordinaatistoon arvojen x ja y perusteella pallon "pelaajan",
 * jolla on totuusarvo kiekko.
 */
public class Pelaaja {

    private int x;
    private int y;
    private boolean kiekko;
    private boolean kiekkoOllutHallussa;

    /**
     * luo pelaajan koordinaateilla x ja y
     */
    public Pelaaja(int x, int y) {
        this.kiekkoOllutHallussa = false;
        this.x = x;
        this.y = y;
        this.kiekko = false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * muuttaa totuusarvoa kiekko kyseisella pelaajalla
     *
     * @param kiekko
     *
     */
    public void setKiekko(boolean kiekko) {
        if (kiekko == true) {
            kiekkoOllutHallussa = true;
        }
        this.kiekko = kiekko;
    }

    /**
     * Palauttaa true, jos pelaajalla on jossain pelin vaiheessa ollut kiekko
     * hallussaan. Muuten false.
     *
     * @return kiekkoOllutHallussa
     */
    public boolean OnkoKiekkoOllutHallussa() {
        return this.kiekkoOllutHallussa;
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