/*
 * Ejercicio8 : Pedir un numero, y mostrar todos los numeros del 1 al N.
 * Clase Scanner 
 */
package JAVA;

import java.util.Scanner;

public class Clase_5_EjercicioCiclos08conScanner {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite un numero: ");
        int numero = Integer.parseInt(entrada.nextLine());
        int i = 1;
        while(i <= numero){
            System.out.println(i);
            i++;
        }
    }
}
