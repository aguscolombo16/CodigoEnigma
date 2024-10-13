
    /*
 * Ejercicio8 : Pedir un numero, y mostrar todos los numeros del 1 al N.
 * Clase Scanner 
 */
package JAVA;
    import javax.swing.JOptionPane;

    public class Clase_5_EjercicioCiclos08conJOptionpane {
        public static void main(String[] args) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:"));
            int i = 1;
            while(i <= numero){
                JOptionPane.showMessageDialog(null, i);
                i++;
            }
        }
    }
    
    
    