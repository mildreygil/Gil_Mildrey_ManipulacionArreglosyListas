# Pizza-Track — Simulador de Gestión de Pedidos (Undo/Redo)

## 1. Objetivo

Aplicación de consola en Java que simula el sistema de gestión de pedidos de
una pizzería (**Pizza-Track**). El proyecto demuestra la comprensión del
concepto de **pila** (estructura LIFO: *Last In, First Out*) y su aplicación
práctica en un mecanismo de **Deshacer / Rehacer (Undo/Redo)**, combinando
arreglos y listas ligadas, sin usar la librería `java.util.Stack`.

### ¿Qué es una pila y cómo se aplica aquí?

Una **pila** es una estructura de datos donde el último elemento en entrar es
el primero en salir. En este proyecto, cada pizza registrada se apila; al
"deshacer" se retira la pizza del tope de la pila principal y se apila en una
pila secundaria; al "rehacer" ocurre el proceso inverso. La pila se implementó
manualmente con una **lista ligada de nodos** (`NodoPila`), donde cada nodo
tiene un puntero (`siguiente`) hacia el nodo que quedó debajo de él.

## 2. Arquitectura del proyecto

| Clase              | Responsabilidad                                                                 |
|---------------------|----------------------------------------------------------------------------------|
| `Pizza.java`         | Modelo de datos: nombre + arreglo fijo de 3 ingredientes.                        |
| `NodoPila.java`      | Nodo genérico de la lista ligada (dato + puntero `siguiente`).                   |
| `Pila.java`          | Pila manual genérica construida sobre `NodoPila`: `push()`, `pop()`, `peek()`, `isEmpty()`. |
| `GestionPedidos.java`| Clase de control: coordina la **Pila Principal (Undo)** y la **Pila Secundaria (Redo)**. |
| `Main.java`          | Menú interactivo en consola.                                                     |

**Pila Principal (Undo):** almacena los pedidos conforme se registran.
**Pila Secundaria (Redo):** almacena temporalmente los pedidos deshechos, para
poder recuperarlos con la acción "Rehacer".

## 3. Menú de la aplicación

```
1. Registrar Pedido (Escribir)  -> pide nombre y 3 ingredientes, hace push() en la pila principal
2. Deshacer (Undo)              -> pop() de la principal, push() a la secundaria
3. Rehacer (Redo)                -> pop() de la secundaria, push() a la principal
4. Mostrar Pedido Actual         -> peek() sobre la pila principal
0. Salir
```

## 4. Requisitos y ejecución

- **JDK:** Eclipse Temurin (o cualquier JDK 11+).
- **Entorno recomendado:** Visual Studio Code con el *Extension Pack for Java*.

### Compilar y ejecutar desde terminal

```bash
cd src
javac *.java -d ../bin
cd ../bin
java Main
```

### Ejecutar desde VS Code

1. Abrir la carpeta `PizzaTrack` en VS Code.
2. Abrir `src/Main.java`.
3. Presionar el botón **Run** (▶) que aparece sobre el método `main`.

## 5. Capturas de pantalla de la consola

<img width="1629" height="1000" alt="Evidencia1" src="https://github.com/user-attachments/assets/93b9a9e2-db44-4867-8839-cd11b42f9eac" />
<img width="1776" height="1032" alt="Evidencia2" src="https://github.com/user-attachments/assets/dc7f9f1a-39b6-4325-b1fc-c7f416150a21" />

## 6. Video de sustentación

> _Agregar aquí el enlace del video individual (YouTube, Drive o GitHub),
> máximo 3 minutos, donde se explique la lógica de `push()` y `pop()` y se
> muestre el ciclo Registro -> Deshacer -> Rehacer._

Enlace del video: `PENDIENTE`

## 7. Autores

- Nombre del/los integrante(s) del equipo.

## 8. Control de versiones

Este repositorio debe reflejar al menos 3 commits por cada integrante,
evidenciando el avance incremental del desarrollo (modelo de datos, pila
manual, sistema Undo/Redo, menú, documentación).
