import java.util.ArrayList;
import java.util.List;

class Grafo {
    private boolean matriz;
    private List<Vertice> vertices;
    private int[][] matrizAdjacencia;
    private List<List<Integer>> listaAdjacencia;

    public Grafo(boolean matriz)
    {
        this.matriz = matriz;
        vertices = new ArrayList<>();
        if (matriz)
        {
            matrizAdjacencia = new int[0][0];
        }
        else
        {
            listaAdjacencia = new ArrayList<>();
        }
    }

    public void adicionarVertice(int indice, String rotulo)
    {
        Vertice vertice = new Vertice(indice, rotulo);
        vertices.add(vertice);

        if (matriz)
        {
            atualizarMatrizAdjacencia();
        }
        else
        {
            atualizarListaAdjacencia();
        }
    }

    private void atualizarMatrizAdjacencia()
    {
        int[][] novaMatriz = new int[vertices.size()][vertices.size()];
        for (int i = 0; i < matrizAdjacencia.length; i++)
        {
            System.arraycopy(matrizAdjacencia[i], 0, novaMatriz[i], 0, matrizAdjacencia[i].length);
        }
        matrizAdjacencia = novaMatriz;
    }

    private void atualizarListaAdjacencia() {
        listaAdjacencia.add(new ArrayList<>());
    }

    public void adicionarAresta(int indiceVertice1, int indiceVertice2) {
        if (matriz)
        {
            matrizAdjacencia[indiceVertice1][indiceVertice2] = 1;
            matrizAdjacencia[indiceVertice2][indiceVertice1] = 1;
        } else
        {
            listaAdjacencia.get(indiceVertice1).add(indiceVertice2);
            listaAdjacencia.get(indiceVertice2).add(indiceVertice1);
        }
    }

    public void removerAresta(int indiceVertice1, int indiceVertice2) {
        if (matriz) {
            matrizAdjacencia[indiceVertice1][indiceVertice2] = 0;
            matrizAdjacencia[indiceVertice2][indiceVertice1] = 0;
        } else {
            listaAdjacencia.get(indiceVertice1).remove(Integer.valueOf(indiceVertice2));
            listaAdjacencia.get(indiceVertice2).remove(Integer.valueOf(indiceVertice1));
        }
    }

    public int calcularGrau(int indiceVertice) {
        if (matriz) {
            int grau = 0;
            for (int i = 0; i < matrizAdjacencia[indiceVertice].length; i++) {
                if (matrizAdjacencia[indiceVertice][i] == 1) {
                    grau++;
                }
            }
            return grau;
        } else {
            return listaAdjacencia.get(indiceVertice).size();
        }
    }

    public boolean saoVizinhos(int indiceVertice1, int indiceVertice2) {
        if (matriz) {
            return matrizAdjacencia[indiceVertice1][indiceVertice2] == 1;
        } else {
            return listaAdjacencia.get(indiceVertice1).contains(indiceVertice2);
        }
    }

    public void imprimirGrafo()
    {
        System.out.println("Número de vértices: " + vertices.size());
        System.out.println("Número de arestas: " + contarArestas());
        System.out.println("Arestas:");

        if (matriz) {
            for (int i = 0; i < matrizAdjacencia.length; i++) {
                for (int j = i + 1; j < matrizAdjacencia[i].length; j++) {
                    if (matrizAdjacencia[i][j] == 1) {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        } else {
            for (int i = 0; i < listaAdjacencia.size(); i++) {
                for (int j : listaAdjacencia.get(i)) {
                    if (i < j) {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        }

        System.out.println("Graus dos vértices:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(vertices.get(i).getRotulo() + ": " + calcularGrau(i));
        }
    }

    private int contarArestas() {
        int contador = 0;
        if (matriz) {
            for (int i = 0; i < matrizAdjacencia.length; i++) {
                for (int j = i + 1; j < matrizAdjacencia[i].length; j++) {
                    if (matrizAdjacencia[i][j] == 1) {
                        contador++;
                    }
                }
            }
        } else {
            for (int i = 0; i < listaAdjacencia.size(); i++) {
                for (int j : listaAdjacencia.get(i)) {
                    if (i < j) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
}
