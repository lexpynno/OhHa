/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeli.syottopeliLogiikka;

/**
 *
 * Pitaa muistissa pelin nykyista aikaa.
 */
public class AjastinMuisti {

    private int aika;

    public AjastinMuisti(int aika) {
        this.aika = aika;
    }

    public void setAika(int i) {
        aika = i;
    }

    /**
     * Palauttaa ajan string muodossa, jotta se voidaan nayttaa JLabelissa.
     *
     * @return
     */
    public String getAikaString() {
        return "" + aika / 1000 + " sekunttia";
    }

    public int getAikaInt() {
        return aika;
    }

    /**
     * Kuluttaa aikaa sekunnilla.
     */
    public void kulutaAikaa() {
        aika -= 1000;
        if (aika <= 0) {
            aika = 0;
        }
    }
}
