# Ejercicio: Sistema de Gestión de Empleados

**Objetivo**
Desarrollar un sistema para gestionar diferentes tipos de empleados en una empresa. La empresa tiene empleados regulares y gerentes. Todos los empleados tienen un salario base, pero los gerentes también tienen un bono anual basado en el rendimiento.

## Clase Empleado

- Atributos: nombre (String), ID (int), salarioBase (double).
- Constructor para establecer todos los atributos.
- Métodos:
  - calcularSalario(): Devuelve el salarioBase.
  - mostrarDetalles(): Imprime los detalles del empleado.

## Interface Bonificable

- Método calcularBono(): Cualquier clase que implemente Bonificable deberá proporcionar una implementación para calcular un bono.

## Clase Gerente

- Extiende Empleado e implementa Bonificable.
- Atributos adicionales: bonoAnual (double).
- Constructor para establecer todos los atributos (incluyendo los de Empleado).
- Sobreescribe calcularSalario() para incluir bonoAnual.
- Implementa calcularBono() para calcular el bono anual basado en un porcentaje del salarioBase.
- Sobreescribe mostrarDetalles() para incluir detalles sobre el bono anual.

## Clase Empresa

- Atributos: lista de empleados (ArrayList de Empleado).
- Métodos:
  - añadirEmpleado(Empleado empleado): Añade un nuevo empleado a la lista.
  - mostrarEmpleados(): Imprime los detalles de todos los empleados.

## Ejemplo de uso

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