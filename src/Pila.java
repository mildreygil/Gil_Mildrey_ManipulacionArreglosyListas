/**
 * Clase Pila
 * ----------
 * Implementación MANUAL de una pila (estructura LIFO: Last In, First Out)
 * usando una lista ligada de nodos (NodoPila).
 *
 * Restricción de la actividad: NO se usa la librería java.util.Stack.
 * Toda la lógica de inserción/eliminación se maneja moviendo el puntero
 * "tope" entre nodos.
 *
 * ¿Cómo funciona la lista ligada aquí?
 * -------------------------------------
 * "tope" siempre apunta al último elemento que entró (la cima de la pila).
 * Cada nodo nuevo que se agrega pasa a ser el nuevo tope, y su puntero
 * "siguiente" queda apuntando al que ANTES era el tope. Así se arma una
 * cadena donde, desde el tope, podemos "bajar" nodo por nodo en el orden
 * inverso al que fueron llegando.
 */
public class Pila<T> {

    private NodoPila<T> tope; // Puntero que siempre señala la cima de la pila
    private int tamano;       // Cantidad de elementos actuales en la pila

    public Pila() {
        this.tope = null; // Pila vacía: el tope no apunta a ningún nodo
        this.tamano = 0;
    }

    /**
     * push(): Inserta un nuevo elemento en el TOPE de la pila.
     *
     * Lógica de punteros:
     * 1. Se crea un nodo nuevo con el dato recibido.
     * 2. El puntero "siguiente" de ese nodo nuevo se hace apuntar
     *    a quien era el tope actual (para no perder la cadena).
     * 3. El puntero "tope" de la pila se actualiza para que ahora
     *    apunte al nodo recién creado.
     */
    public void push(T elemento) {
        NodoPila<T> nuevoNodo = new NodoPila<>(elemento);
        nuevoNodo.siguiente = tope; // El nuevo nodo "queda encima" del tope anterior
        tope = nuevoNodo;           // El tope pasa a ser el nuevo nodo
        tamano++;
    }

    /**
     * pop(): Retira el elemento del tope y devuelve su contenido.
     *
     * Lógica de punteros:
     * 1. Se guarda el dato del nodo tope antes de eliminarlo.
     * 2. El puntero "tope" avanza hacia "siguiente", es decir, hacia
     *    el nodo que quedó debajo. El nodo anterior queda sin referencias
     *    y el recolector de basura de Java lo libera automáticamente.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer pop: la pila está vacía.");
        }
        T datoRetirado = tope.dato;
        tope = tope.siguiente; // El tope "baja" un nivel en la cadena
        tamano--;
        return datoRetirado;
    }

    /**
     * peek(): Permite visualizar el elemento del tope SIN retirarlo de la pila.
     * Simplemente se lee el dato del nodo al que apunta "tope", sin mover
     * ningún puntero.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede hacer peek: la pila está vacía.");
        }
        return tope.dato;
    }

    /**
     * isEmpty(): Valida si la pila no tiene elementos.
     * Una pila está vacía cuando su puntero "tope" no apunta a ningún nodo (null).
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * size(): Devuelve la cantidad de elementos actuales en la pila.
     * (Método de apoyo, no exigido explícitamente pero útil para el menú).
     */
    public int size() {
        return tamano;
    }
}
