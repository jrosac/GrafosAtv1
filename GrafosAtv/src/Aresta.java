public class Aresta
{
    private int vertice1;
    private int vertice2;

    public Aresta(int vertice1, int vertice2)
    {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public int getVertice1() {
        return vertice1;
    }
    public int getVertice2() {
        return vertice2;
    }
    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }
    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    public void getAresta(Aresta aresta)
    {
        System.out.println("\nAresta "+"v"+String.valueOf(aresta.getVertice1())+" "+"v"+String.valueOf(aresta.getVertice2()));
    }

}
