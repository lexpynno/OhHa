/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.util.ArrayList;

/**
 *
 * @author Leo
 */
public class Kaukalo {

    private ArrayList<Pelaaja> pelaajat;
    private Arpoja arpoja;

    public Kaukalo() {
        arpoja = new Arpoja();
        pelaajat = new ArrayList<>();
    }

    public void luoPelaajat(int pelaajienMaara) {
        int apu = 0;
        while (apu < pelaajienMaara) {
            pelaajat.add(new Pelaaja(arpoja.satunnainenKoordinaatti(),
                    arpoja.satunnainenKoordinaatti()));
            apu++;
        }
        if (pelaajatPaallekkain() == true) {
            pelaajat.get(0).setKiekko(true);
            System.out.println(pelaajat.size());
        }
    }

    public boolean pelaajatPaallekkain() {
        boolean paallekkaisia = false;
        for (Pelaaja pelaaja : pelaajat) {
            for (Pelaaja pelaaja1 : pelaajat) {
                if (pelaaja.ovatkotKoordinaatitVapaina(pelaaja1.getX(),
                        pelaaja1.getY()) == true) {
                    paallekkaisia = false;
                } else {
                    paallekkaisia = true;
                    break;
                }
            }
        }
        return paallekkaisia;
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
}
