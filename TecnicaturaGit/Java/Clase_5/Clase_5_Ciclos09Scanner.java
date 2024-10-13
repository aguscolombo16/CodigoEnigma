/*
Ejercicio 9: Pedir el dia , mes y año de una fecha e indicar si la fecha es correcta.
suponiendo que todos los meses son de 30 dias 
*/
package JAVA;

import java.util.Scanner;

public class Clase_5_Ciclos09Scanner {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite el dia: ");
        int dia = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite el dia: ");
        int mes = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite el mes: ");
        int año = Integer.parseInt(entrada.nextLine());
        System.out.println("Digite el año: ");
        
        if((dia!= 0)&&(dia <= 30)){
            if((mes != 0)&&(mes <= 12)){
                if((año!= 0)&&(año <=2024)){
                    System.out.println("La fecha ingresada es: "+dia+ "/" +mes+ "/" +año);
                }
                else{
                    System.out.println("Fecha incorrecta, año incorrecto");
                }
            }
            else{
                System.out.println("Fecha incorrecta, mes incorrecto");
            }
        }
        else{
            System.out.println("Fecha incorrecta, dia incorrecto");
        }
    }
}