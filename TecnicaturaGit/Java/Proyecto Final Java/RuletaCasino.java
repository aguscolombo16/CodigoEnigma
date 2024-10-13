package JAVA;
    import java.util.*;

public class RuletaCasino {
    private static Scanner scanner = new Scanner(System.in);
    private static double saldo;

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la Ruleta del Casino!");
        System.out.print("Ingrese su saldo inicial: ");
        saldo = obtenerDouble();

        boolean jugando = true;

        while (jugando && saldo > 0) {
            System.out.println("\nSu saldo actual es: $" + saldo);
            mostrarOpcionesApuesta();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    apostarNumero();
                    break;
                case 2:
                    apostarColor();
                    break;
                case 3:
                    apostarParImpar();
                    break;
                case 4:
                    apostarDocena();
                    break;
                case 5:
                    jugando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        if (saldo <= 0) {
            System.out.println("Te has quedado sin saldo. ¡Gracias por jugar!");
        } else {
            System.out.println("Gracias por jugar. Tu saldo final es: $" + saldo);
        }
    }

    private static void mostrarOpcionesApuesta() {
        System.out.println("\nSeleccione el tipo de apuesta:");
        System.out.println("1. Número específico (paga 35 a 1)");
        System.out.println("2. Color (Rojo o Negro) (paga 1 a 1)");
        System.out.println("3. Par o Impar (paga 1 a 1)");
        System.out.println("4. Docena (1-12, 13-24, 25-36) (paga 2 a 1)");
        System.out.println("5. Salir");
        System.out.print("Opción: ");
    }

    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double obtenerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void apostarNumero() {
        System.out.print("Ingrese el número al que desea apostar (0-36): ");
        int numero = obtenerNumero(0, 36);
        System.out.print("Ingrese la cantidad a apostar: $");
        double apuesta = obtenerApuesta();

        if (apuesta > saldo) {
            System.out.println("No tienes suficiente saldo para esta apuesta.");
            return;
        }

        int resultado = girarRuleta();
        System.out.println("La ruleta ha girado... y salió el número: " + resultado + " " + obtenerColor(resultado));

        if (resultado == numero) {
            double ganancia = apuesta * 35;
            saldo += ganancia;
            System.out.println("¡Felicidades! Has ganado $" + ganancia);
        } else {
            saldo -= apuesta;
            System.out.println("Has perdido $" + apuesta);
        }
    }

    private static void apostarColor() {
        System.out.print("Seleccione el color al que desea apostar (Rojo/Negro): ");
        String color = scanner.next().toLowerCase();
        while (!color.equals("rojo") && !color.equals("negro")) {
            System.out.print("Color inválido. Ingrese 'Rojo' o 'Negro': ");
            color = scanner.next().toLowerCase();
        }

        System.out.print("Ingrese la cantidad a apostar: $");
        double apuesta = obtenerApuesta();

        if (apuesta > saldo) {
            System.out.println("No tienes suficiente saldo para esta apuesta.");
            return;
        }

        int resultado = girarRuleta();
        String colorResultado = obtenerColor(resultado);
        System.out.println("La ruleta ha girado... y salió el número: " + resultado + " " + colorResultado);

        if (colorResultado.equalsIgnoreCase(color)) {
            double ganancia = apuesta;
            saldo += ganancia;
            System.out.println("¡Felicidades! Has ganado $" + ganancia);
        } else {
            saldo -= apuesta;
            System.out.println("Has perdido $" + apuesta);
        }
    }

    private static void apostarParImpar() {
        System.out.print("¿Desea apostar a 'Par' o 'Impar'? ");
        String eleccion = scanner.next().toLowerCase();
        while (!eleccion.equals("par") && !eleccion.equals("impar")) {
            System.out.print("Elección inválida. Ingrese 'Par' o 'Impar': ");
            eleccion = scanner.next().toLowerCase();
        }

        System.out.print("Ingrese la cantidad a apostar: $");
        double apuesta = obtenerApuesta();

        if (apuesta > saldo) {
            System.out.println("No tienes suficiente saldo para esta apuesta.");
            return;
        }

        int resultado = girarRuleta();
        System.out.println("La ruleta ha girado... y salió el número: " + resultado + " " + obtenerColor(resultado));

        if (resultado == 0) {
            saldo -= apuesta;
            System.out.println("El 0 no es ni par ni impar. Has perdido $" + apuesta);
            return;
        }

        boolean esPar = resultado % 2 == 0;
        if ((esPar && eleccion.equals("par")) || (!esPar && eleccion.equals("impar"))) {
            double ganancia = apuesta;
            saldo += ganancia;
            System.out.println("¡Felicidades! Has ganado $" + ganancia);
        } else {
            saldo -= apuesta;
            System.out.println("Has perdido $" + apuesta);
        }
    }

    private static void apostarDocena() {
        System.out.println("Seleccione la docena a la que desea apostar:");
        System.out.println("1. 1-12");
        System.out.println("2. 13-24");
        System.out.println("3. 25-36");
        System.out.print("Opción: ");
        int docena = obtenerNumero(1, 3);

        System.out.print("Ingrese la cantidad a apostar: $");
        double apuesta = obtenerApuesta();

        if (apuesta > saldo) {
            System.out.println("No tienes suficiente saldo para esta apuesta.");
            return;
        }

        int resultado = girarRuleta();
        System.out.println("La ruleta ha girado... y salió el número: " + resultado + " " + obtenerColor(resultado));

        boolean gano = false;
        if (docena == 1 && resultado >=1 && resultado <=12) {
            gano = true;
        } else if (docena == 2 && resultado >=13 && resultado <=24) {
            gano = true;
        } else if (docena == 3 && resultado >=25 && resultado <=36) {
            gano = true;
        }

        if (gano) {
            double ganancia = apuesta * 2;
            saldo += ganancia;
            System.out.println("¡Felicidades! Has ganado $" + ganancia);
        } else {
            saldo -= apuesta;
            System.out.println("Has perdido $" + apuesta);
        }
    }

    private static int girarRuleta() {
        Random rand = new Random();
        return rand.nextInt(37); // 0-36
    }

    private static String obtenerColor(int numero) {
        // Números rojos en la ruleta europea
        Set<Integer> rojos = new HashSet<>(Arrays.asList(
            1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
        ));
        if (numero == 0) {
            return "Verde";
        } else if (rojos.contains(numero)) {
            return "Rojo";
        } else {
            return "Negro";
        }
    }

    private static int obtenerNumero(int min, int max) {
        int numero;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, ingrese un número válido: ");
                scanner.next();
            }
            numero = scanner.nextInt();
            if (numero >= min && numero <= max) {
                break;
            } else {
                System.out.print("Número fuera de rango. Ingrese un número entre " + min + " y " + max + ": ");
            }
        }
        return numero;
    }
    private static double obtenerApuesta() {
        double apuesta;
        while (true) {
            while (!scanner.hasNextDouble()) {
                System.out.print("Por favor, ingrese una cantidad válida: ");
                scanner.next();
            }
            apuesta = scanner.nextDouble();
            if (apuesta > 0) {
                break;
            } else {
                System.out.print("La apuesta debe ser mayor que 0. Ingrese nuevamente: ");
            }
        }
        return apuesta;
    }
}

