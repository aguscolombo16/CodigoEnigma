/*
 * Ejercicio 10 : Pedir 10 numeros y escribir la suma total
 * hacerlo con la clase scanner y JOptioPane
 */



package JAVA.Clase_6_Caja;

import javax.swing.JOptionPane;

public class Ejercicio_10_JOptionPane {
    public static void main(String[] args) {
        int numero , suma = 0 ;
        for(int i=1 ; i<=10 ; i++ ){
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
        suma += numero;
        }
        JOptionPane.showMessageDialog(null,"La suma de todos los numeros es: " +suma);
    }
} 
