package alkopaketti;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Naytto {
    
    private Kontrolleri kontrolleri;
    private double ag;
    private double nm;
    private double ng;
    private double pr;
    private double pa;
    private double hg;
    private double pg;
    private double as;
    boolean ajastinAloitettu = false;
    private long aa;
    private long ka = 0;
    
    //eka screeni
    public void aloitusNaytto() {
        naytaViesti("Tervetuloa Alkomittari++:aan.\n"
                + "Tämä ohjelma on vitsi, eli älkää plz haastako oikeuteen ;_;");
    }
    
    //luodaan käyttäjä
    public void luoKayttaja() {
        
        //luodaan lista
        String[] sukupuoliValinnat = {"Mies", "Nainen"};
        //luodaan tekstikentät ja comboboxxi
        JTextField nimi = new JTextField(8);
        JTextField paino = new JTextField(2);
        JComboBox sukupuoliValikko = new JComboBox(sukupuoliValinnat);
        
        //luodaan näytettävät kysymykset
        JPanel kayttajaTiedot = new JPanel();
        kayttajaTiedot.add(new JLabel("Nimi:"));
        kayttajaTiedot.add(nimi);
        kayttajaTiedot.add(new JLabel("Paino:"));
        kayttajaTiedot.add(paino);
        kayttajaTiedot.add(new JLabel("Sukupuoli:"));
        kayttajaTiedot.add(sukupuoliValikko);
        
        //näytetään tuo showConfirmDialog, johon tuodaan tuo yllä oleva kayttajaTiedot -JPanel
        int ok = JOptionPane.showConfirmDialog(null, kayttajaTiedot, "Anna tiedot.", JOptionPane.OK_CANCEL_OPTION);
            if (ok == JOptionPane.OK_OPTION) {
                kontrolleri.uusiNimi( nimi.getText() ); //Välitetään käyttäjän syötteet kontrollerille, joka välittää ne eteenpäin kayttaja-luokalle
                kontrolleri.uusiPaino( Double.parseDouble( paino.getText() ) ); //sama
                kontrolleri.uusiSukupuoli( sukupuoliValikko.getSelectedIndex() ); //sama
                kontrolleri.uusiNesteMaara();
            }
            else {
                exit();
            }
        
    }
    
    
    //tästä pitäis tehdä päänäyttö
    public void kayttajaNaytto() {
        naytaViesti("Juothan kohtuudella " + kontrolleri.nimi() + ".");
        
        int valinta;
        
        do {
            String[] juomaValinta = {"Keskari", "Nelonen", "Viini", "Viinaa", "Käsidesi", "Promilleni nyt?"};
            valinta = JOptionPane.showOptionDialog(null, "Mitäs juodaan?", "Valintaikkuna", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, juomaValinta, juomaValinta[0]);
            System.out.println(valinta);
            if (ajastinAloitettu == false) {
                aa = kontrolleri.alkuhetki();
                ajastinAloitettu = true;
            }
            ag = kontrolleri.juo(valinta);
            nm = (kontrolleri.nesteMaara() / 1000);
            System.out.println(ag + "  " + nm + "  Oon täs1");
            pr = kontrolleri.promillet(ag, kontrolleri.nesteMaara(), kontrolleri.palaneetGrammat(kontrolleri.paino()));
            System.out.println(pr * 1000 + " Oon täs2");
            ng = kontrolleri.juodutGrammat();
            System.out.println(ng + " Oon täs3");
            pa = kontrolleri.palamisAika(kontrolleri.paino());
            System.out.println(pa + " Oon täs4");
            System.out.println(aa + " Oon täs5");
            ka = kontrolleri.kulunutAika();
            System.out.println(ka + " Oon täs6");
            hg = kontrolleri.henkiloBurnRate(kontrolleri.paino());
            System.out.println(hg + " Oon täs7");
            pg = kontrolleri.palaneetGrammat(kontrolleri.paino());
            System.out.println(pg + " Oon täs8");
            as = kontrolleri.aikaKunnesSelva();
            System.out.println(as + " Oon täs9");
            int t = (int) as/60;
            int hours = t / 60;
            int minutes = t % 60;
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(pr*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.", hours, minutes));
        } while (valinta >= 0);
        
    }
    
    //näytä yksinkertainen tekstiboksi
    public void naytaViesti(String viesti) {
        JOptionPane.showMessageDialog(null, viesti);
    }
    
    //lopeta ajaminen metodi
    public void exit() {
        System.exit(0);
    }
    
    //vedetty suoraan esimerkistä
    public void rekisteroiOhjain(Kontrolleri ohjain) {
        this.kontrolleri = ohjain;
    }
    
}
