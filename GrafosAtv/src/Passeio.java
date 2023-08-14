import java.util.ArrayList;
import java.util.List;

public class Passeio {
    private List<Integer> sequenciaVertices;
    private List<Aresta> sequenciaArestas;

    public Passeio(List<Integer> sequenciaVertices, List<Aresta> sequenciaArestas) {
        this.sequenciaVertices = sequenciaVertices;
        this.sequenciaArestas = sequenciaArestas;
    }

    public List<Integer> getSequenciaVertices() {
        return sequenciaVertices;
    }

    public List<Aresta> getSequenciaArestas() {
        return sequenciaArestas;
    }

    public void imprimirPasseio() {
        System.out.print("Passeio: ");
        for (int i = 0; i < sequenciaVertices.size(); i++) {
            System.out.print("v" + sequenciaVertices.get(i));
            if (i < sequenciaArestas.size()) {
                System.out.print(" - " + sequenciaArestas.get(i).getRotulo() + " - ");
            }
        }
        System.out.println();
    }
}
