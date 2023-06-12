import java.util.*;

class Grafo<Vertice> {

    // We use Hashmap to store the edges in the grafo
    private Map<Vertice, List<Vertice> > grafo = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertice(Vertice s)
    {
        grafo.put(s, new LinkedList<Vertice>());
    }

    // This function adds the edge
    // between source to destination
    public void addAresta(Vertice source, Vertice destination, boolean bidirectional)
    {

        if (!grafo.containsKey(source))
            addVertice(source);

        if (!grafo.containsKey(destination))
            addVertice(destination);

        grafo.get(source).add(destination);
        if (bidirectional == true) {
            grafo.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                + grafo.keySet().size()
                + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (Vertice v : grafo.keySet()) {
            count += grafo.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has "
                + count
                + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(Vertice s)
    {
        if (grafo.containsKey(s)) {
            System.out.println("The graph contains "
                    + s + " as a vertex.");
        }
        else {
            System.out.println("The graph does not contain "
                    + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(Vertice s, Vertice d)
    {
        if (grafo.get(s).contains(d)) {
            System.out.println("The graph has an edge between "
                    + s + " and " + d + ".");
        }
        else {
            System.out.println("The graph has no edge between "
                    + s + " and " + d + ".");
        }
    }

    // Prints the adjancency list of each vertex.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Vertice v : grafo.keySet()) {
            builder.append(v.toString() + ": ");
            for (Vertice w : grafo.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
}


