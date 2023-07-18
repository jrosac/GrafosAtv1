import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Grafo2 {
    private int numVertices;
    private boolean matriz;
    private int[][] matrizAdj;
    private List<List<Integer>> listaAdj;
    private List<Vertice> vertices;
    public List<Aresta> arestas;
    private int numArestas;



    public Grafo2(int numVertices, boolean matriz) {
        this.numVertices = numVertices;
        this.matriz = matriz;
        this.numArestas = 0;

        if (matriz)
        {
            matrizAdj = new int[numVertices][numVertices];
        } else
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

    public boolean saoVizinhos(int indiceVertice1, int indiceVertice2) {
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
            for (int i = 0; i < grafo.numVertices; i++) {
                if (!X.contains(i) && !Y.contains(i)) {
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
    public void buscaEmProfundidade(int verticeAtual, int pai)
    {
        vertices.get(verticeAtual).setFlag(true);
        vertices.get(verticeAtual).setProfundidadeEntrada(contadorEntrada++);

        System.out.println("Vertice visitado: "+vertices.get(verticeAtual).getIndice());
        for (int proximosVertice : listaAdj.get(verticeAtual))
        {
            if (vertices.get(proximosVertice).getFlag() == false)
            {
                // adicionar aresta da arvore
                //arestas.add(new Aresta(proximosVertice,verticeAtual));
                arestasDaArvore.add(new Aresta(proximosVertice,verticeAtual));
                buscaEmProfundidade(proximosVertice,verticeAtual);

            } else{
                if(proximosVertice != pai)
                {
                    //arestas.add(new Aresta(proximosVertice,verticeAtual));
                    arestasDeRetorno.add(new Aresta(proximosVertice,verticeAtual));
                    //adicionar aresta retorno
                }
            }
        }
        vertices.get(verticeAtual).setProfundidadeSaida(contadorSaida++);
    }


}
