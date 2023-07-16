import java.util.ArrayList;
import java.util.List;

public class Vertice1
{
    private int indice;
    private String rotulo;
    private int grau;


    public Vertice1()
    {
        this.indice = 0;
        this.rotulo = "";
        this.grau = 0;
    }// Vertice Nulo
    public Vertice1(int indice)
    {
        this.indice = indice;
        this.rotulo = "v"+String.valueOf(indice);
        this.grau = 0;
    }// Vertice (indice, "v"+indice)
    public Vertice1(int indice, String rotulo)
    {
        this.indice = indice;
        this.rotulo = rotulo;
        this.grau = 0;
    }// Vertice (indice, "rotulo"

    public int getIndice1() {return indice;}
    public int getGrau1() {return grau;}
    public String getRotulo1() {return rotulo;}

    public void setGrau1(int grau) {this.grau = grau;}

    public void setIndice1(int indice) {this.indice = indice;}

    public void setRotulo1(String rotulo) {this.rotulo = rotulo;}

    public void incrementarGrau1() {grau++;}

    public void decrementarGrau1() {grau--;}
}
