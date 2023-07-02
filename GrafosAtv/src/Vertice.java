import java.util.ArrayList;
import java.util.List;

public class Vertice
{
    private int indice;
    private String rotulo;
    private int grau;

    public Vertice(int indice, String rotulo)
    {
        this.indice = indice;
        this.rotulo = rotulo;
        this.grau = 0;
    }

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
    public void incrementarGrau() {
        grau++;
    }

    public void decrementarGrau() {
        grau--;
    }
}
