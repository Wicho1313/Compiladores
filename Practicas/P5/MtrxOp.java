public class MtrxOp{

public static Matriz multiplicacion(Matriz matrizA, Matriz matrizB){
        double[][] A = matrizA.getNumeros();
        double[][] B = matrizB.getNumeros();
        double[][] C = new double[0][0];
        if(A[0].length == B.length){
            C = new double[A.length][B[0].length];
            for(int i = 0; i<C.length; i++)
                for(int j = 0; j<C[0].length; j++){
                    C[i][j]=0;
                    for(int k = 0; k < A[0].length; k++){
                        C[i][j] += A[i][k]*B[k][j];
                    }
                }             
        }
        Matriz matrizC = new Matriz();
        matrizC.setNumeros(C);
        return matrizC;
    }
    
    public static Matriz multiplicacion(double A, Matriz matrizB){
        double[][] B = matrizB.getNumeros();
        for(int i = 0; i < B.length; i++)
            for(int j = 0; j < B[i].length; j++)
                B[i][j] = B[i][j]*A;
        matrizB.setNumeros(B);
        return matrizB;
    }    
    
    public static Matriz suma(Matriz matrizA, Matriz matrizB){
        double[][] A = matrizA.getNumeros();
        double[][] B = matrizB.getNumeros();
        double[][] C = new double[0][0];
        if(A.length == B.length && A.length > 0)
            if(A[0].length == B[0].length){
                C = new double[A.length][A[0].length];
                for(int i = 0; i <A.length; i++)
                    for(int j = 0; j<A[0].length; j++)
                        C[i][j] = A[i][j]+B[i][j];
            }
        Matriz matrizC = new Matriz(C);
        return matrizC;
    }
    
    public static Matriz resta(Matriz matrizA, Matriz matrizB){
        double[][] A = matrizA.getNumeros();
        double[][] B = matrizB.getNumeros();
        double [][] C = new double[0][0];
        if(A.length == B.length && A.length > 0)
            if(A[0].length == B[0].length){
                C = new double[A.length][A[0].length];
                for(int i = 0; i <A.length; i++)
                    for(int j = 0; j<A[0].length; j++)
                        C[i][j] = A[i][j]-B[i][j];
            }
        Matriz matrizC = new Matriz(C);
        return matrizC;
    }
    
    public static Matriz invierte(Matriz matrizA){
        double[][] original = matrizA.getNumeros();
        double[][] nuevo = new double[original.length][];
        for(int i = 0; i < original.length; i++){
            nuevo[i] = new double[original[i].length];
            for(int j = 0; j < original[i].length; j++)
                nuevo[i][j] = original[i][j];
        }
        nuevo = invert(nuevo);
        return new Matriz(nuevo);
    }

    public static double[][] invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
 // Transform the matrix into an upper triangle
        gaussian(a, index);
 
 // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];
 
 // Perform backward substitutions
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
 
// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
 
 // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
 // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
 // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
   // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i)   
            {
                double pj = a[index[i]][j]/a[index[j]][j];
 
 // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
 // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
    
    public static boolean comparar(Matriz matrizA, Matriz matrizB){
        double[][] A = matrizA.getNumeros();
        double[][] B = matrizB.getNumeros();
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++){
                if(A[i][j] != B[i][j])
                    return false;
            }
        return true;
    }
    
    public static void imprimir(Matriz matrizA){
        double[][] A = matrizA.getNumeros();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j<A[0].length; j++)
                System.out.print(""+A[i][j]+" "); 
            System.out.println("");
        }
    }

    public static double sumaDeComponentes(Matriz matrizA){
        double[][]A = matrizA.getNumeros();
        double total = 0;
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[i].length; j++)
                total += A[i][j];
        return total;
    }
    

}