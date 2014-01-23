/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class Peli {

    private Kaukalo kaukalo;
    private Scanner lukija;

    public Peli() {
        lukija = new Scanner(System.in);
        kaukalo = new Kaukalo();
    }

    public void kaynnista() {
        System.out.println("Pelaajien maara?");

        int maara = Integer.parseInt(lukija.nextLine());
        kaukalo.luoPelaajat(maara);
    }
}
