/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Piirtoalusta piirtaa pelin grafiikat.
 */
public class Piirtoalusta extends JPanel {

    private PeliLogiikka peli;
    private JLabel J;

    public Piirtoalusta(PeliLogiikka peli) {
        this.peli = peli;
        J = new JLabel();
        J.setText(peli.getAjastin().getAika());
        this.add(J);
    }

    public void paivitaJLabel() {
        J.setText(peli.getAjastin().getAika());
    }

    /**
     * Luo kentan viivat ja ympyrat.
     */
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 50, 600, 2);
        g.fillRect(0, 375, 600, 8);
        g.fillRect(0, 700, 600, 2);
        g.drawOval(225, 300, 150, 150);
        g.drawOval(50, 75, 150, 150);
        g.drawOval(50, 530, 150, 150);
        g.drawOval(400, 75, 150, 150);
        g.drawOval(400, 530, 150, 150);
        g.fillOval(290, 370, 20, 20);
        g.fillOval(120, 145, 10, 10);
        g.fillOval(120, 600, 10, 10);
        g.fillOval(470, 145, 10, 10);
        g.fillOval(470, 600, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(0, 250, 600, 8);
        g.fillRect(0, 500, 600, 8);
        g.setColor(Color.BLACK);
        peli.piirra(g);
        this.paivitaJLabel();
    }
}
