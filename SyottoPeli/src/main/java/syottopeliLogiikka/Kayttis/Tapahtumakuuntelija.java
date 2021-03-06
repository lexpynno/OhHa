/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Valittaa kayttajan haluamat valinnat pelaajien maarasta eteenpain ja
 * kaynnistaa pelin.
 */
public class Tapahtumakuuntelija implements ActionListener {

    private JRadioButton kaks;
    private JRadioButton kolme;
    private JRadioButton nelja;
    private JRadioButton viisi;
    private JRadioButton kuusi;
    private JRadioButton seitseman;
    private JRadioButton kahdeksan;
    private JRadioButton yhdeksan;
    private JRadioButton kymmenen;
    private PeliLogiikka peli;

    /**
     * Luo kuuntelijan valintaikkunan napeille.
     *
     * @param kaks
     * @param kolme
     * @param nelja
     * @param viisi
     * @param kuusi
     * @param seitseman
     * @param kahdeksan
     * @param yhdeksan
     * @param kymmenen
     * @param peli
     */
    public Tapahtumakuuntelija(JRadioButton kaks, JRadioButton kolme, JRadioButton nelja, JRadioButton viisi, JRadioButton kuusi,
            JRadioButton seitseman, JRadioButton kahdeksan, JRadioButton yhdeksan, JRadioButton kymmenen, PeliLogiikka peli) {
        this.kaks = kaks;
        this.kolme = kolme;
        this.nelja = nelja;
        this.viisi = viisi;
        this.kuusi = kuusi;
        this.seitseman = seitseman;
        this.kahdeksan = kahdeksan;
        this.yhdeksan = yhdeksan;
        this.kymmenen = kymmenen;
        this.peli = peli;
    }

    /**
     * Kuuntelee valinnat ja jatkaa kaskyt eteenpain pelille.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == kaks) {
            peli.setPelaajienMaara(2);
        }
        if (ae.getSource() == kolme) {
            peli.setPelaajienMaara(3);
        }
        if (ae.getSource() == nelja) {
            peli.setPelaajienMaara(4);
        }
        if (ae.getSource() == viisi) {
            peli.setPelaajienMaara(5);
        }
        if (ae.getSource() == kuusi) {
            peli.setPelaajienMaara(6);
        }
        if (ae.getSource() == seitseman) {
            peli.setPelaajienMaara(7);
        }
        if (ae.getSource() == kahdeksan) {
            peli.setPelaajienMaara(8);
        }
        if (ae.getSource() == yhdeksan) {
            peli.setPelaajienMaara(9);
        }
        if (ae.getSource() == kymmenen) {
            peli.setPelaajienMaara(10);
        }
    }
}
