public class Matriz {

    private double[][] numeros;

    public Matriz(){}

    public Matriz(double[][] numeros){
        this.numeros = numeros;
    }

    public double[][] getNumeros() {
        return numeros;
    }

    public void setNumeros(double[][] numeros) {
        this.numeros = numeros;
    }
    
    @Override
    public String toString(){
        String resultado = "";
        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j<numeros[0].length; j++)
                resultado += numeros[i][j] + " ";
            resultado += "\n";
        }
        return resultado;
    }

}
