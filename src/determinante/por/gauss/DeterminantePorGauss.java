package determinante.por.gauss;

//William Nicolas

public class DeterminantePorGauss {

    public static double[][] generarMatriz(int n) {
        double[][] m = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (int) (Math.random() * 10);
            }
        }
        return m;
    }

    public static double gauss(double m[][], int d) {
        double a[][] = m;

        int i, j, k, aux = 0, dimension = 0, c,multi=1;
        double temp = 0;
        dimension = d;
        
        int pr=0;
        
        boolean sePuede = true;

        for (i = 0; i < a.length - 1; i++) {

            aux = i;

            while (a[aux][i] == 0) {
                
                aux++;
                if (a[aux][i] == 0) {
                    

                    if (aux == dimension - 1) {
                        System.out.println("No se puede desarrollar por Gauss");
                        sePuede = false;
                        break;
                    }

                } else {
                    for (c = 0; c < dimension; c++) {
                        temp = a[aux][c];
                        System.out.println(temp);
                        a[aux][c] = a[i][c];
                        a[i][c] = temp;
                    }
                    multi=multi*-1;
                    aux = i;
                }
            }

            if (sePuede == false) {
                break;
            }

            for (j = i + 1; j < a.length; j++) {
                for (k = i + 1; k < a.length; k++) {
                    a[k][j] = a[k][j] - (a[k][i] * a[i][j]) / a[i][i];
                }

            }
        }

        double traza = 1*multi;
        for (int p = 0; p < a.length; p++) {
            traza = traza * m[p][p];
        }

        return traza;

    }

    public static void main(String[] args) {

        double prueba[][] = {
            {4, 4, 6, 2},
            {1, 1, 7, 3},
            {2, 2, 4, 2},
            {1, 1, 3, 5},};

        int n = 4;
        double aleatoria[][] = generarMatriz(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(aleatoria[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println(gauss(aleatoria, n));
    }

}
