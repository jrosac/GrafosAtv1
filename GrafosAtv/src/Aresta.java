public class Aresta
{
    private int vertice1;
    private int vertice2;
    private String rotulo;

    public Aresta(int vertice1, int vertice2)
    {
        setVertice1(vertice1);
        setVertice2(vertice2);
    }
    public Aresta(int vertice1, int vertice2, String rotulo)
    {
        setVertice1(vertice1);
        setVertice2(vertice2);
        setRotulo(rotulo);
    }

    public int getVertice1() {
        return vertice1;
    }
    public int getVertice2() {
        return vertice2;
    }
    public String getRotulo() {return rotulo;}
    public void setVertice1(int vertice1) {
        this.vertice1 = vertice1;
    }
    public void setVertice2(int vertice2) {
        this.vertice2 = vertice2;
    }

    public void setRotulo(String rotulo) {this.rotulo = rotulo;}

    public void getAresta(Aresta aresta)
    {
        System.out.println("\nAresta "+"v"+String.valueOf(aresta.getVertice1())+" "+"v"+String.valueOf(aresta.getVertice2()));
    }

}
