/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import syottopelii.com.mycompany.syottopeli.PeliLogiikka;

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
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            peli.syotaItaan();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
            peli.syotaEtelaan();
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
        } else if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
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