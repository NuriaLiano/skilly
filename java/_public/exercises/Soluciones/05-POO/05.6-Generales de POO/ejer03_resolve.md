# Solución de Sistema de Gestión de Empleados

## Interfaz Bonificable

~~~java
public interface Bonificable {
    double calcularBono();
}
~~~

## Clase Empleado

~~~java
public class Empleado {
    private String nombre;
    private int ID;
    private double salarioBase;

    public Empleado(String nombre, int ID, double salarioBase) {
        this.nombre = nombre;
        this.ID = ID;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public void mostrarDetalles() {
        System.out.println("ID: " + ID + ", Nombre: " + nombre + ", Salario Base: " + salarioBase);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
~~~

## Clase Gerente

~~~java
public class Gerente extends Empleado implements Bonificable {
    private double bonoAnual;

    public Gerente(String nombre, int ID, double salarioBase, double bonoAnual) {
        super(nombre, ID, salarioBase);
        this.bonoAnual = bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return bonoAnual;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Bono Anual: " + bonoAnual);
    }
}
~~~

## Clase Empresa

~~~java
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados;

    public Empresa() {
        empleados = new ArrayList<>();
    }

    public void añadirEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrarDetalles();
            System.out.println("Salario Total: " + empleado.calcularSalario());
            System.out.println();
        }
    }
}
~~~

## Clase Main

~~~java
public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        Empleado empleado1 = new Empleado("Juan", 1, 30000);
        Gerente gerente1 = new Gerente("Ana", 2, 50000, 10000);

        empresa.añadirEmpleado(empleado1);
        empresa.añadirEmpleado(gerente1);

        empresa.mostrarEmpleados();
    }
}
~~~