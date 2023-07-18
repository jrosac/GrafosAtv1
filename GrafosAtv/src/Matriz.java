import java.util.Scanner;

public class Matriz {
    private int[][] mat;
    private int numerodelinhas;
    private int numerodecolunas;

    public Matriz(int nlinhas, int ncolunas) // cria uma matriz com todos os valores 1
    {
        numerodelinhas = nlinhas;
        numerodecolunas = ncolunas;
        mat = new int[numerodelinhas][numerodecolunas];

        for(int i = 0; i < numerodelinhas; i++)
        {
            for(int j = 0; j < numerodecolunas ;j++)
            {
                mat[i][j] = 1;
            }
        }
    }

    public Matriz()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.print("Digite o numero de linhas: "); numerodelinhas = teclado.nextInt();
        System.out.print("Digite o numero de colunas: "); numerodecolunas = teclado.nextInt();
        mat = new int[numerodelinhas][numerodecolunas];
        for(int i = 0; i < numerodelinhas; i++)
        {
            for(int j = 0; j < numerodecolunas; j++)
            {
                System.out.print("Item ("+i+","+j+"): ");
                mat[i][j] = teclado.nextInt();
            }
        }
    }
    private void adicionarElemento(int elemento, int i, int j)
    {
        mat[i][j] = elemento;
    }

    public String toString()
    {
        String es = new String();

        for(int i = 0; i < numerodelinhas; i++)
        {
            for(int j = 0; j < numerodecolunas; j++)
            {
                es += " "+ (int)mat[i][j];
            }
            es += '\n';
        }
        System.out.println();
        System.out.println("sua matriz: ");
        return es;
    }

}



