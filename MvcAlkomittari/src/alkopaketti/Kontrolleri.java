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
    
    private Naytto naytto;
    private Kayttaja kayttaja;
    
    public Kontrolleri() {
        
        naytto = new Naytto();
        kayttaja = new Kayttaja(null, 0, 0);
        
        naytto.rekisteroiOhjain(this);
        
        naytto.aloitusNaytto();
        
        naytto.luoKayttaja();
        
        naytto.kayttajaNaytto();
        
    }
    
        public String nimi() {
        return kayttaja.getNimi();
    }
    
    public double paino() {
        return kayttaja.getPaino();
    }
    
    public int sukupuoli() {
        return kayttaja.getSukupuoli();
    }
    
    public void uusiNimi(String lisaaNimi) {
        kayttaja.setNimi(lisaaNimi);
    }
    
    public void uusiPaino(double lisaaPaino) {
        kayttaja.setPaino(lisaaPaino);
    }
    
    public void uusiSukupuoli(int lisaaSukupuoli) {
        kayttaja.setSukupuoli(lisaaSukupuoli);
    }
    
    public static void main(String[] args) {
        new Kontrolleri();
    }
    
}
