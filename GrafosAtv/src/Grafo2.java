import java.util.*;


public class Grafo2 {
    private int numVertices;
    private boolean matriz;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private int numArestas;



    public Grafo2(int numVertices, boolean matriz)
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
            listaAdj = new ArrayList<>();
            for (int i = 0; i < numVertices; i++)
            {
                listaAdj.add(new ArrayList<>());
            }
        }
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
    }


    public void adicionarVertice(int indice, String rotulo)
    {
        Vertice vertice = new Vertice(indice, rotulo);
        vertices.add(vertice);
    }
    public void adicionarVertice(int indice)
    {
        Vertice vertice = new Vertice(indice, "v"+String.valueOf(indice));
        vertices.add(vertice);
    }


    public void adicionarAresta(int origem, int destino)
    {
        if (origem < 0 || origem >= numVertices || destino < 0 || destino >= numVertices)
        {
            throw new IllegalArgumentException("indices de vertices inválidos.");
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
            throw new IllegalArgumentException("indices de vertices inválidos.");
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
            throw new IllegalArgumentException("indice de vertice inválido.");
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

    public boolean saoVizinhos(int indiceVertice1, int indiceVertice2)
    {
        if (indiceVertice1 < 0 || indiceVertice1 >= numVertices || indiceVertice2 < 0 || indiceVertice2 >= numVertices) {
            throw new IllegalArgumentException("indices de vertices inválidos.");
        }

        if (matriz) {
            return matrizAdj[indiceVertice1][indiceVertice2] == 1;
        } else {
            return listaAdj.get(indiceVertice1).contains(indiceVertice2);
        }
    }

    public void imprimirGrafo2()
    {
        System.out.println("Numero de vertices: " + numVertices);
        System.out.println("Numero de arestas: " + numArestas+"\n");

        if (matriz) {
            System.out.println("Estrutura de dados: \nMatriz de Adjacencia");

            for (int a = 0; a < numVertices; a++)
            {
                if(a == 0){System.out.print("Col ");}
                System.out.print(a+" ");
            }
            System.out.println();
            for (int i = 0; i < numVertices; i++)
            {
                System.out.print("L"+i+"  ");
                for (int j = 0; j < numVertices; j++)
                {
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
            System.out.println("Estrutura de dados: \nLista de Adjacencia\n");
            System.out.println("Arestas:");

            for (int x = 0; x < numVertices; x++)
            {
                System.out.print("Vertice " + x + ": ");
                for (int j : listaAdj.get(x))
                {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < numVertices; i++)
            {
                for (int j : listaAdj.get(i))
                {
                    if (j >= i)
                    {
                        System.out.println(vertices.get(i).getRotulo() + " - " + vertices.get(j).getRotulo());
                    }
                }
            }
        }

        System.out.println("\nGrau dos vertices:");
        for (int i = 0; i < numVertices; i++)
        {
            System.out.println(vertices.get(i).getRotulo() + ": " + calcularGrau(i));
        }
        int somador = 0;

        for(int i = 0; i < numVertices; i++)
        {
            somador += calcularGrau(i);
        }
        System.out.println("\nSomatorio do Grau dos Vertices: "+somador);

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
        System.out.println("Vertices de grau impar: "+grauimpar);
        System.out.println("Vertices de grau par:   "+graupar);
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
        if (n <= 0 || k <= 0 || k >= n || (n * k) % 2 != 0)
        {
            throw new IllegalArgumentException("Os valores de n e k devem ser positivos, k deve ser menor que n, e o produto n*k deve ser par.");
        }

        for (int i = 0; i < n; i++)
        {
            adicionarVertice(i, "v"+String.valueOf(i + 1));
        }

        List<Integer> verticesDisponiveis = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            verticesDisponiveis.add(i);
        }

        while (!verticesDisponiveis.isEmpty())
        {
            int vertice = verticesDisponiveis.get(0);
            int grauAtual = calcularGrau(vertice);

            while (grauAtual < k)
            {

                int verticeAleatorio = verticesDisponiveis.get(1);

                if (vertice != verticeAleatorio && calcularGrau(verticeAleatorio) < k)
                {
                    adicionarAresta(vertice, verticeAleatorio);
                    grauAtual++;
                }
            }

            verticesDisponiveis.remove(0);
        }
    }
        public boolean isBipartido(Grafo2 grafo, Set<Integer> X, Set<Integer> Y)
        {
            // Verifica se o grafo e vazio
            if (grafo == null || grafo.numVertices == 0)
            {
                return true;
            }

            // Verifica se os conjuntos X e Y são vazios
            if (X.isEmpty() && Y.isEmpty()) {
                return false;
            }

            // Verifica se todos os vertices pertencem a X ou Y
            for (int i = 0; i < grafo.numVertices; i++)
            {
                if (!X.contains(i) && !Y.contains(i))
                {
                    return false;
                }
            }

            // Verifica se não há arestas entre vertices de X ou entre vertices de Y
            for (int i = 0; i < grafo.numVertices; i++)
            {
                for (int j = i + 1; j < grafo.numVertices; j++)
                {
                    if ((X.contains(i) && X.contains(j)) || (Y.contains(i) && Y.contains(j)))
                    {
                        if (grafo.saoVizinhos(i, j)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }


    int contadorEntrada = 1;
    int contadorSaida = 1;
    List<Aresta> arestasDaArvore = new ArrayList<>();
    List<Aresta> arestasDeRetorno = new ArrayList<>();

    public void buscaEmProfundidade(int verticeAtual, int pai) {
        vertices.get(verticeAtual).setFlag(true);
        vertices.get(verticeAtual).setProfundidadeEntrada(contadorEntrada++);

        System.out.println("Vertice visitado: " + vertices.get(verticeAtual).getIndice());
        for (int proximosVertice : listaAdj.get(verticeAtual))
        {
            if (vertices.get(proximosVertice).getFlag() == false)
            {
                arestasDaArvore.add(new Aresta(proximosVertice, verticeAtual));
                buscaEmProfundidade(proximosVertice, verticeAtual);
            } else {
                if (proximosVertice != pai)
                {
                    arestasDeRetorno.add(new Aresta(proximosVertice, verticeAtual));
                }
            }
        }
        vertices.get(verticeAtual).setProfundidadeSaida(contadorSaida++);

        // Removendo as duplicatas das arestas de retorno
        HashSet<String> arestasUnicas = new HashSet<>();
        List<Aresta> arestasDeRetornoUnicas = new ArrayList<>();
        for (Aresta aresta : arestasDeRetorno)
        {
            String chave1 = aresta.getVertice1()+"-"+aresta.getVertice2();
            String chave2 = aresta.getVertice2()+"-"+aresta.getVertice1();

            if (!arestasUnicas.contains(chave1) && !arestasUnicas.contains(chave2))
            {
                arestasUnicas.add(chave1);
                arestasDeRetornoUnicas.add(aresta);
            }
        }
        arestasDeRetorno = arestasDeRetornoUnicas;
    }
    public void imprimirArestasDeBusca()
    {
        System.out.println("\nArestas de Retorno: ");
        for (Aresta aresta : arestasDeRetorno)
        {
            System.out.println("Aresta "+"v"+String.valueOf(aresta.getVertice1())+" "+"v"+String.valueOf(aresta.getVertice2()));
        }

        System.out.println("\nArestas da Arvore: ");
        for (Aresta aresta : arestasDaArvore)
        {
            System.out.println("Aresta "+"v"+String.valueOf(aresta.getVertice1())+" "+"v"+String.valueOf(aresta.getVertice2()));
        }
    }
    public void imprimirProfundidades()
    {
        System.out.println("Profundidade de Entrada");
        for (Vertice vertice: vertices)
        {
            System.out.println("v"+vertice.getIndice()+": "+vertice.getProfundidadeEntrada());
        }
        System.out.println("\nProfundidade de Saida");
        for (Vertice vertice: vertices)
        {
            System.out.println("v"+vertice.getIndice()+": "+vertice.getProfundidadeSaida());
        }

    }
    public Grafo2 subgrafo(List<Integer> verticesList, List<Aresta> arestasList)
    {
        // Checa se todos os vertices existem no grafo original
        for (int vertice : verticesList)
        {
            if (vertice < 0 || vertice >= numVertices || !(vertices.get(vertice).getIndice() == vertice))
            {
                throw new IllegalArgumentException("Indice de vertice do subgrafo invalido: " + vertice);
            }
        }
        // Testa se todas as arestas do subgrafo existem no grafo original
        for (Aresta aresta : arestasList)
        {
            if (aresta.getVertice1() < 0 || aresta.getVertice1() >= numVertices || aresta.getVertice2() < 0 || aresta.getVertice2() >= numVertices)
            {
                throw new IllegalArgumentException("Aresta ou Vertice invalido");
            }
            // Check if the edge exists in the original graph
            if (!saoVizinhos(aresta.getVertice1(), aresta.getVertice2()))
            {
                throw new IllegalArgumentException("Aresta nao existe no grafo original: "+aresta.getVertice1()+"-"+aresta.getVertice2());
            }
        }
        // Create a new subgraph with the specified vertices and edges
        Grafo2 subgraph = new Grafo2(verticesList.size(), matriz);
        for (int vertice : verticesList)
        {
            subgraph.adicionarVertice(vertice);
        }
        for (Aresta aresta : arestasList)
        {
            subgraph.adicionarAresta(aresta.getVertice1(), aresta.getVertice2());
        }
        return subgraph;
    }
    public Grafo2 subgrafoInduzido(List<Integer> verticesList)
    {
        // Verifica se todos os vértices do conjunto X existem no grafo original
        for (int vertice : verticesList)
        {
            if (vertice < 0 || vertice >= numVertices || !(vertices.get(vertice).getIndice() == vertice))
            {
                throw new IllegalArgumentException("Índice de vértice do subgrafo inválido: " + vertice);
            }
        }

        // Cria um novo subgrafo com os vértices do conjunto X
        Grafo2 subgraph = new Grafo2(verticesList.size(), false);
        for (int vertice : verticesList)
        {
            subgraph.adicionarVertice(vertice, vertices.get(vertice).getRotulo());
        }

        // Adiciona as arestas do subgrafo que existem no grafo original
        for (int i = 0; i < verticesList.size(); i++)
        {
            int vertice1 = verticesList.get(i);

            for (int j = i + 1; j < verticesList.size(); j++)
            {
                int vertice2 = verticesList.get(j);

                if (saoVizinhos(vertice1, vertice2))
                {
                    subgraph.adicionarAresta(vertice1, vertice2);
                }
            }
        }
        return subgraph;
    }

}
