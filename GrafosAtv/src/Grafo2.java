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
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices)
        {
            throw new IllegalArgumentException("Índices de vértices inválidos.");
        }
        if (matriz)
        {
            if (origem == destino)
            {
                matrizAdj[origem][destino] = 2;
            }
            else
            {
                matrizAdj[origem][destino] = 1;
                matrizAdj[destino][origem] = 1;
            }

        } else
        {
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
        vertices.get(origem).incrementarGrau();
        vertices.get(destino).incrementarGrau();
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
        vertices.get(origem).decrementarGrau();
        vertices.get(destino).decrementarGrau();

        numArestas--;
    }

    public int calcularGrau(int indiceVertice)
    {
        if (indiceVertice < 0 || indiceVertice >= numVertices) {
            throw new IllegalArgumentException("Índice de vértice inválido.");
        }
        int grau = 0;
        if (matriz) {
            for (int i = 0; i < numVertices; i++)
            {
                grau += matrizAdj[indiceVertice][i];
            }
            return grau;
        } else
        {
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

    public void imprimirGrafo2()
    {
        System.out.println("Número de vértices: " + numVertices);
        System.out.println("Número de arestas: " + numArestas+"\n");

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
            System.out.println();

        } else {
            System.out.println("Estrutura de dados: \nLista de Adjacência\n");
            System.out.println("Arestas:");

            for (int x = 0; x < numVertices; x++)
            {
                System.out.print("Vértice " + x + ": ");
                for (int j : listaAdj.get(x))
                {
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
        for (int i = 0; i < numVertices; i++)
        {
            System.out.println(vertices.get(i).getRotulo() + ": " + calcularGrau(i));
        }
        int somador = 0;

        for(int i = 0; i < numVertices; i++)
        {
            somador += calcularGrau(i);
        }
        System.out.println("\nSomatório do Grau dos Vértices: "+somador);

        int grauimpar = 0;
        int graupar = 0;
        for (int i = 0; i < numVertices; i++)
        {
            if((calcularGrau(i))%2 != 0)
            {
                grauimpar++;
            }
            if((calcularGrau(i))%2 == 0)
            {
                graupar++;
            }
        }
        System.out.println("Vértices de grau ímpar: "+grauimpar);
        System.out.println("Vértices de grau par:   "+graupar);
    }
    public void gerarGrafoCompleto(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O valor de n deve ser maior que 0.");
        }

        for (int i = 0; i < n; i++) {
            adicionarVertice(i, "v"+String.valueOf(i+1));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                adicionarAresta(i, j);
            }
        }
    }
    public void gerarGrafoRegular(int n, int k)
    {
        if (n <= 0 || k <= 0)
        {
            throw new IllegalArgumentException("Os valores de n e k devem ser maiores que 0.");
        }

        if (n < k || (n * k) % 2 != 0)
        {
            throw new IllegalArgumentException("Não é possível gerar um grafo k-regular de ordem n com os valores fornecidos.");
        }

        // Limpa o grafo atual, se houver algum
        numVertices = 0;
        numArestas = 0;
        vertices.clear();

        // Adiciona os vértices ao grafo
        for (int i = 0; i < n; i++)
        {
            adicionarVertice(i, "v" + (i + 1));
        }

        // Cria uma lista auxiliar para armazenar os vértices disponíveis para conexão
        List<Integer> disponiveis = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            disponiveis.add(i);
        }

        // Conecta os vértices para formar um grafo k-regular
        for (int i = 0; i < n; i++)
        {
            int grauAtual = calcularGrau(i);
            int verticesRestantes = k - grauAtual;

            while (verticesRestantes > 0)
            {
                // Escolhe aleatoriamente um vértice disponível para conexão
                int index = (int) (Math.random() * disponiveis.size());
                int j = disponiveis.get(index);

                // Verifica se a conexão não forma uma aresta já existente
                if (i != j && !saoVizinhos(i, j)) {
                    adicionarAresta(i, j);
                    verticesRestantes--;
                }

                // Remove o vértice conectado da lista de disponíveis
                disponiveis.remove(index);
            }

            // Adiciona novamente os vértices disponíveis para a próxima iteração
            disponiveis.add(disponiveisRestantes.get(i));
        }
    }

}
