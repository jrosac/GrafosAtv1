import java.util.ArrayList;
import java.util.List;

public class Vertice
{
    private int indice;
    private String rotulo;

    public Vertice(int indice, String rotulo) {
        this.indice = indice;
        this.rotulo = rotulo;
    }

    public int getIndice() {
        return indice;
    }

    public String getRotulo() {
        return rotulo;
    }
}
