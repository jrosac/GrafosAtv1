import java.util.ArrayList;
import java.util.List;

public class Grafo
{
    private int numVertices;
    private boolean Matriz;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;

    public Grafo(int numVertices, boolean Matriz) {
        this.numVertices = numVertices;
        this.Matriz = Matriz;

        if (Matriz) {
            matrizAdj = new int[numVertices][numVertices];
        } else {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++)
            {
                listaAdj.add(new ArrayList<>());
            }
        }
    }
    public void adicionarAresta(int origem, int destino) {
        if (Matriz) {
            matrizAdj[origem][destino] = 1;
            matrizAdj[destino][origem] = 1;
        } else {
            listaAdj.get(origem).add(destino);
            listaAdj.get(destino).add(origem);
        }
    }
    public void imprimirGrafo() {
        if (Matriz) {
            System.out.println();
            for (int a = 0; a < numVertices; a++)
            {
                if(a == 0){System.out.print("Col ");}
                System.out.print(a+" ");
            }
            System.out.println();
            for (int i = 0; i < numVertices; i++) {
                System.out.print("L"+i+"  ");
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