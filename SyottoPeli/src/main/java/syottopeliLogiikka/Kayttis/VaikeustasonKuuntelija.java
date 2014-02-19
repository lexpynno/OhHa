/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import syottopeli.syottopeliLogiikka.Ajastin;
import syottopeli.syottopeliLogiikka.Ajastin;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Valittaa kayttajan haluamat kaskyt eteenpain ajastimelle.
 */
public class VaikeustasonKuuntelija implements ActionListener {

    private JRadioButton mahdoton;
    private JRadioButton vaikea;
    private JRadioButton normaali;
    private JRadioButton helpohko;
    private JRadioButton helppo;
    private JRadioButton aloittelija;
    private PeliLogiikka peli;

    public VaikeustasonKuuntelija(JRadioButton mahdoton, JRadioButton vaikea, JRadioButton normaali, JRadioButton helpohko, JRadioButton helppo, JRadioButton aloittelija, PeliLogiikka peli) {
        this.mahdoton = mahdoton;
        this.vaikea = vaikea;
        this.normaali = normaali;
        this.helpohko = helpohko;
        this.helppo = helppo;
        this.aloittelija = aloittelija;
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aloittelija) {
            peli.getAjastin().asetaAika(10000);
        }
        if (ae.getSource() == helpohko) {
            peli.getAjastin().asetaAika(5000);
        }
        if (ae.getSource() == helppo) {
            peli.getAjastin().asetaAika(3000);
        }
        if (ae.getSource() == normaali) {
            peli.getAjastin().asetaAika(2000);
        }
        if (ae.getSource() == vaikea) {
            peli.getAjastin().asetaAika(1000);
        }
        if (ae.getSource() == mahdoton) {
            peli.getAjastin().asetaAika(500);
        }
    }
}
