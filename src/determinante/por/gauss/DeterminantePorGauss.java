package ciencias.pkg1;

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

        int i, j, k, aux = 0, dimension = 0, c, multi = 1;
        double temp = 0;
        dimension = d;

        int pr = 0;

        int counter = 0;

        boolean sePuede = true;

        counter += 3;//asignacion,comparacion final, resta final
        for (i = 0; i < a.length - 1; i++) {
            counter += 3;//comparacion, resta, incremento

            aux = i;
            counter += 1;//asignacion

            counter += 3;//matriz,comparacion final
            while (a[aux][i] == 0) {
                counter += 3;//matriz,comparacion

                aux++;
                counter += 1;//incremento

                counter += 3;//matriz,comparacion
                if (a[aux][i] == 0) {

                    counter += 2;//comparacion, resta 
                    if (aux == dimension - 1) {
                        System.out.println("No se puede desarrollar por Gauss");

                        sePuede = false;
                        counter += 1;//asignacion

                        break;
                    }

                } else {

                    counter += 2;//asignacion, comparacion final 
                    for (c = 0; c < dimension; c++) {
                        counter += 2;//comparacion, incremento

                        temp = a[aux][c];
                        counter += 3;//asignacion,matriz

                        System.out.println(temp);

                        a[aux][c] = a[i][c];
                        counter += 5;//matriz,asignacion,matriz

                        a[i][c] = temp;
                        counter += 3;//matriz,asignacion
                    }

                    multi = multi * -1;
                    counter += 2;//asignacion,multiplicacion

                    aux = i;
                    counter += 1;//asignacion
                }
            }

            counter += 1;//comparacion
            if (sePuede == false) {
                break;
            }

            counter += 3;//asignacion,suma,comparacion
            for (j = i + 1; j < a.length; j++) {
                counter += 2;//comparacion,incremento

                counter += 3;//asignacion,suma,comparacion
                for (k = i + 1; k < a.length; k++) {
                    counter += 2;//comparacion,incremento

                    a[k][j] = a[k][j] - (a[k][i] * a[i][j]) / a[i][i];
                    counter += 14;//matriz,comparacion,matriz,resta,matriz,multiplicacion,matriz,division,matriz
                }

            }
        }

        double traza = 1 * multi;
        counter += 2;//asignacion,multiplicacion

        counter += 2;//asignacion,comparacion
        for (int p = 0; p < a.length; p++) {
            counter += 2;//comparacion,incremento

            traza = traza * m[p][p];
            counter += 4;//asignacion,multiplicacion,matriz
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
