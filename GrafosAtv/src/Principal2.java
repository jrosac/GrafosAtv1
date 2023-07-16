public class Principal2
{
    public static void main(String[] args)
    {

        Grafo grafo1 = new Grafo(5, false);

        grafo1.adicionarVertice1(1);
        grafo1.adicionarVertice1(2);
        grafo1.adicionarVertice1(3);
        grafo1.adicionarVertice1(4);
        grafo1.adicionarVertice1(5);

        grafo1.adicionarAresta1(1,2);// v1 - v2 e1

        grafo1.adicionarAresta1(2,3);// v2 - v3 e2
        grafo1.adicionarAresta1(3,3);// v3 - v3 e3
        //grafo1.adicionarAresta(2,2);// v3 - v3 e3
        grafo1.adicionarAresta1(3,4);// v3 - v4 e4

        grafo1.adicionarAresta1(2,4);// v2 - v4 e5
        grafo1.adicionarAresta1(4,5);// v4 - v5 e6

        grafo1.adicionarAresta1(2,5);// v2 - v5 e7
        grafo1.adicionarAresta1(5,2);// v5 - v2 e8

        grafo1.imprimirGrafo();

    }
}
