/*
 * Proyecto caja:
 * Ejercicio1: Crear un proyecto segun las especificaciones mostradas a continuacio.
 * La formula es: volumen = ancho * alto * profundidad
 */
package JAVA.Clase_6_Caja;

public class Clase_6_Ejercicio_Proyecto_caja {
    public static void main(String[] args) {
        //variables locales
        int medidaAncho = 3;//valores ingresados en codigo main
        int medidaAlto = 2;
        int medidaProf = 6;

        Caja caja1 = new Caja(); //Instanciamos el objeto, constructor vacio
        caja1.ancho = medidaAncho; //le pasamos los valores al objeto
        caja1.alto = medidaAlto;
        caja1.profundo = medidaProf;
        int resultado = caja1.calcularVolumen(); //llamamos al metodo 
        //primer resultado
        System.out.println("resultado volumen de caja 1: " + resultado);

        Caja Caja2 = new Caja(2,4,6); //Llamamos al constructor 2 con nuevos argumentos 
        //Llamamos con el nuevo objeto del metodo para un nuevo calculo
        System.out.println("resultado volumen de caja 2: " +Caja2.calcularVolumen() );

    }
}
