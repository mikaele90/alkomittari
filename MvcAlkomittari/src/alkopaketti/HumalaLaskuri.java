package alkopaketti;

public class HumalaLaskuri {
    
    private Kontrolleri kontrolleri;
    private double promillet = 0;
    private double grammatTotal = 0;
    private double grammat = 0;
    private double palamisAika = 0;
    private double palaneetGrammat = 0;
    private double henkiloGrammatSekunnissa = 0;
    private double aikaSelvaksi;
    private long alkuhetki;
    private long nykyhetki;
    private long kulunutAika;
    
    
    public HumalaLaskuri() {
        
    }

    public double lisaa(double etanoliGrammat, double nesteMaara) {
        this.grammatTotal = this.grammatTotal + etanoliGrammat;
        this.promillet = ((this.grammatTotal-this.palaneetGrammat) / nesteMaara);
        return this.promillet;
    }
    

    public double nautitutGrammat() {
        return this.grammatTotal;
    }
    
    public double palamisAika(double paino) {
        palamisAika = (this.grammat / (paino * 0.1)) * 3600;
        return palamisAika;
    }
    
    public double henkiloGrammatSekunnissa(double paino) {
        henkiloGrammatSekunnissa = (paino * 0.1) / 3600;
        return henkiloGrammatSekunnissa;
    }
    
    public long alkuAika() {
        this.alkuhetki = System.currentTimeMillis() / 1000;
        return this.alkuhetki;
    }
    
    public long vierahtanytAika() {
        this.nykyhetki = System.currentTimeMillis() / 1000;
        this.kulunutAika = this.nykyhetki - this.alkuhetki;
        return this.kulunutAika;
    }
    
    public double palaneetGrammat(double paino) {
        palaneetGrammat = this.kulunutAika * henkiloGrammatSekunnissa;
        return palaneetGrammat;
    }   
    
    public double aikaSelvaksi() {
        this.aikaSelvaksi = (this.grammatTotal - this.palaneetGrammat) / this.henkiloGrammatSekunnissa;
        return this.aikaSelvaksi;
    }
    
}
