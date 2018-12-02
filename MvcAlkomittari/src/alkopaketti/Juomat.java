package alkopaketti;

public class Juomat {
    
    private String nimi;
    private double tilavuus, alcProsentit, alcGrammat;
    
    public Juomat() {
    }
    
    public double getAlcGrammat(int juomanIndex) {
        
        switch (juomanIndex) {
            case 0:
                this.nimi = "Normibisse (" + tilavuus + "cl," + alcProsentit + "%)";
                this.tilavuus = 0.33;
                this.alcProsentit = 4.6;
                this.alcGrammat = 10*0.79*alcProsentit*tilavuus;
                return this.alcGrammat;
            case 1:
                this.nimi = "Neloskalja (" + tilavuus + "cl," + alcProsentit + "%)";
                this.tilavuus = 0.4;
                this.alcProsentit = 5.5;
                this.alcGrammat = 10*0.79*alcProsentit*tilavuus;
                return this.alcGrammat;
            case 2:
                this.nimi = "Viinilasi (" + tilavuus + "cl," + alcProsentit + "%)";
                this.tilavuus = 0.12;
                this.alcProsentit = 12;
                this.alcGrammat = 10*0.79*alcProsentit*tilavuus;
                return this.alcGrammat;
            case 3:
                this.nimi = "Shotti (" + tilavuus + "cl," + alcProsentit + "%)";
                this.tilavuus = 0.04;
                this.alcProsentit = 38;
                this.alcGrammat = 10*0.79*alcProsentit*tilavuus;
                return this.alcGrammat;
            case 4:
                this.nimi = "Käsidesi (" + tilavuus + "cl," + alcProsentit + "%)";
                this.tilavuus = 0.1;
                this.alcProsentit = 70;
                this.alcGrammat = 10*0.79*alcProsentit*tilavuus;
                return this.alcGrammat;
            default:
                this.nimi = "Lopetus";
                this.tilavuus = 0;
                this.alcProsentit = 0;
                this.alcGrammat = 0;
                return this.alcGrammat;
        }

    }
    
}
