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
    public int satunnainenKoordinaatti() {
       return random.nextInt(50);
    }
}
