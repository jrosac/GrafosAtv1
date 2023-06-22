public class Principal {
    public static void main(String[] args)
    {
        Grafo g = new Grafo(3, false);

        //g.adicionarAresta(1,1);
        //g.adicionarAresta(1,1);

        // 0 1 2

        g.adicionarAresta(1,2);
        g.adicionarAresta(2,3);


        g.imprimirGrafo();

    }
}
