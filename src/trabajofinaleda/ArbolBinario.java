package trabajofinaleda;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ArbolBinario {
    private Nodo raiz;
    private Queue<Integer> fila = new LinkedList<>();

    public ArbolBinario() {
        preCargaNodos();
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Queue<Integer> getFila() {
        return fila;
    }

    public void setFila(Queue<Integer> fila) {
        this.fila = fila;
    }

    public void inorden() {
        this.inorden(this.raiz);
        System.out.println("");
    }

        private void inorden(Nodo padre) {
        if (padre != null) {
            inorden(padre.getIzq());
            if(!padre.getValor().contains("¿")){
                System.out.println(padre.getValor()+"; ");                
            }
            inorden(padre.getDer());
        }
    }
        
    //TP    
    public Nodo buscarProducto(){
        return buscar(this.raiz);
    }
    
    private Nodo buscar(Nodo padre) {
        Scanner entrada = new Scanner(System.in);
        
        if(padre == null){
            return null;
        }
        int resp;
        while (true) {
            String pregunta = padre.getValor().toUpperCase();
            if(!pregunta.contains("¿")){
                pregunta = "¿"+pregunta+"?";                
            }
            System.out.println("-------------------------------------------------------------");
            System.out.println(     "El articulo es: "+pregunta);
            System.out.println("|                  * Ingrese una opción *                   |");
            System.out.println("| 1 - SI                                                    |");
            System.out.println("| 2 - NO                                                    |");
            System.out.println("-------------------------------------------------------------");
            
            if(!entrada.hasNextInt()){
                System.out.println("**** Error! Caracter no válido ****");
                entrada.next();
                continue;
            }
            resp = entrada.nextInt();
            if(!(resp==1 || resp==2)){
                System.out.println("**** Error! Opción incorrecta ****");
                continue;
            }
            break;
        }
        
        fila.add(resp);
        
        if(padre.esHoja()&&resp==1){
            return padre;
        }
        if(resp==2){
            return buscar(padre.getIzq());        
        }else{
            return buscar(padre.getDer());
        }        
    }
    
    public void insertar(String dato){
        if(this.raiz == null){
            this.raiz = new Nodo(dato);
        }
        insertar(this.raiz, dato);
        this.getFila().add(1);
    }

    private void insertar(Nodo padre, String dato) {
        if(fila.element()==2){
            fila.add(fila.poll());
            if(padre.getIzq() == null){
                padre.setIzq(new Nodo(dato));
            }else{
                insertar(padre.getIzq(), dato);
            }            
        }else{
            fila.add(fila.poll());
            if(padre.getDer()== null){
                padre.setDer(new Nodo(dato));
            }else{
                insertar(padre.getDer(), dato);
            }
        }
    }
    
    private void preCargaNodos() {
        this.raiz = new Nodo("¿TV Y AUDIO?");     //NIVEL 1
    //-------------------------------------------------------------     //NIVEL 2
        Nodo nodo1 = new Nodo("¿TECNOLOGIA?");  //NO - RAIZ
        Nodo nodo2 = new Nodo("¿AUDIO Y SONIDO?"); //SI - RAIZ
        raiz.setIzq(nodo1);
        raiz.setDer(nodo2);
    //TECNOLOGIA-----------------------------------------------------    //NIVEL 3
        Nodo nodo3 = new Nodo("¿ELECTRODOMESTICOS?");    //NO - NODO1
        Nodo nodo4 = new Nodo("¿COMPUTADORAS?");      //SI - NODO1
        nodo1.setIzq(nodo3);
        nodo1.setDer(nodo4);
    //AUDIO Y SONIDO
        Nodo nodo5 = new Nodo("¿ACCESORIOS TV?");    //NO - NODO2
        Nodo nodo6 = new Nodo("¿AURICULARES?");  //SI - NODO2
        nodo2.setIzq(nodo5);
        nodo2.setDer(nodo6);
    //------------------------------------------------      //NIVEL 4
            //ELECTRODOMESTICOS
        Nodo nodo8 = new Nodo("¿AIRE ACONDICIONADO?");      //SI - NODO3
        nodo3.setDer(nodo8);
            //COMPUTADORAS
        Nodo nodo9 = new Nodo("¿CONSOLAS Y VIDEO JUEGOS?");   //NO - NODO4
        Nodo nodo10 = new Nodo("¿NOTEBOOK");                  //SI - NODO4
        nodo4.setIzq(nodo9);
        nodo4.setDer(nodo10);
            //ACCESORIOS TV
        Nodo nodo11 = new Nodo("¿TELEVISORES?");       //NO - NODO5
        Nodo nodo12 = new Nodo("¿SOPORTES?");        //SI - NODO5
        nodo5.setIzq(nodo11);
        nodo5.setDer(nodo12);
            //AURICULARES
        Nodo nodo13 = new Nodo("¿ESTEREOS?");               //NO - NODO6
        Nodo nodo14 = new Nodo("PRODUCTO AURICULARES");     //SI - NODO6 -PRODUCTO
        nodo6.setIzq(nodo13);
        nodo6.setDer(nodo14);
    //------------------------------------------------      //NIVEL 5
            //AIRE ACONDICIONADO
        Nodo nodo18 = new Nodo("PRODUCTO AIRE ACONDICIONADO");     //SI - NODO8 -PRODUCTO
        nodo8.setDer(nodo18);
            //CONSOLAS Y VIDEO JUEGOS
        Nodo nodo20 = new Nodo("¿CONSOLAS?");     //SI - NODO9
        nodo9.setDer(nodo20);
            //NOTEBOOK
        Nodo nodo22 = new Nodo("PRODUCTO NOTEBOOK");     //SI - NODO10  - PRODUCTO
        nodo10.setDer(nodo22);
            //TELEVISORES
        Nodo nodo24 = new Nodo("¿<50\"?");     //SI - NODO11
        nodo11.setDer(nodo24);
            //SOPORTES
        Nodo nodo26 = new Nodo("PRODUCTO SOPORTE");     //SI - NODO12 -PRODUCTO
        nodo12.setDer(nodo26);
            //ESTEREOS
        Nodo nodo28 = new Nodo("PRODUCTO ESTEREOS");     //SI - NODO13 -PRODUCTO
        nodo13.setDer(nodo28);
         
    //------------------------------------------------      //NIVEL 5
            //CONSOLAS
        Nodo nodo42 = new Nodo("PRODUCTO CONSOLAS");     //SI - NODO20
        nodo20.setDer(nodo42);
            //<50"
        Nodo nodo50 = new Nodo("PRODUCTO TELEVISORES <50\"");     //SI - NODO24
        nodo24.setDer(nodo50);
    }
}
