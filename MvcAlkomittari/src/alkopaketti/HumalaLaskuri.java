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
public class HumalaLaskuri {
    
    private Kontrolleri kontrolleri;
    private double promillet = 0;
    private double grammat = 0;
    private double aika = 0;
    private double palaneetGrammat = 0;
    private double henkiloGrammatSekunnissa = 0;
    private double aikaSelvaksi;
    private long alkuhetki;
    private long nykyhetki;
    private long kulunutAika;
    
    
    public HumalaLaskuri() {
        
    }

    public double lisaa(double etanoliGrammat, double nesteMaara) {
        this.grammat = (this.grammat - this.palaneetGrammat) + etanoliGrammat;
        this.promillet = this.grammat / nesteMaara;
        return this.promillet;
    }
    
    public double nautitutGrammat() {
        return this.grammat;
    }
    
    public double palamisAika(double paino) {
        aika = (this.grammat / (paino * 0.1)) * 3600;
        return aika;
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
        this.aikaSelvaksi = (this.grammat - this.palaneetGrammat) / this.henkiloGrammatSekunnissa;
        return this.aikaSelvaksi;
    }
    
}
