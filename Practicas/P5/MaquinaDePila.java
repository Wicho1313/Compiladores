import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

public class MaquinaDePila {
    
    private int contadorDePrograma;
    private ArrayList  memoria;
    private Stack pila;
    private TablaDeSimbolos tabla;
    private boolean stop = false;
    
    public MaquinaDePila(TablaDeSimbolos tabla){
        contadorDePrograma = 0;
        memoria = new ArrayList<Method>();
        pila = new Stack();
        this.tabla = tabla;
    }
    
    public int numeroDeElementos(){
        return memoria.size() + 1;
    }
    
    //Funciones que se escriben en memoria
    public int agregarOperacion(String nombre){
        int posicion = memoria.size();
        try{
            memoria.add(this.getClass().getDeclaredMethod(nombre, null));
            return posicion;
        }
        catch(Exception e ){}
        return -1;
    }
    
    public int agregar(Object objeto){
        int posicion = memoria.size();
        memoria.add(objeto);
        return posicion;
    }
    
    public void agregar(Object objeto, int posicion){
        memoria.remove(posicion);
        memoria.add(posicion, objeto);
    }
    
    //Funciones que la máquina ejecuta sobre la pila
    private void sumar(){
        Object matriz2 = pila.pop();
        Object matriz1 = pila.pop();
        if(matriz1 instanceof Matriz && matriz2 instanceof Matriz)
            pila.push(MtrxOp.suma((Matriz)matriz1, (Matriz)matriz2));
        else 
            pila.push((double)matriz1 + (double)matriz2);
    }
    
    private void restar(){
        Object matriz2 = pila.pop();
        Object matriz1 = pila.pop();
        if(matriz1 instanceof Matriz && matriz2 instanceof Matriz)
            pila.push(MtrxOp.resta((Matriz)matriz1, (Matriz)matriz2));
        else 
            pila.push((double)matriz1 - (double)matriz2);
    }

    private void multiplicar(){
        Object matriz2 = pila.pop();
        Object matriz1 = pila.pop();
        if(matriz1 instanceof Matriz && matriz2 instanceof Matriz)
            pila.push(MtrxOp.multiplicacion((Matriz)matriz1, (Matriz)matriz2));
        else 
            pila.push((double)matriz1 * (double)matriz2);
    }
    
    private void constPush(){
        pila.push(memoria.get(++contadorDePrograma));
    }
    
    private void varPush(){
        pila.push(memoria.get(++contadorDePrograma));
    }
    
    private void varPush_Eval(){
        pila.push(tabla.encontrar((String)memoria.get(++contadorDePrograma)));
    }

    private void asignar(){
        String variable = (String)pila.pop();
        Object objeto = pila.pop();
        tabla.insertar(variable, objeto);
    }
    
    private void comparar(){
        Object A = pila.pop();
        Object B = pila.pop();
        if((A instanceof Matriz) && (B instanceof Matriz))
            pila.push(MtrxOp.comparar((Matriz)A, (Matriz)B));
        else
            pila.push((double)A==(double)B);
    }

    private void compararNot(){
        Object A = pila.pop();
        Object B = pila.pop();
        if((A instanceof Matriz) && (B instanceof Matriz))
            pila.push(!MtrxOp.comparar((Matriz)A, (Matriz)B));
        else
            pila.push((double)A!=(double)B);
    }

    private void menor(){
        double a;
        double b;
        Object B = pila.pop();
        Object A = pila.pop(); //Se sacan en orden inverso por la forma de la pila
        if((A instanceof Matriz) && (B instanceof Matriz)){
            a = MtrxOp.sumaDeComponentes((Matriz)A);
            b = MtrxOp.sumaDeComponentes((Matriz)B);
        }            
        else{
            a = (double)A;
            b = (double)B;
        }
        pila.push(a < b);
    }

    private void mayor(){
        double a;
        double b;
        Object B = pila.pop();
        Object A = pila.pop(); //Se sacan en orden inverso por la forma de la pila
        if((A instanceof Matriz) && (B instanceof Matriz)){
            a = MtrxOp.sumaDeComponentes((Matriz)A);
            b = MtrxOp.sumaDeComponentes((Matriz)B);
        }            
        else{
            a = (double)A;
            b = (double)B;
        }
        pila.push(a > b);
    }

    private void menorIgual(){
        double a;
        double b;
        Object B = pila.pop();
        Object A = pila.pop(); //Se sacan en orden inverso por la forma de la pila
        if((A instanceof Matriz) && (B instanceof Matriz)){
            a = MtrxOp.sumaDeComponentes((Matriz)A);
            b = MtrxOp.sumaDeComponentes((Matriz)B);
        }            
        else{
            a = (double)A;
            b = (double)B;
        }
        pila.push(a <= b);
    }

    private void mayorIgual(){
        double a;
        double b;
        Object B = pila.pop();
        Object A = pila.pop(); //Se sacan en orden inverso por la forma de la pila
        if((A instanceof Matriz) && (B instanceof Matriz)){
            a = MtrxOp.sumaDeComponentes((Matriz)A);
            b = MtrxOp.sumaDeComponentes((Matriz)B);
        }            
        else{
            a = (double)A;
            b = (double)B;
        }
        pila.push(a >= b);
    }

    private void negar(){
        pila.push(! (boolean)pila.pop());
    }

    private void and(){
        pila.push((boolean)pila.pop() && (boolean)pila.pop());
    }

    private void or(){
        pila.push((boolean)pila.pop() && (boolean)pila.pop());
    }
    
    private void stop(){
        stop = true;
    }

    private void nop(){
    }
    
    private void _while(){
        int condicion = contadorDePrograma;
        boolean continua = true;
        while(continua){
            ejecutar(condicion + 3);           
            if((boolean)pila.pop()){ //lee el resultado de la condición de la pila
                ejecutar((int)memoria.get(condicion+1));//Ejecuta el cuerpo
            }
            else{
                contadorDePrograma = (int)memoria.get(condicion+2); 
                continua = false;
            }
        }     
    }
    
    private void _if_then_else(){
        int condicion = contadorDePrograma;
        ejecutar(condicion + 4); //Evalúa la condicion
        boolean resultado = true;
        try{
            resultado = (boolean)pila.pop();
        }
        catch(Exception e ){
        }
        if(resultado){ //lee el resultado de la condición de la pila
            ejecutar((int)memoria.get(condicion+1));//Ejecuta el cuerpo
        }
        else{
            ejecutar((int)memoria.get(condicion+2));
        }
        contadorDePrograma = (int)memoria.get(condicion+3);
    }

    //Métodos para la ejecución
    public void ejecutar(){
        /*
        for(int i = 0; i < memoria.size(); i++)
            System.out.println("" + i + ": " +memoria.get(i));
        */
        contadorDePrograma = 0;
        stop = false;
        while(contadorDePrograma < memoria.size())
            ejecutarInstruccion(contadorDePrograma);
    }
    
    public void ejecutar(int indice){//ejecuta hasta que se encuentra Stop     
        contadorDePrograma = indice;
        while(stop == false){
            ejecutarInstruccion(contadorDePrograma);
        }
        stop = false;
    }
    
    public void ejecutarInstruccion(int indice){
        //System.out.println("Ejecutando: " + indice);
        try{         
            Object objetoLeido = memoria.get(indice);
            if(objetoLeido instanceof Method){
                Method metodo = (Method)objetoLeido;
                metodo.invoke(this, null);
            }
            if(objetoLeido instanceof Funcion){
                Funcion funcion = (Funcion)objetoLeido;
                pila.push(funcion.ejecutar(pila.pop()));
            }
            contadorDePrograma++;
        }
        catch(Exception e){}
    }
    
    public static class Imprimir implements Funcion{

        @Override
        public Object ejecutar(Object A) {
            System.out.println("");
            System.out.println("" + A);
            System.out.println("");
            return A;
        }

    }

    public static class Invertir implements Funcion{

        @Override
        public Object ejecutar(Object A) {
            Matriz invertida = MtrxOp.invierte((Matriz)A);
            return invertida;
        }
        
    }

    public static class Sumar implements Funcion{

        @Override
        public Object ejecutar(Object A) {
            return MtrxOp.sumaDeComponentes((Matriz)A);
        }
        
    }

}
