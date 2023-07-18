public class Vertice1
{
    private int indice;
    private String rotulo;
    private int grau;
    private boolean flag;
    private boolean arestaDeRetorno;
    public Vertice1()
    {
        this.indice = 0;
        this.rotulo = "";
        this.grau = 0;
        this.arestaDeRetorno = false;
    }
    public Vertice1(int indice)
    {
    this.indice = indice;
    this.rotulo = "v"+String.valueOf(indice);
    this.grau = 0;
    this.flag = false;
    this.arestaDeRetorno = false;
    }
    public Vertice1(int indice, String rotulo)
    {
        this.indice = indice;
        this.rotulo = rotulo;
        this.grau = 0;
        this.flag = false;
        this.arestaDeRetorno = false;
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {return flag;}
    public int getIndice1() {return indice;}
    public int getGrau1() {return grau;}
    public String getRotulo1() {return rotulo;}
    public void setGrau1(int grau) {this.grau = grau;}
    public void setIndice1(int indice) {this.indice = indice;}
    public void setRotulo1(String rotulo) {this.rotulo = rotulo;}
    public void incrementarGrau1() {grau++;}

    public void decrementarGrau1() {grau--;}
}
