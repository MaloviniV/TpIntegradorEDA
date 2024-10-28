package trabajofinaleda;

import java.util.Scanner;

/*TRABAJO FINAL EDA-2024, ASISTENTE DE COMPRAS.
Diseña una aplicación en el que el usuario debe seleccionar un producto electrónico
basándose en sus necesidades.*/

public class TrabajoFinalEDA {

    public static void main(String[] args) {
        boolean salida=true;
        Scanner entrada = new Scanner(System.in);
        entrada.useDelimiter("\n");      //cambio el delimitador del SCANNER para que tome toda la frase
        Nodo nodo;
        
        ArbolBinario arbol = new ArbolBinario();
        
        while(salida){
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
                    System.out.println("¡¡Siga los pasos para ingresar el producto!!");
                    
                    //NAVEGO ENTRE LAS RAMAS CREADAS
                    arbol.buscarProducto();
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
                            //arbol.getFila().add(1);
                        }else{
                            System.out.println("Ingrese el producto:");
                            valor = entrada.next();
                        }
                        System.out.println(arbol.getFila());
                        arbol.insertar(valor);
                        System.out.println(arbol.getFila());
                    }while(resp==1);
//                    do{
//                        System.out.println("¿Desea ingresar otra subcategoria?");
//                        resp = entrada.next();
//                        if(resp.equalsIgnoreCase("S")){
//                            System.out.println("Ingrese la subcategoria sin signos:");
//                            valor = entrada.next();
//                            valor = "¿"+valor+"?";
//                        }else{
//                            System.out.println("Ingrese el producto:");
//                            valor = entrada.next();
//                        }
//                        arbol.insertar(valor);
//                    }while(resp.equalsIgnoreCase("S"));
                    arbol.getFila().clear();
                    break;

                case 2:
                    System.out.println("El equipo de Electrónica que esta pensando...");
                    arbol.inorden();
                    break;
                case 3:
                    nodo = arbol.buscarProducto();
                    if(nodo == null || nodo.getValor().contains("?")){
                        System.out.println("El producto no fue encontrado");
                        
                    }else{
                        System.out.println("El producto es: " + nodo.getValor());
                        arbol.getFila().clear();
                    }
                    break;
                case 4:
                    salida = false;
                    System.out.println("Saliendo...");
                    break;
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
            System.out.println("| 1 - Inserción                                             |");
            System.out.println("| 2 - Sugerir producto                                      |");
            System.out.println("| 3 - Busqueda de producto                                  |");
            System.out.println("| 4 - Salir                                                 |");
            System.out.println("-------------------------------------------------------------");
            System.out.println("");
    }
}
