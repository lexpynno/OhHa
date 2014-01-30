/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leo
 */
public class Peli {

    private Scanner lukija;
    private ArrayList<Pelaaja> pelaajat;
    private Arpoja arpoja;
    private int maara;

    public Peli() {
        lukija = new Scanner(System.in);
        arpoja = new Arpoja();
        pelaajat = new ArrayList<Pelaaja>();
        maara = 5;
    }

    public void kaynnista() {
        luoPelaajat(maara);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    public void luoPelaajat(int pelaajienMaara) {
        int apu = 0;
        while (apu < pelaajienMaara) {
            pelaajat.add(new Pelaaja(arpoja.satunnainenKoordinaattiX(),
                    arpoja.satunnainenKoordinaattiY()));
            apu++;
        }
        kiekkoYlimmalle();
    }

    public void kiekkoYlimmalle() {
        int alin = 99999999;
        for (Pelaaja pelaaja : pelaajat) {
            if (alin > pelaaja.getY()) {
                alin = pelaaja.getY();
            }
        }
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.getY() == alin) {
                pelaaja.setKiekko(true);
            }
        }
    }

    public boolean pelaajatPaallekkain() {
        for (Pelaaja pelaaja : pelaajat) {
            for (Pelaaja pelaaja1 : pelaajat) {
                if (pelaaja.ovatkotKoordinaatitVapaina(pelaaja1.getX(),
                        pelaaja1.getY()) == true) {
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public int getPelaajat() {
        return pelaajat.size();
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        pelaajat.add(pelaaja);
    }

    public Arpoja getArpoja() {
        return arpoja;
    }

    public void piirra(Graphics g) {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.piirra(g);
        }

    }

    void setPelaajienMaara(int i) {
        this.maara = i;
    }
}
