/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.awt.Graphics;

/**
 *
 * @author Leo
 */
public class Pelaaja {

    private int x;
    private int y;
    private boolean kiekko;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setKiekko(boolean kiekko) {
        this.kiekko = kiekko;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean onkoKiekkoHallussa() {
        return kiekko;
    }

    public Pelaaja(int x, int y) {
        this.x = x;
        this.y = y;
        this.kiekko = false;
    }

    public boolean ovatkotKoordinaatitVapaina(int x, int y) {
        if (this.x == x && this.y == y) {
            return false;
        } else {
            return true;
        }
    }
    public void piirra(Graphics graphics) {
        graphics.fillOval(x, y, 10, 10);
    }
}