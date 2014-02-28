/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

import syottopeliLogiikka.Kayttis.Kayttoliittyma;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import syottopeliLogiikka.Kayttis.Piirtoalusta;

/**
 *
 * Sisaltaa pelin tarkeimmat tapahtumaketjut. Keskusyksikko, jonka kautta muut
 * toiminnot tapahtuvat.
 */
public class PeliLogiikka {

    private AjastinMuisti ajastin;
    private ArrayList<Pelaaja> pelaajat;
    private Arpoja arpoja;
    private int pelaajienMaara;
    private Piirtoalusta alusta;

    public PeliLogiikka() {
        arpoja = new Arpoja();
        pelaajat = new ArrayList<>();
        pelaajienMaara = 5;
    }

    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
    }

    public void setAika(int aika) {
        getAjastin().setAika(aika);
    }

    public AjastinMuisti getAjastin() {
        return ajastin;
    }

    public Piirtoalusta getAlusta() {
        return this.alusta;
    }

    /**
     * Luo halutun maaran pelaajia kentalle seka kaynnistaa kayttoliittyman.
     */
    public void kaynnista(int aika) {
        luoPelaajat(pelaajienMaara);
        ajastin = new AjastinMuisti(aika);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(this);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

    /**
     * Lopettaa pelin toiminnallisuuden.
     */
    public void keskeyta() {
        getKiekollinen().setKiekko(false);
        alusta.setIgnoreRepaint(true);
    }

    /**
     * Tarkastaa etta jokaisella pelaajalla on pelin jossain vaiheessa ollut
     * kiekko hallussaan.
     *
     * @return
     */
    public boolean kaikillaOllutKiekko() {
        for (Pelaaja pelaaja : pelaajat) {
            if (pelaaja.OnkoKiekkoOllutHallussa() == false) {
                return false;
            }
        }
        return true;
    }

    public int getPelaajienMaara() {
        return pelaajienMaara;
    }

    public Arpoja getArpoja() {
        return arpoja;
    }

    /**
     * Piirtaa jokaisen pelaajan.
     *
     * @param g
     */
    public void piirra(Graphics g) {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.piirra(g);
        }
    }

    /**
     * Asettaa halutun pelaajien maaran muistiin.
     *
     * @param i
     */
    public void setPelaajienMaara(int i) {
        this.pelaajienMaara = i;
    }

    /**
     * Palauttaa kiekollisen pelaajan tai null-arvon mikali peli on keskeytetty.
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
     *
     * @param pelaajienMaara
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
                break;
            }
        }
    }

    /**
     * Kuluttaa ajstimesta sekunnin ja antaa äänimerkin mikäli syottokohteessa
     * ei ole pelaajaa.
     */
    public void vaaraSyotto() {
        ajastin.kulutaAikaa();
        Toolkit.getDefaultToolkit().beep();
    }

    /**
     *
     * Tarkistaako onko kentalla pelaajia idassa ja syottaa talle mikali ehto on
     * tosi.
     *
     */
    public void pelaajaOnIdassa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getX() < pelaaja.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < x * x * 0.50 && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia etelassa ja syottaa talle mikali ehto
     * on tosi.
     *
     */
    public void pelaajaOnEtelassa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < y * y * 0.50 && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia Lannessa ja syottaa talle mikali ehto
     * on tosi.
     *
     */
    public void pelaajaOnLannessa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getX() > pelaaja.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (Math.abs(x * y) < x * x * 0.50 && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia pohjoisessa ja syottaa talle mikali
     * ehto on tosi.
     *
     */
    public void pelaajaOnPohjoisessa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (Math.abs(x * y) < y * y * 0.50 && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia koilisessa ja syottaa talle mikali
     * ehto on tosi.
     *
     */
    public void pelaajaOnKoilisessa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY() && pelaaja.getX() > kiekollinen.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (x < (y * 1.35) && x > (y * 0.65) && y != 0 && x != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia kaakossa ja syottaa talle mikali ehto
     * on tosi.
     *
     */
    public void pelaajaOnKaakossa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY() && pelaaja.getX() > kiekollinen.getX()) {
                int x = pelaaja.getX() - kiekollinen.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (x < (y * 1.35) && x > (y * 0.65) && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia lounaassa ja syottaa talle mikali ehto
     * on tosi.
     *
     */
    public void pelaajaOnLounaassa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() < pelaaja.getY() && pelaaja.getX() < kiekollinen.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = pelaaja.getY() - kiekollinen.getY();
                if (x < (y * 1.35) && x > (y * 0.65) && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }

    /**
     * Tarkistaako onko kentalla pelaajia luoteessa ja syottaa talle mikali ehto
     * on tosi.
     *
     */
    public void pelaajaOnLuoteessa() {
        Pelaaja kiekollinen = getKiekollinen();
        int pelaajiaSuunnassa = 0;
        for (Pelaaja pelaaja : pelaajat) {
            if (kiekollinen.getY() > pelaaja.getY() && pelaaja.getX() < kiekollinen.getX()) {
                int x = kiekollinen.getX() - pelaaja.getX();
                int y = kiekollinen.getY() - pelaaja.getY();
                if (x < (y * 1.35) && x > (y * 0.65) && x != 0 && y != 0) {
                    if (pelaaja.OnkoKiekkoOllutHallussa() != true) {
                        kiekollinen.setKiekko(false);
                        pelaaja.setKiekko(true);
                        pelaajiaSuunnassa++;
                        break;
                    }
                }
            }
        }
        if (pelaajiaSuunnassa == 0) {
            vaaraSyotto();
        }
    }
}
