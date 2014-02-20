/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import syottopeli.syottopeliLogiikka.Ajastin;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

public class AjastuksenKaskyt implements ActionListener {

    private Piirtoalusta alusta;
    private PeliLogiikka peli;
    private Ajastin ajastin;

    public AjastuksenKaskyt(Piirtoalusta alusta, PeliLogiikka peli) {

        this.alusta = alusta;
        this.peli = peli;
        ajastin = peli.getAjastin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        ajastin.Piirra(k.getGraphics(), peli.getKiekollinen().getX(), peli.getKiekollinen().getY());
        alusta.paivitaJLabel();
        Toolkit.getDefaultToolkit().beep();
        alusta.repaint();
    }
}
