/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

public class AjastuksenKaskyt implements ActionListener {

    private Component k;
    private PeliLogiikka peli;

    @Override
    public void actionPerformed(ActionEvent ae) {
        k.repaint();
        

    }
}
