import java.util.ArrayList;
import java.util.List;

public class Vertice
{
    private int indice;
    private String rotulo;
    private int grau;
    private boolean flag;
    private int profundidadeEntrada;
    private int profundidadeSaida;
    public Vertice(int indice, String rotulo)
    {
        this.indice = indice;
        this.rotulo = rotulo;
        this.grau = 0;
        this.flag = false;
        this.profundidadeEntrada = 1;
        this.profundidadeSaida = 1;
    }
    public Vertice(int indice)
    {
        this.indice = indice;
        this.rotulo = "v"+String.valueOf(indice);
        this.grau = 0;
        this.flag = false;
        this.profundidadeEntrada = 1;
        this.profundidadeSaida = 1;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {return flag;}

    public int getIndice()
    {
        return indice;
    }
    public int getGrau()
    {
        return grau;
    }

    public String getRotulo()
    {
        return rotulo;
    }
    public int getProfundidadeEntrada(){return profundidadeEntrada;}
    public int getProfundidadeSaida(){return profundidadeSaida;}
    public void incrementarGrau() {
        grau++;
    }

    public void decrementarGrau() {
        grau--;
    }

    public void setProfundidadeEntrada(int profundidadeEntrada) {
        this.profundidadeEntrada = profundidadeEntrada;
    }

    public void setProfundidadeSaida(int profundidadeSaida) {
        this.profundidadeSaida = profundidadeSaida;
    }
}
