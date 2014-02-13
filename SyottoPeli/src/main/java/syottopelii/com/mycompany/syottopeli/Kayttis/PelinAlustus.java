/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syottopelii.com.mycompany.syottopeli;

import syottopelii.com.mycompany.syottopeli.VaikeustasonKuuntelija;
import syottopelii.com.mycompany.syottopeli.Tapahtumakuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * Luo kyselyn, jossa kayttaja voi valita haluamansa nopeuden ja pelaajien
 * maaran "syottojen maaran".
 */
public class PelinAlustus implements Runnable {

    private JFrame frame;
    private PeliLogiikka peli;

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

        Tapahtumakuuntelija Tapahtumankuuntelija = new Tapahtumakuuntelija(kaks, kolme, nelja, viisi, kuusi, seitseman, kahdeksan, yhdeksan, kymmenen, nappi, peli);

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

        container.add(new JLabel("Vaikeustaso (ajan pituus)?"));

        JRadioButton mahdoton = new JRadioButton("Mahdoton (0.5 sekunttia)");
        JRadioButton vaikea = new JRadioButton("Vaikea (1 sekuntti)");
        JRadioButton normaali = new JRadioButton("normaali (2 sekunttia)");
        JRadioButton helpohko = new JRadioButton("helpohko (3 sekunttia)");
        JRadioButton helppo = new JRadioButton("Helppo (5 sekunttia)");
        JRadioButton aloittelija = new JRadioButton("Aloittelija (10 sekunttia)");

        VaikeustasonKuuntelija VaikeustasonKuuntelija = new VaikeustasonKuuntelija(aloittelija, helppo, helpohko, normaali, vaikea, mahdoton);

        mahdoton.addActionListener(VaikeustasonKuuntelija);
        vaikea.addActionListener(VaikeustasonKuuntelija);
        normaali.addActionListener(VaikeustasonKuuntelija);
        helpohko.addActionListener(VaikeustasonKuuntelija);
        helppo.addActionListener(VaikeustasonKuuntelija);
        aloittelija.addActionListener(VaikeustasonKuuntelija);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(aloittelija);
        buttonGroup.add(helppo);
        buttonGroup.add(helpohko);
        buttonGroup.add(normaali);
        buttonGroup.add(vaikea);
        buttonGroup.add(mahdoton);

        container.add(aloittelija);
        container.add(helppo);
        container.add(helpohko);
        container.add(normaali);
        container.add(vaikea);
        container.add(mahdoton);


        nappi.addActionListener(Tapahtumankuuntelija);
        container.add(nappi);
    }
}
