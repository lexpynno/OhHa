/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import syottopeli.syottopeliLogiikka.PeliLogiikka;
import syottopeli.syottopeliLogiikka.PeliLogiikka;
import syottopeliLogiikka.Kayttis.Piirtoalusta;

/**
 *
 * Kayttoliittyma kaynnistaa syottopelin kun alustus on valmis.
 */
public class Kayttoliittyma implements Runnable {
 
    private JFrame frame;
    private PeliLogiikka peli;
 
    public Kayttoliittyma(PeliLogiikka peli) {
        this.peli = peli;
    }
 
    @Override
    public void run() {
        frame = new JFrame("Syottopeli");
        frame.setPreferredSize(new Dimension(600, 800));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();
 
        frame.pack();
        frame.setVisible(true);
    }
 
    private void luoKomponentit(Container container) {
        Piirtoalusta alusta = new Piirtoalusta(peli);
        container.add(alusta);
    }
 
    private void lisaaKuuntelijat() {
    frame.addKeyListener(new NappaimistonKuuntelija(frame, peli));
    }
 
    public JFrame getFrame() {
        return frame;
    }
}