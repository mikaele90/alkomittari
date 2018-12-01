/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkopaketti;

import javax.swing.*;

/**
 *
 * @author Mikael
 */
public class Naytto {
    
    private Kontrolleri kontrolleri;
    
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
            }
            else {
                exit();
            }
        
    }
    
    
    //tästä pitäis tehdä päänäyttö
    public void kayttajaNaytto() {
        naytaViesti(kontrolleri.nimi() + " " + Double.toString(kontrolleri.paino()) + " " + kontrolleri.sukupuoli());
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
