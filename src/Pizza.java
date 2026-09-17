/**
 * Clase Pizza
 * ------------
 * Representa el objeto (pedido) que se moverá dentro de las pilas
 * de la aplicación Pizza-Track.
 *
 * Requisito de la actividad: usar un arreglo de tamaño FIJO (3)
 * para almacenar los ingredientes de cada pizza.
 */
public class Pizza {

    private String nombre;
    private String[] ingredientes; // Arreglo fijo de 3 posiciones

    public static final int CANTIDAD_INGREDIENTES = 3;

    /**
     * Constructor: captura el nombre de la pizza y sus 3 ingredientes.
     *
     * @param nombre       nombre de la pizza (ej: "Hawaiana")
     * @param ingredientes arreglo de exactamente 3 ingredientes
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;

        // Se crea un arreglo propio de tamaño fijo y se copian los datos,
        // así evitamos que un cambio externo modifique este pedido.
        this.ingredientes = new String[CANTIDAD_INGREDIENTES];
        for (int i = 0; i < CANTIDAD_INGREDIENTES; i++) {
            if (ingredientes != null && i < ingredientes.length) {
                this.ingredientes[i] = ingredientes[i];
            } else {
                this.ingredientes[i] = "Sin definir";
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    /**
     * Representación en texto del pedido, útil para mostrarlo en consola.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ").append(nombre).append(" | Ingredientes: ");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
