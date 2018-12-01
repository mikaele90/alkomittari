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
    
    //ominaisuudet
    private String nimi;
    private int sukupuoli;
    private double paino;
    
    //konstruktori 
    public Kayttaja(String nimi, int sukupuoli, double paino) {
        this.nimi = nimi;
        this.sukupuoli = sukupuoli;
        this.paino = paino;
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
    
}
