public class Principal2
{
    public static void main(String[] args)
    {

        Grafo grafo1 = new Grafo(5, true);

        grafo1.adicionarVertice1(0,"v0");
        grafo1.adicionarVertice1(1,"v1");
        grafo1.adicionarVertice1(2,"v2");
        grafo1.adicionarVertice1(3,"v3");
        grafo1.adicionarVertice1(4,"v4");

        grafo1.adicionarAresta1(0,1);// v1 - v2 e1

        grafo1.adicionarAresta1(1,2);// v2 - v3 e2
        grafo1.adicionarAresta1(1,3);// v2 - v4 e5
        grafo1.adicionarAresta1(1,4);// v2 - v5 e7
        grafo1.adicionarAresta1(4,1);// v5 - v2 e8

        grafo1.adicionarAresta1(2,2);// v3 - v3 e3
        grafo1.adicionarAresta1(2,2);// v3 - v3 e3
        grafo1.adicionarAresta1(2,2);// v3 - v3 e3

        grafo1.adicionarAresta1(2,3);// v3 - v4 e4

        grafo1.adicionarAresta1(3,4);// v4 - v5 e6

        grafo1.imprimirGrafo();

    }
}
