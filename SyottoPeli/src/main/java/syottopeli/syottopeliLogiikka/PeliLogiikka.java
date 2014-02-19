/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

import syottopeliLogiikka.Kayttis.Kayttoliittyma;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import syottopeliLogiikka.Kayttis.AjastuksenKaskyt;

/**
 *
 * Sisaltaa pelin tarkeimmat tapahtumaketjut. Keskusyksikko, jonka kautta muut
 * toiminnot tapahtuvat.
 */
public class PeliLogiikka {

    private Ajastin ajastin;
    private ArrayList<Pelaaja> pelaajat;
    private Arpoja arpoja;
    private int maara;
    private boolean kaynnissa;
    private AjastuksenKaskyt a;

    public PeliLogiikka() {
        ajastin = new Ajastin(a);
        arpoja = new Arpoja();
        pelaajat = new ArrayList<Pelaaja>();
        maara = 5;
        kaynnissa = false;
    }

    public Ajastin getAjastin() {
        return ajastin;
    }
    /* Luo halutun maaran pelaajia kentalle seka kaynnistaa kayttoliittyman. */

    public void kaynnista() {
        luoPelaajat(maara);
        kaynnissa = true;
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    /**
     * Lopettaa pelin toiminnallisuuden.
     */
    public void keskeyta() {
        kaynnissa = false;
        getKiekollinen().setKiekko(false);
    }

    public boolean kaikillaOllutKiekko() {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.OnkoKiekkoOllutHallussa() == false) {
                return false;
            }
        }
        return true;
    }

    public boolean getKaynnissa() {
        return kaynnissa;
    }

    public int getMaara() {
        return maara;
    }

    /**
     * Tarkistaako onko kentalla pelaajia idassa.
     *
     * @param Pelaaja
     */
    public void pelaajaOnIdassa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getX() < pelaaja.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < x * x * 0.55 && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia etelassa.
     *
     *
     */
    public void pelaajaOnEtelassa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < y * y * 0.55 && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia Lannessa.
     *
     *
     */
    public void pelaajaOnLannessa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getX() > pelaaja.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < x * x * 0.55 && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia pohjoisessa.
     *
     *
     */
    public void pelaajaOnPohjoisessa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (Math.abs(x * y) < y * y * 0.55 && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia koilisessa.
     *
     *
     */
    public void pelaajaOnKoilisessa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY() && pelaaja.getX() > kiekollinen.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (x < (y * 1.3) && x > (y * 0.7) && y != 0 && x != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia kaakossa.
     *
     *
     */
    public void pelaajaOnKaakossa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY() && pelaaja.getX() > kiekollinen.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (x < (y * 1.3) && x > (y * 0.7) && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia lounaassa.
     *
     *
     */
    public void pelaajaOnLounaassa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY() && pelaaja.getX() < kiekollinen.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (x < (y * 1.3) && x > (y * 0.7) && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Tarkistaako onko kentalla pelaajia luoteessa.
     *
     *
     */
    public void pelaajaOnLuoteessa() {
        Pelaaja kiekollinen = getKiekollinen();

        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY() && pelaaja.getX() < kiekollinen.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (x < (y * 1.3) && x > (y * 0.7) && x != 0 && y != 0) {
                    pelaaja.setKiekko(true);
                    break;
                }
            }
        }
        kiekollinen.setKiekko(false);
    }

    /**
     * Palauttaa kiekollisen pelaajan.Palauttaa pelaajan tai null/arvon.
     *
     * @return Pelaaja
     */
    public Pelaaja getKiekollinen() {
        Pelaaja palautettava = null;
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.onkoKiekkoHallussa()) {
                palautettava = pelaaja;
            }
        }
        return palautettava;
    }

    /**
     * Luo halutun maaran pelaajia satunnaisilla koordinaateilla.
     */
    public void luoPelaajat(int pelaajienMaara) {
        int apu = 0;
        while (apu < pelaajienMaara) {
            pelaajat.add(new Pelaaja(arpoja.satunnainenKoordinaattiX(),
                    arpoja.satunnainenKoordinaattiY()));
            apu++;
        }
        kiekkoYlimmalle();
    }

    /**
     * Etsii ylimman pelaajan ja asettaa sen kiekolliseksi.
     */
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

    /**
     * Tarkistaa ovatko pelaajat samoissa koordinaateissa. Palauttaa arvon true
     * jos pelaajat ovat paallekkain ja false jos eivat.
     *
     * @return boolean
     */
    public boolean pelaajatPaallekkain() {
        for (Pelaaja pelaaja : pelaajat) {
            for (Pelaaja pelaaja1 : pelaajat) {
                if (pelaaja.ovatkotKoordinaatitVapaina(pelaaja1.getX(),
                        pelaaja1.getY())) {
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

    /**
     * Lisaa Pelaajan listaan.
     *
     * @param Pelaaja
     */
    public void lisaaPelaaja(Pelaaja pelaaja) {
        pelaajat.add(pelaaja);
    }

    public Arpoja getArpoja() {
        return arpoja;
    }

    /**
     * Piirtaa jokaisen pelaajan erikseen.
     */
    public void piirra(Graphics g) {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.piirra(g);
        }
        ajastin.Piirra(g, getKiekollinen().getX(), getKiekollinen().getY());
    }

    /**
     * Asettaa halutun pelaajien maaran muistiin.
     */
    public void setPelaajienMaara(int i) {
        this.maara = i;
    }
}
