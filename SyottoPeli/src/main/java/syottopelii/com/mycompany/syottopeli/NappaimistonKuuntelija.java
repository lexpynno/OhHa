/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Leo
 */
public class NappaimistonKuuntelija implements KeyListener {
 
    private Component k;
    private Peli peli;
 
    public NappaimistonKuuntelija(Component k, Peli peli) {
        this.k = k;
        this.peli = peli;
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_LEFT) {

        } else if (e.getKeyCode()== KeyEvent.VK_RIGHT) {

        }else if (e.getKeyCode()== KeyEvent.VK_UP) {

        }else if (e.getKeyCode()== KeyEvent.VK_DOWN) {

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