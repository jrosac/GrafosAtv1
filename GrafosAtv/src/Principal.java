public class Principal {
    public static void main(String[] args)
    {

        Grafo2 grafo1 = new Grafo2(5, false);

        grafo1.adicionarVertice(0,"v1");
        grafo1.adicionarVertice(1,"v2");
        grafo1.adicionarVertice(2,"v3");
        grafo1.adicionarVertice(3,"v4");
        grafo1.adicionarVertice(4,"v5");

        grafo1.adicionarAresta(0,1);// v1 - v2 e1

        grafo1.adicionarAresta(1,2);// v2 - v3 e2
        grafo1.adicionarAresta(2,2);// v3 - v3 e3
        //grafo1.adicionarAresta(2,2);// v3 - v3 e3
        grafo1.adicionarAresta(2,3);// v3 - v4 e4

        grafo1.adicionarAresta(3,1);// v2 - v4 e5
        grafo1.adicionarAresta(3,4);// v4 - v5 e6

        grafo1.adicionarAresta(4,1);// v2 - v5 e7
        grafo1.adicionarAresta(1,4);// v5 - v2 e8

        grafo1.imprimirGrafo2();

/*
        Grafo2 grafo2 = new Grafo2(5, false);

        grafo2.adicionarVertice(0,"v1");
        grafo2.adicionarVertice(1,"v2");
        grafo2.adicionarVertice(2,"v3");
        grafo2.adicionarVertice(3,"v4");
        grafo2.adicionarVertice(4,"v5");

        grafo2.adicionarAresta(0,0);//loop
        grafo2.adicionarAresta(0,1);
        grafo2.adicionarAresta(0,2);
        grafo2.adicionarAresta(0,3);
        grafo2.adicionarAresta(0,4);

        grafo2.adicionarAresta(1,1);//loop
        grafo2.adicionarAresta(1,2);
        grafo2.adicionarAresta(1,3);
        grafo2.adicionarAresta(1,4);

        grafo2.adicionarAresta(2,2);//loop
        grafo2.adicionarAresta(2,3);
        grafo2.adicionarAresta(2,4);

        grafo2.adicionarAresta(3,3);//loop
        grafo2.adicionarAresta(3,4);

        grafo2.adicionarAresta(4,4);//loop

        grafo2.imprimirGrafo2();

        Grafo2 grafo3 = new Grafo2(5, false);
        grafo3.gerarGrafoCompleto(5);
        grafo3.imprimirGrafo2();
        */
    }
}
