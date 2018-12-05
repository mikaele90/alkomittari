package alkopaketti;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Naytto {
    
    private Kontrolleri kontrolleri;
    private double alcGrammat, nesteMaara, grammatTotal, grammatSekunnissa, palaneetGrammat;
    private double promillet = 0;
    private double aikaKunnesSelva = 0;
    boolean ajastinAloitettu = false;
    boolean lopeta = false;
    private long kulunutAikaLoopista = 0;
    private long kulunutAikaTotal = 0;
    private long kulunutAikaTotalTallenne = 0;
    
    //eka screeni
    public void aloitusNaytto() {
        naytaViesti("Tervetuloa Alkomittariin.\n"
                + "Tämä ohjelma ei ole täysin tarkka. Emme ota mitään vastuuta tästä eteenpäin.\n"
                + "Painamalla OK, hyväksyt olevasi itse itsestäsi vastuussa.");
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
                kontrolleri.uusiNimi( nimi.getText() ); //Välitetään käyttäjän syötteet kontrollerille, joka välittää ne eteenpäin Kayttaja-luokalle
                if (nimi.getText().length() <= 0) {
                    kontrolleri.uusiNimi("Anonyymi");
                }
                try {
                    kontrolleri.uusiPaino( Double.parseDouble( paino.getText() ) ); //sama, try-catchillä
                }
                catch(NumberFormatException e) {
                    naytaViesti("Syötä paino.");
                    luoKayttaja();
                }
                kontrolleri.uusiSukupuoli( sukupuoliValikko.getSelectedIndex() ); //sama
                kontrolleri.uusiNesteMaara(); //asetetaan käyttäjän nestemäärä sukupuolen perusteella
            }
            else {
                exit();
            }
        
    }
    
    
    //Päänäyttö
    public void kayttajaNaytto() {
        
        naytaViesti("Juothan kohtuudella " + kontrolleri.nimi() + "."); //Alkutervehdys
        
        int valinta;
        
        //Päälooppi alkaa
        do {
            String[] juomaValinta = {"Keskari 0,3" , "Keskari 0,5", "Nelonen 0,3" , "Nelonen 0,5", "Viini 12cl", "shotti 40%", "Käsidesi 10cl", "Promilleni nyt?"};
            valinta = JOptionPane.showOptionDialog(null, "Mitäs juodaan?", "Valintaikkuna", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, juomaValinta, juomaValinta[0]);
            //System.out.println("Valinnan indeksi: " + valinta);
            
            if (promillet <= 0 && aikaKunnesSelva <= 0) {
                if (ajastinAloitettu == false) {
                    ajastinAloitettu = true;
                }
                kontrolleri.alkuhetki();
            }
            
            if (valinta == -1) { //Lopettaa ohjelman ajamisen ilman turhaa säheltämistä
                exit();
            }
            
            //Osa muuttujista pelkkiä debug-apureita
            alcGrammat = kontrolleri.juo(valinta);
            nesteMaara = kontrolleri.nesteMaara();
            //System.out.println("Valitun juoman alkoholipitoisuus: " + alcGrammat + " grammaa :: Henkilön nestepitoisuus: " + nesteMaara + "  grammaa");
            kulunutAikaTotal = kontrolleri.kulunutAikaTotal();
            kulunutAikaLoopista = kulunutAikaTotal - kulunutAikaTotalTallenne;
            kulunutAikaTotalTallenne = kulunutAikaTotal;
            //System.out.println("Kulunut sitten kellon käynnistämisen: " + kulunutAikaTotal + " sekuntia");            
            //System.out.println("Kulunut edellisestä loopista: " + kulunutAikaLoopista + " sekuntia");
            grammatSekunnissa = kontrolleri.henkiloBurnRate(kontrolleri.paino());
            //System.out.println("Grammat sekunnissa: " + grammatSekunnissa + " grammaa sekunnissa");
            palaneetGrammat = kontrolleri.palaneetGrammat();
            //System.out.println("Palaneet grammat yhteensä: " + palaneetGrammat + " grammaa");
            promillet = kontrolleri.promillet(alcGrammat, nesteMaara);
            //System.out.println("Promillet: " + promillet * 1000);
            grammatTotal = kontrolleri.juodutGrammat();
            //System.out.println("Juodut alkoholigrammat yhteensä: " + grammatTotal + " grammaa");
            aikaKunnesSelva = kontrolleri.aikaKunnesSelva();
            
            //Ohjelman loppu, jos käyttäjä ei itse lopeta
            if (aikaKunnesSelva <= 0 && (ajastinAloitettu == true && palaneetGrammat != 0)) {
                aikaKunnesSelva = 0;
                lopeta = true;
                naytaViesti("Olet selvinpäin " + kontrolleri.nimi() + ". Et tarvi tätä enää ja ohjelma lopettaa itsensä.");
                exit();
            }
            //System.out.println("Aika kunnes promillet 0: " + aikaKunnesSelva + " sekuntia");
            
            //Sievennystä
            int t = (int) aikaKunnesSelva/60;
            int hours = t / 60;
            int minutes = t % 60;
            
            //Väliaikatilanteet
            double tammonen = Math.round(promillet*1000*100) / 100.0;
            if (tammonen >= 0 && tammonen < 0.5) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nEi tunnu missään.", hours, minutes));
            }
            else if (tammonen > 0.5 && tammonen < 1.0) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nEthän lähde enää ajamaan.", hours, minutes));
            }
            else if (tammonen > 1.0 && tammonen < 1.75) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nDarra on jo taattu....", hours, minutes));
            }
            else if (tammonen > 1.75 && tammonen < 2.5) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nHuominen on huomenna t. JVG : D.", hours, minutes));
            }
            else if (tammonen > 2.5 && tammonen < 3.8) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nTanssi vielä kun osaat.", hours, minutes));
            }
            else if (tammonen > 3.8) {
            naytaViesti (String.format("Tämänhetkinen promillemääräsi on: " + Math.round(promillet*1000*100) / 100.0+ " Promillea."
                    + "\nAlkoholi on palanut noin %d tunnin %d minuutin kuluttua.\nOisikohan aika mennä nukkumaan...", hours, minutes));
            }
            
        } while (valinta >= 0); //Päälooppi loppuu
        
    }
    
    //näytä yksinkertainen tekstiboksi
    public void naytaViesti(String viesti) {
        JOptionPane.showMessageDialog(null, viesti);
    }
    
    //exit metodi
    public void exit() {
        System.exit(0);
    }
    
    //vedetty suoraan esimerkistä
    public void rekisteroiOhjain(Kontrolleri ohjain) {
        this.kontrolleri = ohjain;
    }
    
}
