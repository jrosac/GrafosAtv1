public class Principal {
    public static void main(String[] args) {

        //Matriz m01 = new Matriz();

        //System.out.print(m01.toString());

        // Object of graph is created.
        Grafo<Integer> g = new Grafo<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addAresta(0, 1, true);
        g.addAresta(0, 4, true);
        g.addAresta(1, 2, true);
        g.addAresta(1, 3, true);
        g.addAresta(1, 4, true);
        g.addAresta(2, 3, true);
        g.addAresta(3, 4, true);

        // Printing the graph
        System.out.println("Grafo:\n"
                + g.toString());

        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount(true);

        // Tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // Tells whether vertex is present or not
        g.hasVertex(5);

    }
}
