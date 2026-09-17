import java.util.Scanner;

/**
 * Clase Main
 * ----------
 * Punto de entrada de la aplicación Pizza-Track.
 * Presenta el menú interactivo en consola y delega toda la lógica
 * de negocio a la clase GestionPedidos.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionPedidos gestion = new GestionPedidos();

        int opcion = -1;

        System.out.println("=============================================");
        System.out.println("      PIZZA-TRACK - Sistema de Pedidos");
        System.out.println("=============================================");

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    registrarPedido(scanner, gestion);
                    break;
                case 2:
                    deshacerPedido(gestion);
                    break;
                case 3:
                    rehacerPedido(gestion);
                    break;
                case 4:
                    mostrarPedidoActual(gestion);
                    break;
                case 0:
                    System.out.println("\nGracias por usar Pizza-Track. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---------------------------------------------");
        System.out.println("1. Registrar Pedido (Escribir)");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar Pedido Actual");
        System.out.println("0. Salir");
        System.out.println("---------------------------------------------");
        System.out.print("Selecciona una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // Forzará el mensaje de "opción inválida"
        }
    }

    /**
     * Opción 1: pide nombre y 3 ingredientes, crea la Pizza
     * y la registra (push) en la pila principal.
     */
    private static void registrarPedido(Scanner scanner, GestionPedidos gestion) {
        System.out.println("\n--- Registrar nuevo pedido ---");
        System.out.print("Nombre de la pizza: ");
        String nombre = scanner.nextLine().trim();

        String[] ingredientes = new String[Pizza.CANTIDAD_INGREDIENTES];
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = scanner.nextLine().trim();
        }

        Pizza nuevaPizza = new Pizza(nombre, ingredientes);
        gestion.registrarPedido(nuevaPizza);

        System.out.println("\nPedido registrado correctamente:");
        System.out.println(nuevaPizza);
        System.out.println("Pedidos activos en la pila principal: " + gestion.totalPedidosActivos());
    }

    /**
     * Opción 2: deshace el último pedido (pop de la pila principal,
     * push a la pila secundaria).
     */
    private static void deshacerPedido(GestionPedidos gestion) {
        System.out.println("\n--- Deshacer último pedido ---");
        if (!gestion.hayPedidosActivos()) {
            System.out.println("No hay pedidos registrados para deshacer.");
            return;
        }
        Pizza pedidoDeshecho = gestion.deshacer();
        System.out.println("Pedido deshecho: " + pedidoDeshecho);
        System.out.println("Pedidos activos restantes: " + gestion.totalPedidosActivos());
    }

    /**
     * Opción 3: recupera el último pedido deshecho (pop de la pila
     * secundaria, push a la pila principal).
     */
    private static void rehacerPedido(GestionPedidos gestion) {
        System.out.println("\n--- Rehacer pedido ---");
        if (!gestion.hayPedidosParaRehacer()) {
            System.out.println("No hay pedidos deshechos para rehacer.");
            return;
        }
        Pizza pedidoRehecho = gestion.rehacer();
        System.out.println("Pedido rehecho: " + pedidoRehecho);
        System.out.println("Pedidos activos en la pila principal: " + gestion.totalPedidosActivos());
    }

    /**
     * Opción 4: usa peek() para mostrar el pedido en el tope de la
     * pila principal, sin retirarlo.
     */
    private static void mostrarPedidoActual(GestionPedidos gestion) {
        System.out.println("\n--- Pedido actual (tope de la pila) ---");
        Pizza pedidoActual = gestion.mostrarPedidoActual();
        if (pedidoActual == null) {
            System.out.println("No hay pedidos activos en este momento.");
        } else {
            System.out.println("Pedido listo para producción: " + pedidoActual);
        }
    }
}
