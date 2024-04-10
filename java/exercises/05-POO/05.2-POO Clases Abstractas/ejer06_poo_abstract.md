# Sistema de Gestión de Vehículos

El objetivo es desarrollar un sistema básico de gestión de vehículos utilizando el concepto de clases abstractas y herencia en Java. Este sistema permitirá modelar diferentes tipos de vehículos, como automóviles y motocicletas, compartiendo propiedades y comportamientos comunes, a la vez que se diferencian en otros aspectos específicos.

## Clases

### Clase Abstracta Vehiculo

- Propósito: Servir como superclase para diferentes tipos de vehículos, definiendo propiedades y métodos comunes.
- Propiedades Comunes: marca (String), modelo (String), año (int).

#### Métodos

- Constructor: Inicializa las propiedades marca, modelo y año.
- mostrarDetalles(): Método no abstracto que imprime los detalles del vehículo, como marca, modelo y año.
- tipoVehiculo(): Método abstracto que será implementado por las subclases para retornar el tipo de vehículo (e.g., "Automóvil", "Motocicleta").

### Clase Automovil (extiende Vehiculo)

- Propósito: Representar un automóvil, especificando propiedades y comportamientos propios de este tipo de vehículo.
- Propiedad Específica: cantidadPuertas (int).

#### Métodos

- Constructor: Inicializa las propiedades de Vehiculo y cantidadPuertas.
- tipoVehiculo(): Implementa el método abstracto de la superclase para retornar "Automóvil".
- mostrarDetalles(): Sobrescribe el método de la superclase para añadir la impresión de cantidadPuertas.

### Clase Motocicleta (extiende Vehiculo)

- Propósito: Representar una motocicleta, con propiedades y comportamientos particulares de este tipo de vehículo.
- Propiedad Específica: cilindrada (int).

#### Métodos

- Constructor: Inicializa las propiedades de Vehiculo y cilindrada.
- tipoVehiculo(): Implementa el método abstracto de la superclase para retornar "Motocicleta".
- mostrarDetalles(): Sobrescribe el método de la superclase para incluir la impresión de cilindrada.
