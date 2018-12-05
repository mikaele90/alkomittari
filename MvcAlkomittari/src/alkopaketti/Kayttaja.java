package alkopaketti;

public class Kayttaja {
    
    //ominaisuudet
    private String nimi;
    private int sukupuoli;
    private double paino, nesteMaara;
    
    public Kayttaja(String nimi, int sukupuoli, double paino, double nesteMaara) {
        this.nimi = nimi;
        this.sukupuoli = sukupuoli;
        this.paino = paino;
        this.nesteMaara = nesteMaara;
    }
    
    //Tässä luokassa varmaan jonkin verran päällekkäisyyttä, 
    //muttei kuitenkaan mitään, jonka pitäisi mitään hajottaa.
    
    
    //aseta nimi metodi, jota kontrolleri voi kutsua
    public void setNimi(String annettuNimi) {
        this.nimi = annettuNimi;
    }
    
    //sama kuin yllä
    public void setPaino(double annettuPaino) {
        this.paino = annettuPaino;
    }
    
    //sama kuin yllä
    public void setSukupuoli(int annettuSukupuoli) {
        this.sukupuoli = annettuSukupuoli;
    }
    
    public void setNesteMaara() {
        if (this.sukupuoli == 0) {
            this.nesteMaara = 0.75 * paino * 1000;
        }
        else {
            this.nesteMaara = 0.66 * paino * 1000;
        }
    }
    
    //hae nimi -metodi
    public String getNimi() {
        return this.nimi;
    }
    
    //sama
    public double getPaino() {
        return this.paino;
    }
    
    //sama
    public int getSukupuoli() {
        return this.sukupuoli;
    }
    
    public double getNesteMaara() {
        return this.nesteMaara;
    }
    
    
}
