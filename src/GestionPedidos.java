/**
 * Clase GestionPedidos
 * --------------------
 * Clase de control que coordina las DOS pilas manuales del sistema:
 *
 *   - pilaPrincipal (Undo): almacena los pedidos registrados, en el
 *     orden en que fueron llegando. Es la pila "activa" del negocio.
 *
 *   - pilaSecundaria (Redo): almacena temporalmente los pedidos que
 *     fueron deshechos, para poder recuperarlos con la acción "Rehacer".
 *
 * Flujo típico: Registro -> Deshacer -> Rehacer
 *   1. registrarPedido()  -> push en pilaPrincipal
 *   2. deshacer()         -> pop de pilaPrincipal + push en pilaSecundaria
 *   3. rehacer()          -> pop de pilaSecundaria + push en pilaPrincipal
 */
public class GestionPedidos {

    private Pila<Pizza> pilaPrincipal;   // Pila de pedidos activos (Undo)
    private Pila<Pizza> pilaSecundaria;  // Pila de pedidos deshechos (Redo)

    public GestionPedidos() {
        this.pilaPrincipal = new Pila<>();
        this.pilaSecundaria = new Pila<>();
    }

    /**
     * 1. Registrar Pedido (Escribir)
     * Agrega una nueva pizza al tope de la pila principal.
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);

        // Regla de negocio: al registrar un pedido nuevo, el historial
        // de "rehacer" pierde sentido (como en cualquier editor de texto),
        // así que se limpia la pila secundaria.
        pilaSecundaria = new Pila<>();
    }

    /**
     * 2. Deshacer (Undo)
     * Retira el último pedido de la pila principal (pop) y lo mueve
     * a la pila secundaria (push), para poder recuperarlo después.
     *
     * @return la pizza que fue deshecha, o null si no había pedidos.
     */
    public Pizza deshacer() {
        if (pilaPrincipal.isEmpty()) {
            return null;
        }
        Pizza pedidoDeshecho = pilaPrincipal.pop();
        pilaSecundaria.push(pedidoDeshecho);
        return pedidoDeshecho;
    }

    /**
     * 3. Rehacer (Redo)
     * Retira el último pedido deshecho de la pila secundaria (pop)
     * y lo devuelve a la pila principal (push).
     *
     * @return la pizza que fue rehecha, o null si no había nada que rehacer.
     */
    public Pizza rehacer() {
        if (pilaSecundaria.isEmpty()) {
            return null;
        }
        Pizza pedidoRehecho = pilaSecundaria.pop();
        pilaPrincipal.push(pedidoRehecho);
        return pedidoRehecho;
    }

    /**
     * 4. Mostrar Pedido Actual
     * Usa peek() para ver la pizza que está en el tope de la pila
     * principal, sin retirarla (es la que está lista para producción).
     *
     * @return la pizza en el tope, o null si no hay pedidos.
     */
    public Pizza mostrarPedidoActual() {
        if (pilaPrincipal.isEmpty()) {
            return null;
        }
        return pilaPrincipal.peek();
    }

    public boolean hayPedidosActivos() {
        return !pilaPrincipal.isEmpty();
    }

    public boolean hayPedidosParaRehacer() {
        return !pilaSecundaria.isEmpty();
    }

    public int totalPedidosActivos() {
        return pilaPrincipal.size();
    }

    public int totalPedidosDeshechos() {
        return pilaSecundaria.size();
    }
}
