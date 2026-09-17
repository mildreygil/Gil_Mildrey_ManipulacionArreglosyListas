/**
 * Clase NodoPila
 * --------------
 * Es el "eslabón" de la lista ligada sobre la que construimos la pila
 * manualmente (sin usar java.util.Stack).
 *
 * Cada nodo guarda:
 *   - dato: la información que contiene (en este proyecto, un objeto Pizza)
 *   - siguiente: el PUNTERO (referencia) al nodo que quedó justo debajo
 *     de él en la pila.
 *
 * Se usa genérico <T> para que esta misma estructura de nodo pueda
 * reutilizarse en cualquier tipo de pila.
 */
public class NodoPila<T> {

    T dato;
    NodoPila<T> siguiente; // Puntero al nodo anterior en la pila (el que quedó debajo)

    public NodoPila(T dato) {
        this.dato = dato;
        this.siguiente = null; // Al crearse, todavía no apunta a nadie
    }
}
