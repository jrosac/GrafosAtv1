import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome;
    private int indice;
    private List<Vertice> vizinhos;

    public Vertice(int indice, String nome)
    {
        this.nome = nome;
        this.indice = indice;
        this.vizinhos = new ArrayList<>();
    }

    public String getnome() {
        return nome;
    }

    public int getIndice() {
        return indice;
    }

    public void addVizinho(Vertice vizinho) {
        vizinhos.add(vizinho);
    }

    public List<Vertice> getVizinhos() {
        return vizinhos;
    }
}