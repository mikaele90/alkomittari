/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkopaketti;

/**
 *
 * @author Mikael
 */
public class Kontrolleri {
    
    //ominaisuudet
    private Naytto naytto;
    private Kayttaja kayttaja;
    
    //Ajetaan tämä kun main metodi alkaa
    public Kontrolleri() {
        
        naytto = new Naytto();
        kayttaja = new Kayttaja(null, 0, 0); // tämä varmaan turha ainakin tässä vaiheessa
        
        //vedetty suoraan esimerkistä
        naytto.rekisteroiOhjain(this);
        
        //yksikertainen tervehdys
        naytto.aloitusNaytto();
        
        //luodaan käyttäjä
        naytto.luoKayttaja();
        
        //tästä voisi tehdä käyttäjän-pääscreenin
        naytto.kayttajaNaytto();
        
    }
    
    //pyydetään nimi käyttäjäluokasta, jotta voidaan välittää UI-luokkaan
    public String nimi() {
        return kayttaja.getNimi();
    }
    
    //sama kuin yllä
    public double paino() {
        return kayttaja.getPaino();
    }
    
    //sama kuin yllä
    public int sukupuoli() {
        return kayttaja.getSukupuoli();
    }
    
    //metodi, jonka avulla voidaan voidaan välittää UI:sta Kayttaja-luokkaan nimi
    public void uusiNimi(String lisaaNimi) {
        kayttaja.setNimi(lisaaNimi);
    }
    
    //sama kuin yllä
    public void uusiPaino(double lisaaPaino) {
        kayttaja.setPaino(lisaaPaino);
    }
    
    //sama kuin yllä
    public void uusiSukupuoli(int lisaaSukupuoli) {
        kayttaja.setSukupuoli(lisaaSukupuoli);
    }
    
    //main() metodi
    public static void main(String[] args) {
        new Kontrolleri();
    }
    
}
