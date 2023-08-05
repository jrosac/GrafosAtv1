import java.util.*;

public class Principal {
    public static void main(String[] args)
    {
        /*
        System.out.println("\nGrafo 1 Exercicio 1.8");
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

        System.out.println("\nGrafo 2 Exercicio 1.8");
        Grafo2 grafo2 = new Grafo2(5, false);

        grafo2.adicionarVertice(0,"v1");
        grafo2.adicionarVertice(1,"v2");
        grafo2.adicionarVertice(2,"v3");
        grafo2.adicionarVertice(3,"v4");
        grafo2.adicionarVertice(4,"v5");

        grafo2.adicionarAresta(0,1);
        grafo2.adicionarAresta(0,2);
        grafo2.adicionarAresta(0,3);
        grafo2.adicionarAresta(0,4);

        grafo2.adicionarAresta(1,2);
        grafo2.adicionarAresta(1,3);
        grafo2.adicionarAresta(1,4);

        grafo2.adicionarAresta(2,3);
        grafo2.adicionarAresta(2,4);

        grafo2.adicionarAresta(3,4);


        grafo2.imprimirGrafo2();

        System.out.println("\nExemplo de 2.1");
        Grafo2 grafo3 = new Grafo2(5, false);
        grafo3.gerarGrafoCompleto(5);
        grafo3.imprimirGrafo2();
        if(grafo3.buscaEmProfundidade(1,4)){
            System.out.println("achei o vertice meu patrao");
        }
        else {
            System.out.println("se lascou me nobre, achei foi nada");
        }
        System.out.println("\nExemplo de 2.2");
        Grafo2 grafo4 = new Grafo2(6, false);

        grafo4.gerarGrafoRegular(6,2);

        grafo4.imprimirGrafo2();


        System.out.println("\nExemplo de 2.3");
        Grafo2 grafo5 = new Grafo2(5, false);
        grafo5.adicionarVertice(0, "v1");
        grafo5.adicionarVertice(1, "v2");
        grafo5.adicionarVertice(2, "v3");
        grafo5.adicionarVertice(3, "v4");
        grafo5.adicionarVertice(4, "v5");

        grafo5.adicionarAresta(0, 1);
        grafo5.adicionarAresta(0, 3);
        grafo5.adicionarAresta(1, 2);
        //grafo5.adicionarAresta(1, 4);
        grafo5.adicionarAresta(2, 3);
        grafo5.adicionarAresta(2, 4);



        Set<Integer> X = new HashSet<>();
        Set<Integer> Y = new HashSet<>();
        X.add(0);
        X.add(2);
        Y.add(1);
        Y.add(3);
        Y.add(4);

        if(grafo5.isBipartido(grafo5,X,Y) == true)
        {
            System.out.println("E Bipartido!");
        }
        grafo5.imprimirGrafo2();

        System.out.println("Exemplo do Exercicio 3\n");
        // Nosso grafo comeca no indice 0
        Grafo2 grafo6 = new Grafo2(8,false);

        grafo6.adicionarVertice(0, "a");
        grafo6.adicionarVertice(1, "b");
        grafo6.adicionarVertice(2, "c");
        grafo6.adicionarVertice(3, "d");
        grafo6.adicionarVertice(4, "e");
        grafo6.adicionarVertice(5, "f");
        grafo6.adicionarVertice(6, "g");
        grafo6.adicionarVertice(7, "h");

        grafo6.adicionarAresta(0, 1);// a - b
        grafo6.adicionarAresta(0, 2);// a - c
        grafo6.adicionarAresta(0, 4);// a - e
        grafo6.adicionarAresta(0, 5);// a - f

        grafo6.adicionarAresta(1, 3);// b - d
        grafo6.adicionarAresta(1, 4);// b - e

        grafo6.adicionarAresta(2, 5);// c - f
        grafo6.adicionarAresta(2, 6);// c - g
        grafo6.adicionarAresta(2, 7);// c - h

        grafo6.adicionarAresta(5, 6);// f - g
        grafo6.adicionarAresta(5, 7);// f - h

        grafo6.adicionarAresta(6, 7);// g - h

        grafo6.imprimirGrafo2();

        System.out.println("\nExercicio 3.1: \nBusca em Profundidade");
        grafo6.buscaEmProfundidade(0,0);

        System.out.println("\nExercicio 3.2: ");
        grafo6.imprimirArestasDeBusca();

        System.out.println("\nExercicio 3.3: ");
        grafo6.imprimirProfundidades();
        */

        Grafo2 grafo7 = new Grafo2(5, false);
        grafo7.adicionarVertice(0, "u");
        grafo7.adicionarVertice(1, "v");
        grafo7.adicionarVertice(2, "w");
        grafo7.adicionarVertice(3, "x");
        grafo7.adicionarVertice(4, "y");

        grafo7.adicionarAresta(0, 1);// a u - v
        grafo7.adicionarAresta(1, 2);// b v - w
        grafo7.adicionarAresta(2, 3);// c w - x
        grafo7.adicionarAresta(3, 4);// d x - t
        grafo7.adicionarAresta(4, 0);// e y - u
        grafo7.adicionarAresta(4, 1);// f y - v
        grafo7.adicionarAresta(1, 4);// g v - y
        grafo7.adicionarAresta(4, 2);// h w - y
        grafo7.imprimirGrafo2();

        /*
        List<Integer> ListaDevertices = new ArrayList<>();
        ListaDevertices.add(0);
        ListaDevertices.add(1);
        ListaDevertices.add(2);
        ListaDevertices.add(3);
        ListaDevertices.add(4);

        List<Aresta> ListaDearestas = new ArrayList<>();
        ListaDearestas.add(new Aresta(0, 1));
        ListaDearestas.add(new Aresta(1, 2));
        ListaDearestas.add(new Aresta(1, 4));
        //ListaDearestas.add(new Aresta(1, 2)); // nao esta no grafo original
        //ListaDearestas.add(new Aresta(0, 3)); // nao esta no grafo original

        Grafo2 subgrafo7 = grafo7.subgrafo(ListaDevertices, ListaDearestas);

        subgrafo7.imprimirGrafo2();*/

    }
}
