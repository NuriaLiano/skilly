# [Solución] Sistema de Gestión de Vehículos

## Vehículo (Clase abstracta)

~~~java
abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;

    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void mostrarDetalles() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }

    abstract public String tipoVehiculo();
}
~~~

## Automóvil (clase hija de Vehículo)

~~~java
class Automovil extends Vehiculo {
    private int cantidadPuertas;

    public Automovil(String marca, String modelo, int año, int cantidadPuertas) {
        super(marca, modelo, año);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String tipoVehiculo() {
        return "Automóvil";
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Cantidad de Puertas: " + cantidadPuertas);
    }
}
~~~

## Motocicleta (clase hija de Vehículo)

~~~java
class Motocicleta extends Vehiculo {
    private int cilindrada;

    public Motocicleta(String marca, String modelo, int año, int cilindrada) {
        super(marca, modelo, año);
        this.cilindrada = cilindrada;
    }

    @Override
    public String tipoVehiculo() {
        return "Motocicleta";
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Cilindrada: " + cilindrada);
    }
}
~~~

## SistemaGestionVehiculos (main)

~~~java
public class SistemaGestionVehiculos {
    public static void main(String[] args) {
        Automovil auto = new Automovil("Toyota", "Corolla", 2020, 4);
        Motocicleta moto = new Motocicleta("Yamaha", "YZF", 2019, 250);

        auto.mostrarDetalles();
        System.out.println("Tipo: " + auto.tipoVehiculo());
        System.out.println();
        moto.mostrarDetalles();
        System.out.println("Tipo: " + moto.tipoVehiculo());
    }
}
~~~
