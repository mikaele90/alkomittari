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
    
    public void aloitusNaytto() {
        naytaViesti("Tervetuloa Alkomittari++:aan.\n"
                + "Tämä ohjelma on vitsi, eli älkää plz haastako oikeuteen ;_;");
    }
    
    public void luoKayttaja() {
        
        String[] sukupuoliValinnat = {"Mies", "Nainen"};
        
        JTextField nimi = new JTextField(8);
        JTextField paino = new JTextField(2);
        JLabel sukupuoliLabel = new JLabel("Sukupuoli:");
        JComboBox sukupuoliValikko = new JComboBox(sukupuoliValinnat);
        
        JPanel kayttajaTiedot = new JPanel();
        kayttajaTiedot.add(new JLabel("Nimi:"));
        kayttajaTiedot.add(nimi);
        kayttajaTiedot.add(new JLabel("Paino:"));
        kayttajaTiedot.add(paino);
        kayttajaTiedot.add(sukupuoliLabel);
        kayttajaTiedot.add(sukupuoliValikko);
        
        int ok = JOptionPane.showConfirmDialog(null, kayttajaTiedot, "Anna tiedot.", JOptionPane.OK_CANCEL_OPTION);
            if (ok == JOptionPane.OK_OPTION) {
                kontrolleri.uusiNimi( nimi.getText() );
                kontrolleri.uusiPaino( Double.parseDouble( paino.getText() ) );
                kontrolleri.uusiSukupuoli( sukupuoliValikko.getSelectedIndex() );
            }
        
    }
    
    public void kayttajaNaytto() {
        naytaViesti(kontrolleri.nimi() + " " + Double.toString(kontrolleri.paino()) + " " + kontrolleri.sukupuoli());
    }
    
    
    public void naytaViesti(String viesti) {
        JOptionPane.showMessageDialog(null, viesti);
    }
    
    public void exit() {
        System.exit(0);
    }
    
    public void rekisteroiOhjain(Kontrolleri ohjain) {
        this.kontrolleri = ohjain;
    }
    
}
