/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopeliLogiikka.Kayttis;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import syottopeli.syottopeliLogiikka.PeliLogiikka;

/**
 *
 * Luo kyselyn, jossa kayttaja voi valita haluamansa nopeuden ja pelaajien
 * maaran "syottojen maaran".
 */
public class PelinAlustus implements Runnable {

    private JFrame frame;
    private PeliLogiikka peli;

    /**
     * Luo valintaikkunan, josta kayttaja voi valita haluamansa pelaajien
     * maarana ja ajan pituuden.
     */
    @Override
    public void run() {
        peli = new PeliLogiikka();
        frame = new JFrame("Pelin alustus");
        frame.setPreferredSize(new Dimension(400, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    private void luoKomponentit(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Kuinka monta pelaajaa? (Syöttöjen määrä)"));
        JRadioButton kaks = new JRadioButton("2");
        JRadioButton kolme = new JRadioButton("3");
        JRadioButton nelja = new JRadioButton("4");
        JRadioButton viisi = new JRadioButton("5");
        JRadioButton kuusi = new JRadioButton("6");
        JRadioButton seitseman = new JRadioButton("7");
        JRadioButton kahdeksan = new JRadioButton("8");
        JRadioButton yhdeksan = new JRadioButton("9");
        JRadioButton kymmenen = new JRadioButton("10");

        JButton nappi = new JButton("Valmis!");

        Tapahtumakuuntelija Tapahtumankuuntelija = new Tapahtumakuuntelija(kaks, kolme, nelja, viisi, kuusi, seitseman, kahdeksan, yhdeksan, kymmenen, peli);

        kaks.addActionListener(Tapahtumankuuntelija);
        kolme.addActionListener(Tapahtumankuuntelija);
        nelja.addActionListener(Tapahtumankuuntelija);
        viisi.addActionListener(Tapahtumankuuntelija);
        kuusi.addActionListener(Tapahtumankuuntelija);
        seitseman.addActionListener(Tapahtumankuuntelija);
        kahdeksan.addActionListener(Tapahtumankuuntelija);
        yhdeksan.addActionListener(Tapahtumankuuntelija);
        kymmenen.addActionListener(Tapahtumankuuntelija);

        ButtonGroup ryhma = new ButtonGroup();
        ryhma.add(kaks);
        ryhma.add(kolme);
        ryhma.add(nelja);
        ryhma.add(viisi);
        ryhma.add(kuusi);
        ryhma.add(seitseman);
        ryhma.add(kahdeksan);
        ryhma.add(yhdeksan);
        ryhma.add(kymmenen);

        container.add(kaks);
        container.add(kolme);
        container.add(nelja);
        container.add(viisi);
        container.add(kuusi);
        container.add(seitseman);
        container.add(kahdeksan);
        container.add(yhdeksan);
        container.add(kymmenen);

        container.add(new JLabel("Ajan pituus? (vaikeustaso)"));

        JRadioButton vauva = new JRadioButton("Vauva (20 sekunttia)");
        JRadioButton jonne = new JRadioButton("Jonne (15 sekunttia)");
        JRadioButton Kannissa = new JRadioButton("Kannissa (8 sekunttia)");
        JRadioButton perus = new JRadioButton("Perusjamppa (5 sekunttia)");
        JRadioButton superi = new JRadioButton("Supermies (3 sekunttia)");
        JRadioButton simpanssi = new JRadioButton("Simpanssi (2 sekunttia)");

        VaikeustasonKuuntelija VaikeustasonKuuntelija = new VaikeustasonKuuntelija(simpanssi, superi, perus, jonne, Kannissa, vauva, peli, nappi);

        simpanssi.addActionListener(VaikeustasonKuuntelija);
        superi.addActionListener(VaikeustasonKuuntelija);
        perus.addActionListener(VaikeustasonKuuntelija);
        jonne.addActionListener(VaikeustasonKuuntelija);
        Kannissa.addActionListener(VaikeustasonKuuntelija);
        vauva.addActionListener(VaikeustasonKuuntelija);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(simpanssi);
        buttonGroup.add(superi);
        buttonGroup.add(perus);
        buttonGroup.add(jonne);
        buttonGroup.add(Kannissa);
        buttonGroup.add(vauva);

        container.add(simpanssi);
        container.add(superi);
        container.add(perus);
        container.add(Kannissa);
        container.add(jonne);
        container.add(vauva);

        nappi.addActionListener(VaikeustasonKuuntelija);
        container.add(nappi);
    }
}
