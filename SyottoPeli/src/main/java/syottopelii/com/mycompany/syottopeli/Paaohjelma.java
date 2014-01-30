package syottopelii.com.mycompany.syottopeli;

import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class Paaohjelma {

    public static void main(String[] args) {
        PelinAlustus alustus = new PelinAlustus();
        SwingUtilities.invokeLater(alustus);
    }
}
