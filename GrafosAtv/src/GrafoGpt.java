import java.util.ArrayList;
import java.util.List;

public class GrafoGpt
{
    private int numVertices;
    private boolean isMatrix;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;

    public GrafoGpt(int numVertices, boolean isMatrix) {
        this.numVertices = numVertices;
        this.isMatrix = isMatrix;

        if (isMatrix) {
            matrizAdj = new int[numVertices][numVertices];
        } else {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                listaAdj.add(new ArrayList<>());
            }
        }
    }
    public void adicionarAresta(int origem, int destino) {
        if (isMatrix) {
            matrizAdj[origem][destino] = 1;
            matrizAdj[destino][origem] = 1; // Se o grafo for não-direcionado, descomente esta linha
        } else {
            listaAdj.get(origem).add(destino);
            listaAdj.get(destino).add(origem); // Se o grafo for não-direcionado, descomente esta linha
        }
    }
    public void imprimirGrafo() {
        if (isMatrix) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(matrizAdj[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Vértice " + i + ": ");
                for (int j : listaAdj.get(i)) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }

}