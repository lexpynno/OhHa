/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import syottopelii.com.mycompany.syottopeli.Ajastin;

/**
 *
 * Valittaa kayttajan haluamat kaskyt eteenpain.
 */
public class VaikeustasonKuuntelija implements ActionListener {

    private JRadioButton mahdoton;
    private JRadioButton vaikea;
    private JRadioButton normaali;
    private JRadioButton helpohko;
    private JRadioButton helppo;
    private JRadioButton aloittelija;
    private Ajastin ajastin;

   public VaikeustasonKuuntelija(JRadioButton aloittelija, JRadioButton helppo, JRadioButton helpohko, JRadioButton normaali, JRadioButton vaikea, JRadioButton mahdoton) {
        this.aloittelija = aloittelija;
        this.helpohko = helpohko;
        this.helppo = helppo;
        this.normaali = normaali;
        this.vaikea = vaikea;
        this.mahdoton = mahdoton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aloittelija) {
        ajastin.asetaAika(10000);
        }
        if (ae.getSource() == helpohko) {
        ajastin.asetaAika(5000);
        }
        if (ae.getSource() == helppo) {
        ajastin.asetaAika(3000);
        }
        if (ae.getSource() == normaali) {
        ajastin.asetaAika(2000);
        }
        if (ae.getSource() == vaikea) {
        ajastin.asetaAika(1000);
        }
        if (ae.getSource() == mahdoton) {
        ajastin.asetaAika(500);
        }
    }
}
