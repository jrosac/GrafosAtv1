public class Principal {
    public static void main(String[] args)
    {
        Grafo2 g = new Grafo2(3, false);

        //g.adicionarAresta(1,1);
        //g.adicionarAresta(1,1);

        // 0 1 2

        g.adicionarVertice(0,"v0");
        g.adicionarVertice(1,"v1");
        g.adicionarVertice(2,"v2");
        g.adicionarAresta(1,1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(1,2);
        g.adicionarAresta(2,2);


        g.imprimirGrafo2();

        g.removerAresta(2,2);
        g.imprimirGrafo2();

    }
}
