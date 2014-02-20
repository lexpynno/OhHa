/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import syottopeli.syottopeliLogiikka.PeliLogiikka;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Valittaa kayttajan toiminnot eteenpain saantojen vastaisella tavalla.
 */
public class NappaimistonKuuntelija implements KeyListener {

    private Component k;
    private PeliLogiikka peli;

    public NappaimistonKuuntelija(Component k, PeliLogiikka peli) {
        this.k = k;
        this.peli = peli;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            peli.pelaajaOnPohjoisessa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            peli.pelaajaOnKoilisessa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            peli.pelaajaOnIdassa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            peli.pelaajaOnKaakossa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            peli.pelaajaOnEtelassa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            peli.pelaajaOnLounaassa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            peli.pelaajaOnLannessa();
            peli.getAjastin().kaynnisty();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            peli.pelaajaOnLuoteessa();
            peli.getAjastin().kaynnisty();
        }
        if (peli.kaikillaOllutKiekko() == true) {
            k.setBackground(Color.yellow);
        }

        k.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
