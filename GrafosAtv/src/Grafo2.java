import java.util.ArrayList;
import java.util.List;

public class Grafo2 {
    private int numVertices;
    private boolean matriz;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;
    private List<Vertice> vertices;
    private int numArestas;

    public Grafo2(int numVertices, boolean matriz) {
        this.numVertices = numVertices;
        this.matriz = matriz;
        this.numArestas = 0;

        if (matriz) {
            matrizAdj = new int[numVertices][numVertices];
        } else {
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                listaAdj.add(new ArrayList<>());
            }
        }

        vertices = new ArrayList<>();
    }

    public void adicionarVertice(int indice, String rotulo) {
        Vertice vertice = new Vertice(indice, rotulo);
        vertices.add(vertice);
    }

    public void adicionarAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        if (matriz) {
            if (origem == destino)
            {
                matrizAdj[origem][destino] = 2;
            }
            else
            {
                matrizAdj[origem][destino] = 1;
                matrizAdj[destino][origem] = 1;
            }

        } else {
            if (origem == destino)
            {
                listaAdj.get(origem).add(destino);
            }
            else
            {
                listaAdj.get(origem).add(destino);
                listaAdj.get(destino).add(origem);
            }
        }
        numArestas++;
    }

    public void removerAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices)
        {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        if (matriz) {
            matrizAdj[origem][destino] = 0;
            matrizAdj[destino][origem] = 0;
        } else {
            listaAdj.get(origem).remove(Integer.valueOf(destino));
            listaAdj.get(destino).remove(Integer.valueOf(origem));
        }

        numArestas--;
    }

    public int calcularGrau(int indiceVertice) {
        if (indiceVertice < 0 || indiceVertice >= numVertices) {
            throw new IllegalArgumentException("Índice de vértice inválido.");
        }

        int grau = 0;

        if (matriz)
        {
            for (int i = 0; i < numVertices; i++) {
                grau += matrizAdj[indiceVertice][i];
            }
        }
        else
        {
            grau = listaAdj.get(indiceVertice).size();
        }

        return grau;
    }

    public boolean saoVizinhos(int indiceVertice1, int indiceVertice2) {
        if (indiceVertice1 < 0 || indiceVertice1 >= numVertices || indiceVertice2 < 0 || indiceVertice2 >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        if (matriz) {
            return matrizAdj[indiceVertice1][indiceVertice2] == 1;
        } else {
            return listaAdj.get(indiceVertice1).contains(indiceVertice2);
        }
    }

    public void imprimirGrafo2() {
        System.out.println("Número de vértices: " + numVertices);
        System.out.println("Número de arestas: " + numArestas);

        if (matriz) {
            System.out.println("Estrutura de dados: \nMatriz de Adjacência");

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
            System.out.println("Arestas:");
            for (int i = 0; i < numVertices; i++) {
                for (int j = i + 1; j < numVertices; j++) {
                    if (matrizAdj[i][j] == 1) {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        } else {
            System.out.println("Estrutura de dados: \nLista de Adjacência");
            System.out.println("Arestas:");

            for (int x = 0; x < numVertices; x++)
            {
                System.out.print("Vértice " + x + ": ");
                for (int j : listaAdj.get(x)) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < numVertices; i++) {
                for (int j : listaAdj.get(i)) {
                    if (j > i) {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        }

        System.out.println("Grau dos vértices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices.get(i).getRotulo() + ": " + calcularGrau(i));
        }
        System.out.println("\n");
    }
}
