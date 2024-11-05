package trabajofinaleda;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*TRABAJO FINAL EDA-2024, ASISTENTE DE COMPRAS.
Diseña una aplicación en el que el usuario debe seleccionar un producto electrónico
basándose en sus necesidades.*/

public class TrabajoFinalEDA {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useDelimiter("\n");      //cambio el delimitador del SCANNER para que tome toda la frase
        Nodo nodo;
        int resp;
        
        ArbolBinario arbol = new ArbolBinario();
        
        while(true){
            menu();
            if(!entrada.hasNextInt()){
                System.out.println("Error! Caracter no válido");
                entrada.next();
                continue;
            }
            int op = entrada.nextInt(); 
            switch(op) {
                case 1:
                    arbol.getFila().clear();                    
                    System.out.println("¡¡SIGA LOS PASOS PARA INGRESAR EL PRODUCTO!!");
                    
                    //NAVEGO ENTRE LAS RAMAS CREADAS
                    arbol.buscarProducto();
                    
                    ingresarProducto(arbol);
                    break;

                case 2:
                    System.out.println("LISTA DE PRODUCTOS...");
                    arbol.inorden();
                    esperar(5);
                    break;
                case 3:
                    arbol.getFila().clear();
                    nodo = arbol.buscarProducto();
                    if(nodo == null || nodo.getValor().contains("?")){
                        System.out.println("¡¡¡El producto no fue encontrado!!!");
                        
                        while (true) {
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("|         ¿Desea ingresar el producto que buscaba?          |".toUpperCase());
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
                        if(resp==1){
                            mostrarCamino(arbol);
                            ingresarProducto(arbol);
                        }
                    }else{
                        System.out.println("");
                        System.out.println("*****  El producto es: " + nodo.getValor()+"  *****");
                        System.out.println("");
                        arbol.getFila().clear();
                    }
                    esperar(5);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Error! Opción incorrecta");
                    break;     
            }
        }
    }
    
    public static void menu(){
            System.out.println("                *** ASISTENTE DE COMPRAS ***                 ");
            System.out.println("");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|                        ** MENU **                         |");
            System.out.println("|-----------------------------------------------------------|");
            System.out.println("|                  * Ingrese una opción *                   |");
            System.out.println("| 1 - Inserción de Producto                                 |");
            System.out.println("| 2 - Mostrar Productos                                     |");
            System.out.println("| 3 - Busqueda de producto                                  |");
            System.out.println("| 4 - Salir                                                 |");
            System.out.println("-------------------------------------------------------------");
            System.out.println("");
    }
    
    private static void ingresarProducto(ArbolBinario arbol) {
        Scanner entrada = new Scanner(System.in);
        entrada.useDelimiter("\n");      //cambio el delimitador del SCANNER para que tome toda la frase
        int resp;
        String valor;
        do{
            while (true) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("|            ¿Desea ingresar otra subcategoria?             |".toUpperCase());
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
            if(resp==1){
                System.out.println("Ingrese la subcategoria sin signos:");
                valor = entrada.next();
                valor = "¿"+valor+"?";
            }else{
                System.out.println("Ingrese el producto:");
                valor = entrada.next();
            }
            
            arbol.insertar(valor);
            System.out.println("*** PRODUCTO INGRESADO ***");
            esperar(5);
        }while(resp==1);
        arbol.getFila().clear();
    }

    private static void mostrarCamino(ArbolBinario arbol) {
        Queue<Integer> filaAux = new LinkedList<>();
        filaAux.addAll(arbol.getFila());
        Nodo nodo = arbol.getRaiz();
        System.out.println("CAMINO:");
        System.out.print(nodo.getValor()+" --> ");
        while(filaAux.size()>1){
            if(filaAux.poll()==1){
                nodo = nodo.getDer();
            }else{
                nodo = nodo.getIzq();                
            }
            System.out.print(nodo.getValor()+" --> ");
        }
        System.out.println("");
    }
    
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (InterruptedException e) {
            System.out.println(e);
         }
    }
}