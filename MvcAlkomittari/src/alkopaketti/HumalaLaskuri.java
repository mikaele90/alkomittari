package alkopaketti;

public class HumalaLaskuri {
    
    private Kontrolleri kontrolleri;
    private double promillet = 0;
    private double grammatTotal = 0;
    private double grammatNyt = 0;
    private double palaneetGrammat = 0;
    private double henkiloGrammatSekunnissa = 0;
    private double aikaSelvaksi = 0;
    private long alkuhetki, nykyhetki, kulunutAikaTotal;
    
    
    public HumalaLaskuri() {       
    }

    //Laskee promillet
    public double lisaa(double etanoliGrammat, double nesteMaara) {
        this.grammatTotal = this.grammatTotal + etanoliGrammat;
        this.grammatNyt = this.grammatTotal - this.palaneetGrammat;
        this.promillet = this.grammatNyt / nesteMaara;
        return this.promillet;
    }
    
    //Pitää kirjaa, debug
    public double nautitutGrammat() {
        return this.grammatTotal;
    }
    
    //Laskee henkilön polttamat alkoholigrammat per sekunti
    public double henkiloGrammatSekunnissa(double paino) {
        henkiloGrammatSekunnissa = (paino * 0.1) / 3600;
        return henkiloGrammatSekunnissa;
    }
    
    //Alustaa kellon
    public long alkuAika() {
        this.alkuhetki = System.currentTimeMillis() / 1000;
        return this.alkuhetki;
    }
    
    //Ottaa aikaa kellon alustuksesta lähtien
    public long vierahtanytAikaTotal() {
        this.nykyhetki = System.currentTimeMillis() / 1000;
        this.kulunutAikaTotal = this.nykyhetki - this.alkuhetki;
        return this.kulunutAikaTotal;
    }
    
    //Laskee palaneet alkoholigrammat yhteensä
    public double palaneetGrammat() {
        palaneetGrammat = this.kulunutAikaTotal * henkiloGrammatSekunnissa;
        return palaneetGrammat;
    }   
    
    //Laskee sekunnit, kunnes käyttäjä selvinpäin
    public double aikaSelvaksi() {
        this.aikaSelvaksi = this.grammatNyt / this.henkiloGrammatSekunnissa;
        return this.aikaSelvaksi;
    }
    
}
