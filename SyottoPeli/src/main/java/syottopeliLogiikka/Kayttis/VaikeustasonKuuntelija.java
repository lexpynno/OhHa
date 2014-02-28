/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Jatkaa kayttajan haluamat kaskyt eteenpain ajastimelle ja kaynnistaa pelin.
 */
public class VaikeustasonKuuntelija implements ActionListener {

    private JRadioButton kaksi;
    private JRadioButton kolme;
    private JRadioButton viisi;
    private JRadioButton viisitoista;
    private JRadioButton kahdeksan;
    private JRadioButton kaksikymmenta;
    private PeliLogiikka peli;
    private JButton nappi;
    private int aika;

    /**
     * Luo Kuuntelijat vaikeustasoa saataville napeille.
     *
     * @param kaksi
     * @param kolme
     * @param viisi
     * @param kahdeksan
     * @param viisitoista
     * @param kaksikymmenta
     * @param peli
     * @param nappi
     */
    public VaikeustasonKuuntelija(JRadioButton kaksi, JRadioButton kolme, JRadioButton viisi, JRadioButton kahdeksan, JRadioButton viisitoista, JRadioButton kaksikymmenta, PeliLogiikka peli, JButton nappi) {
        this.kaksi = kaksi;
        this.nappi = nappi;
        this.kolme = kolme;
        this.viisi = viisi;
        this.viisitoista = kahdeksan;
        this.kahdeksan = viisitoista;
        this.kaksikymmenta = kaksikymmenta;
        this.peli = peli;
        this.aika = 5000;
    }

    /**
     * Jatkaa kayttajan haluamat saadot eteenpain pelille.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == kaksikymmenta) {
            aika = 20000;
        } else if (ae.getSource() == viisitoista) {
            aika = 15000;
        } else if (ae.getSource() == kahdeksan) {
            aika = 8000;
        } else if (ae.getSource() == viisi) {
            aika = 5000;
        } else if (ae.getSource() == kolme) {
            aika = 3000;
        } else if (ae.getSource() == kaksi) {
            aika = 2000;
        }
        if (ae.getSource() == nappi) {
            peli.kaynnista(aika);
        }
    }
}
