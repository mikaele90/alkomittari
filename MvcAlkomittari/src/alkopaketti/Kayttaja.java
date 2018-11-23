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
public class Kayttaja {
    
    private String nimi;
    private int sukupuoli;
    //private int kokemus;
    private double paino;
    
    public Kayttaja(String nimi, int sukupuoli, double paino) {
        this.nimi = nimi;
        this.sukupuoli = sukupuoli;
        this.paino = paino;
    }
    
    public void setNimi(String annettuNimi) {
        this.nimi = annettuNimi;
    }
    
    public void setPaino(double annettuPaino) {
        this.paino = annettuPaino;
    }
    
    public void setSukupuoli(int annettuSukupuoli) {
        this.sukupuoli = annettuSukupuoli;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getSukupuoli() {
        return this.sukupuoli;
    }
    
    public double getPaino() {
        return this.paino;
    }
    
}
