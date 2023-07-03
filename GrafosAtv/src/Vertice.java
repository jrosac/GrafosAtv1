import java.util.ArrayList;
import java.util.List;

public class Vertice
{
    private int indice;
    private String rotulo;
    private int grau;
    private boolean flag;

    public Vertice(int indice, String rotulo)
    {
        this.indice = indice;
        this.rotulo = rotulo;
        this.grau = 0;
        this.flag = false;
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
    public void incrementarGrau() {
        grau++;
    }

    public void decrementarGrau() {
        grau--;
    }
}
