/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import syottopelii.com.mycompany.syottopeli.Kayttoliittyma;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * Sisaltaa pelin tarkeimmat tapahtumaketjut. Keskusyksikko, jonka kautta muut toiminnot tapahtuvat.
 */
public class PeliLogiikka {

    private Scanner lukija;
    private ArrayList<Pelaaja> pelaajat;
    private Arpoja arpoja;
    private int maara;
    private boolean kaynnissa;

    public PeliLogiikka() {
        lukija = new Scanner(System.in);
        arpoja = new Arpoja();
        pelaajat = new ArrayList<Pelaaja>();
        maara = 5;
        kaynnissa = false;
    }

    public void kaynnista() {
        luoPelaajat(maara);
        kaynnissa = true;
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    public void keskeyta() {
        kaynnissa = false;
        getKiekollinen().setKiekko(false);
    }

    public void syotaItaan() {
        if (pelaajaOnIdassa() != null) {
        } else {
            keskeyta();
        }
    }

    public Pelaaja pelaajaOnIdassa() {
        Pelaaja kiekollinen = getKiekollinen();
        Pelaaja palautettava = null;

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getX() < pelaaja.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < x * 0.5 && Math.abs(x * y) > 0) {
                    palautettava = pelaaja;
                }
            }
        }
        kiekollinen.setKiekko(false);
        return palautettava;
    }

    public void syotaEtelaan() {
        Pelaaja vertaus = pelaajaOnEtelassa();
        if (vertaus != null) {
            for (Pelaaja pelaaja : pelaajat) {
                if(pelaaja.getX() == vertaus.getX() && pelaaja.getY() == vertaus.getY()) {
                    pelaaja.setKiekko(true);
                }
            }
        } else {
            keskeyta();
        }
    }

    public Pelaaja pelaajaOnEtelassa() {
        Pelaaja kiekollinen = getKiekollinen();
        Pelaaja palautettava = null;

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < y * 0.5 && Math.abs(x * y) > 0) {
                    palautettava = pelaaja;
                }
            }
        }
        kiekollinen.setKiekko(false);
        return palautettava;
    }

    public Pelaaja getKiekollinen() {
        Pelaaja palautettava = new Pelaaja(maara, maara);
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.onkoKiekkoHallussa()) {
                palautettava = pelaaja;
            }
        }
        return palautettava;
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

    public void setPelaajienMaara(int i) {
        this.maara = i;
    }
}
