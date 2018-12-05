package alkopaketti;

public class Kontrolleri {
    
    //ominaisuudet
    final private Naytto naytto;
    final private Kayttaja kayttaja;
    final private Juomat juomat;
    final private HumalaLaskuri laskuri;
    
    //Ajetaan tämä kun main metodi alkaa
    public Kontrolleri() {
        
        naytto = new Naytto();
        kayttaja = new Kayttaja(null, 0, 0, 0);
        juomat = new Juomat();
        laskuri = new HumalaLaskuri();
        
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
    
    public double nesteMaara() {
        return kayttaja.getNesteMaara();
    }
    
    public double juo(int juomaIndex) {
        return juomat.getAlcGrammat(juomaIndex);
    }
    
    public double promillet(double alcGrammat, double nesteMaara) {
        return laskuri.lisaa(alcGrammat, nesteMaara);
    }
    
    public double juodutGrammat() {
        return laskuri.nautitutGrammat();
    }
    
    public double henkiloBurnRate(double paino) {
        return laskuri.henkiloGrammatSekunnissa(paino);
    }
    
    public double palaneetGrammat() {
        return laskuri.palaneetGrammat();
    }
    
    public long alkuhetki() {
        return laskuri.alkuAika();
    }
    
    public long kulunutAikaTotal() {
        return laskuri.vierahtanytAikaTotal();
    }
    
    public double aikaKunnesSelva() {
        return laskuri.aikaSelvaksi();
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
    
    public void uusiNesteMaara() {
        kayttaja.setNesteMaara();
    }
    
    //main() metodi
    public static void main(String[] args) {
        new Kontrolleri();
    }
    
}
