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
        grafo7.adicionarVertice(0,"u"); // u
        grafo7.adicionarVertice(1,"v"); // v
        grafo7.adicionarVertice(2,"w"); // w
        grafo7.adicionarVertice(3,"x"); // x
        grafo7.adicionarVertice(4,"y"); // y

        grafo7.adicionarAresta(0,1);// a u - v
        grafo7.adicionarAresta(1,2);// b v - w
        grafo7.adicionarAresta(2,3);// c w - x
        grafo7.adicionarAresta(3,4);// d x - y
        grafo7.adicionarAresta(4,0);// e y - u
        grafo7.adicionarAresta(1,4);// f v - y
        grafo7.adicionarAresta(4,1);// g y - v
        grafo7.adicionarAresta(2,4);// h y - w

        System.out.println("\nExercicio 4.6 \n");
        grafo7.imprimirGrafo2();


        List<Integer> VerticesProprios = new ArrayList<>();
        VerticesProprios.add(0); // u
        VerticesProprios.add(1); // v
        VerticesProprios.add(2); // w
        VerticesProprios.add(3); // x

        List<Aresta> ListaDearestas = new ArrayList<>();
        ListaDearestas.add(new Aresta(0, 1)); // a u - v
        ListaDearestas.add(new Aresta(1, 2)); // b v - w
        ListaDearestas.add(new Aresta(2, 3)); // c w - x


        System.out.println("\na) Gerar um subgrafo proprio\nVertices: u, v, w, x\nArestas: a, b, c\n");
        Grafo2 subgrafoProprio = grafo7.subgrafo(VerticesProprios, ListaDearestas);
        subgrafoProprio.imprimirGrafo2(); // subgrafo proprio


        List<Integer> VerticesGeradores = new ArrayList<>();
        VerticesGeradores.add(0); // u
        VerticesGeradores.add(1); // v
        VerticesGeradores.add(2); // w
        VerticesGeradores.add(3); // x
        VerticesGeradores.add(4); // y

        System.out.println("\nb) Gerar um subgrafo gerador\nVertices: u, v, w, x, y\nArestas: a, b, c\n");
        Grafo2 subgrafoGerador = grafo7.subgrafo(VerticesGeradores, ListaDearestas);
        subgrafoGerador.imprimirGrafo2(); // subgrafo gerador

        System.out.println("\nc) Seja X1 = {u, v, w, x}, gerar o subgrafo induzido G[X1]\n");

        Grafo2 grafo8 = new Grafo2(5, false);

        grafo8.adicionarVertice(0,"u"); // u
        grafo8.adicionarVertice(1,"v"); // v
        grafo8.adicionarVertice(2,"w"); // w
        grafo8.adicionarVertice(3,"x"); // x
        grafo8.adicionarVertice(4,"y"); // y

        grafo8.adicionarAresta(0,1);// a u - v
        grafo8.adicionarAresta(1,2);// b v - w
        grafo8.adicionarAresta(2,3);// c w - x
        grafo8.adicionarAresta(3,4);// d x - y
        grafo8.adicionarAresta(4,0);// e y - u
        grafo8.adicionarAresta(1,4);// f v - y
        grafo8.adicionarAresta(4,1);// g y - v
        grafo8.adicionarAresta(2,4);// h y - w

        List<Integer> X1 = new ArrayList<>();
        X1.add(0); // u
        X1.add(1); // v
        X1.add(2); // w
        X1.add(3); // x

        Grafo2 subgrafo8 = grafo8.subgrafoInduzido(X1);
        subgrafo8.imprimirGrafo2();

        System.out.println("\nSeja X2 = {u,w}, gerar G-X\n");
        List<Integer> X2 = new ArrayList<>();
        X2.add(0);
        X2.add(2);

        grafo8.subtrairVertices(X2);
        grafo8.imprimirGrafo2();


        Grafo2 grafo9 = new Grafo2(5, false);

        grafo9.adicionarVertice(0,"u"); // u
        grafo9.adicionarVertice(1,"v"); // v
        grafo9.adicionarVertice(2,"w"); // w
        grafo9.adicionarVertice(3,"x"); // x
        grafo9.adicionarVertice(4,"y"); // y

        grafo9.adicionarAresta(0,1);// a u - v
        grafo9.adicionarAresta(1,2);// b v - w
        grafo9.adicionarAresta(2,3);// c w - x
        grafo9.adicionarAresta(3,4);// d x - y
        grafo9.adicionarAresta(4,0);// e y - u
        grafo9.adicionarAresta(1,4);// f v - y
        grafo9.adicionarAresta(4,1);// g y - v
        grafo9.adicionarAresta(2,4);// h y - w

        System.out.println("\ne) Seja E1 = {a,c,e,g}, gerar o subgrafo aresta-induzido G[E1]\n");

        List<Aresta> E1 = new ArrayList<>();
        E1.add(new Aresta(0, 1)); // a u - v
        E1.add(new Aresta(2, 3)); // c x - w
        E1.add(new Aresta(0, 4)); // e u - y
        E1.add(new Aresta(1, 4)); // g y - v

        Grafo2 arestaInduzido = grafo9.subgrafoArestaInduzido(E1);

        arestaInduzido.imprimirGrafo2();
        System.out.println("\nSeja E2 = {a,b,f}, gerar G-E2\n");
        List<Aresta> E2 = new ArrayList<>();
        E2.add(new Aresta(0, 1)); // a u - v
        E2.add(new Aresta(1, 2)); // b v - w
        E2.add(new Aresta(1, 4)); // f v - y

        grafo9.subtrairArestas(E2);
        grafo9.imprimirGrafo2();


    }
}
