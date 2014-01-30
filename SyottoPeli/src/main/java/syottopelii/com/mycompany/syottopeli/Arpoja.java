/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.util.Random;

/**
 *
 * @author Leo
 */
public class Arpoja {
    
    private Random random;

    public Arpoja() {
        this.random = new Random();
    }
    public int satunnainenKoordinaattiX() {
       return random.nextInt(500)+30;
    }
        public int satunnainenKoordinaattiY() {
       return random.nextInt(630)+50;
    }
}
