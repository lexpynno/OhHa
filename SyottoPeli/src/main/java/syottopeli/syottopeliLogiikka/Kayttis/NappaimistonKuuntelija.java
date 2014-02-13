/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka.Kayttis;

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
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
            peli.pelaajaOnKoilisessa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            peli.pelaajaOnIdassa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
            peli.pelaajaOnKaakossa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            peli.pelaajaOnEtelassa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
            peli.pelaajaOnLounaassa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            peli.pelaajaOnLannessa();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
            peli.pelaajaOnLuoteessa();
        }
        k.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}