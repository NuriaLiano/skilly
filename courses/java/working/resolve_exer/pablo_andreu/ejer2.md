En este ejercicio se crearán hilos para resolver el problema del Productor-Consumidor, esta vez usando
listas. Los elementos a insertar en la lista serán objetos de tipo Producto (con atributos básicos de: nombre
y cantidad).
Para la correcta resolución del ejercicio debemos crear:
- Una clase Producto que contendrá la lista donde se producirán y consumirán datos.
- Hilos Productor y Consumidor, cada uno de ellos producirán y consumirán datos de la lista.
- La velocidad del Consumidor debe ser el doble de la velocidad del Productor.
- Deben crearse dos Productores y un Consumidor en la aplicación.

## Clase Producto

~~~java
public class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Métodos getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
~~~

## Clase Almacen

~~~java
import java.util.LinkedList;
import java.util.Queue;

public class Almacen {
    private Queue<Producto> productos = new LinkedList<>();

    // Método sincronizado para añadir productos
    public synchronized void producir(Producto producto) throws InterruptedException {
        productos.add(producto);
        // Notificar al consumidor que hay un nuevo producto
        notifyAll();
    }

    // Método sincronizado para consumir productos
    public synchronized Producto consumir() throws InterruptedException {
        while (productos.isEmpty()) {
            wait(); // Espera a que haya productos
        }
        return productos.poll();
    }
}
~~~

## Clase Productor

~~~java
public class Productor implements Runnable {
    private Almacen almacen;

    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Producto producto = new Producto("Producto", 1); // Crear nuevo producto
                almacen.producir(producto);
                Thread.sleep(1000); // Esperar 1 segundo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
~~~

## Clase Consumidor

~~~java
public class Consumidor implements Runnable {
    private Almacen almacen;

    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Producto producto = almacen.consumir();
                // Procesar el producto consumido
                Thread.sleep(500); // Consumidor el doble de rápido
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
~~~

## Clase main

~~~java
public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Thread productor1 = new Thread(new Productor(almacen));
        Thread productor2 = new Thread(new Productor(almacen));
        Thread consumidor = new Thread(new Consumidor(almacen));

        productor1.start();
        productor2.start();
        consumidor.start();
    }
}
~~~