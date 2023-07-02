import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private int numVertices;
    private boolean matriz;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;
    private List<Vertice> vertices;
    private int numArestas;

    public Grafo(int numVertices, boolean matriz) {
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
            if (origem == destino) {
                matrizAdj[origem][destino] = 2;
            } else {
                matrizAdj[origem][destino] = 1;
                matrizAdj[destino][origem] = 1;
            }
        } else {
            if (origem == destino) {
                listaAdj.get(origem).add(destino);
            } else {
                listaAdj.get(origem).add(destino);
                listaAdj.get(destino).add(origem);
            }
        }
        vertices.get(origem).incrementarGrau();
        vertices.get(destino).incrementarGrau();
        numArestas++;
    }

    public void removerAresta(int origem, int destino) {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices) {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }

        if (matriz) {
            matrizAdj[origem][destino] = 0;
            matrizAdj[destino][origem] = 0;
        } else {
            listaAdj.get(origem).remove(Integer.valueOf(destino));
            listaAdj.get(destino).remove(Integer.valueOf(origem));
        }
        vertices.get(origem).decrementarGrau();
        vertices.get(destino).decrementarGrau();

        numArestas--;
    }

    public int calcularGrau(int indiceVertice) {
        if (indiceVertice < 0 || indiceVertice >= numVertices) {
            throw new IllegalArgumentException("Índice de vértice inválido.");
        }
        int grau = 0;
        if (matriz) {
            for (int i = 0; i < numVertices; i++) {
                grau += matrizAdj[indiceVertice][i];
            }
            return grau;
        } else {
            return vertices.get(indiceVertice).getGrau();
        }
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
        System.out.println("Número de arestas: " + numArestas + "\n");

        if (matriz) {
            System.out.println("Estrutura de dados: \nMatriz de Adjacência");

            for (int a = 0; a < numVertices; a++) {
                if (a == 0) {
                    System.out.print("Col ");
                }
                System.out.print(a + " ");
            }
            System.out.println();
            for (int i = 0; i < numVertices; i++) {
                System.out.print("L" + i + "  ");
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
            System.out.println();
        } else {
            System.out.println("Estrutura de dados: \nLista de Adjacência\n");
            System.out.println("Arestas:");

            for (int x = 0; x < numVertices; x++) {
                System.out.print("Vértice " + x + ": ");
                for (int j : listaAdj.get(x)) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < numVertices; i++) {
                for (int j : listaAdj.get(i)) {
                    if (j >= i) {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        }

        System.out.println("\nGrau dos vértices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices.get(i).getRotulo() + ": " + calcularGrau(i));
        }
        int somador = 0;

        for (int i = 0; i < numVertices; i++) {
            somador += calcularGrau(i);
        }
        System.out.println("\nSomatório do Grau dos Vértices: " + somador);

        int grauimpar = 0;
        int graupar = 0;
        for (int i = 0; i < numVertices; i++) {
            if ((calcularGrau(i)) % 2 != 0) {
                grauimpar++;
            }
            if ((calcularGrau(i)) % 2 == 0) {
                graupar++;
            }
        }
        System.out.println("\nGrau ímpar: " + grauimpar);
        System.out.println("\nGrau par: " + graupar);
    }

    public static void gerarGrafoRegular(int numVertices, int grau) {
        if (numVertices <= 0 || grau <= 0 || grau >= numVertices) {
            throw new IllegalArgumentException("Número de vértices ou grau inválido.");
        }
        if (numVertices * grau % 2 != 0) {
            throw new IllegalArgumentException("Combinação inválida de vértices e grau.");
        }

        Grafo2 grafo = new Grafo2(numVertices, false);

        for (int i = 0; i < numVertices; i++)
        {
            grafo.adicionarVertice(i, "V" + i);
        }

        List<Integer> sequencia = new ArrayList<>();

        for (int i = 0; i < numVertices; i++)
        {
            for (int j = 0; j < grau; j++) {
                sequencia.add(i);
            }
        }

        boolean gerado = false;
        while (!gerado) {
            java.util.Collections.shuffle(sequencia);

            boolean valido = true;
            for (int i = 0; i < numVertices; i++) {
                int contador = 0;
                for (int j = 0; j < grau; j++) {
                    if (grafo.calcularGrau(i) < grau && grafo.calcularGrau(sequencia.get(contador)) < grau
                            && i != sequencia.get(contador) && !grafo.saoVizinhos(i, sequencia.get(contador))) {
                        grafo.adicionarAresta(i, sequencia.get(contador));
                        contador++;
                    } else {
                        valido = false;
                        break;
                    }
                }
                if (!valido) {
                    break;
                }
            }
            if (valido) {
                gerado = true;
            } else {
                grafo = new Grafo2(numVertices, false);
                for (int i = 0; i < numVertices; i++) {
                    grafo.adicionarVertice(i, "V" + i);
                }
            }
        }

        grafo.imprimirGrafo2();
    }

}