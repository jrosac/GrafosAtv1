import java.util.*;


public class Grafo
{
    private int numVertices;
    private int numArestas;
    private boolean matriz;
    private int[][] matrizAdj;
    private Map<Vertice1, List<Vertice1>> listaAdj;
    private List<Vertice1> vertices;

    public int getNumArestas() {return numArestas;}
    public int getNumVertices() {return numVertices;}
    public boolean getMatriz(){return matriz;}

    public Grafo(boolean matriz)
    {
        this.numVertices = 0;
        this.matriz = matriz;
        this.numArestas = 0;

        if (matriz)
        {
            matrizAdj = new int[numVertices][numVertices];
        }
        else
        {
            listaAdj = new HashMap<>();
            vertices = new ArrayList<>();
            listaAdj.put(null,vertices);

        }
    }//Cria oGrafo Nulo

    public Grafo(int numVertices, boolean matriz)
    {
        this.numVertices = numVertices;
        this.matriz = matriz;
        this.numArestas = 0;

        if (matriz)
        {
            matrizAdj = new int[numVertices][numVertices];
        }
        else
        {
            listaAdj = new HashMap<>();
            vertices = new ArrayList<>();
            for (int i = 1; i <= numVertices; i++)
            {
                Vertice1 vertice = new Vertice1(i);
                listaAdj.put(vertice, vertices);
            }
        }
    }

    public List<Vertice1> getVertice(int indice)
    {
        return listaAdj.get(indice);
    }
    public Set<Vertice1> getVertices()
    {
        return listaAdj.keySet();
    }
    public void adicionarVertice1(int indice)
    {
        Vertice1 vertice = new Vertice1(indice);
        listaAdj.put(vertice, new ArrayList<>());
        vertices.add(vertice);
        numVertices++;
    }
    public void removerVertice1(int indice)
    {
        Vertice1 vertice = vertices.get(indice - 1);
        vertices.set(indice - 1, null);
        listaAdj.remove(vertice);
        for (List<Vertice1> vizinhos : listaAdj.values())
        {
            vizinhos.removeIf(v -> v != null && v.equals(vertice));
        }
        numVertices--;
    }
    public void adicionarAresta1(int origem, int destino)
    {
        // -1 pois indices comecam em 1
        Vertice1 verticeOrigem  = vertices.get(origem - 1);
        Vertice1 verticeDestino = vertices.get(destino - 1);

        listaAdj.get(verticeOrigem).add(verticeDestino);

        numArestas++;
    }

    public void removerAresta1(int origem, int destino)
    {
        // -1 pois indices comecam em 1
        Vertice1 verticeOrigem  = vertices.get(origem - 1);
        Vertice1 verticeDestino = vertices.get(destino - 1);

        List<Vertice1> vizinhos = listaAdj.get(verticeOrigem);
        vizinhos.remove(verticeDestino);

        numArestas--;
    }
    public void imprimirGrafo()
    {
        for (Vertice1 vertice : vertices)
        {
            System.out.print(vertice.getRotulo1() + " -> ");
            List<Vertice1> vizinhos = listaAdj.get(vertice);
            for (Vertice1 vizinho : vizinhos) {
                System.out.print(vizinho.getRotulo1() + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
/*
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
    }*/

}