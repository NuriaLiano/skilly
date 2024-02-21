# Sistema de Gestión de Pedidos para Servicio de Entrega a Domicilio

## Objetivo

Desarrollar un sistema de gestión de pedidos para un servicio de entrega a domicilio similar a Glovo o Just Eat, utilizando PHP para crear una API RESTful que interactúe con una base de datos MySQL. El sistema permitirá realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre los pedidos. Además, se desarrollará un frontend sencillo para interactuar con la API.

## Base de datos

~~~sql
-- Creación de la base de datos
CREATE DATABASE delivery_service CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Selección de la base de datos
USE delivery_service;

-- Creación de la tabla de pedidos
CREATE TABLE orders (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    address TEXT,
    order_details TEXT,
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar datos
INSERT INTO orders (customer_name, address, order_details, status) VALUES
('Alex Doe', '1234 Main St, Anytown', 'Pizza Margherita, Coca Cola', 'preparing'),
('Jane Smith', '5678 Market St, Anycity', 'Veggie Burger, Fries', 'on the way');

~~~

## Métodos y funcionalidades

- obtenerPedidos(): Retorna todos los pedidos existentes en la base de datos.
- obtenerPedidoPorID($id): Retorna los detalles de un pedido específico basado en su ID.
- agregarPedido($pedido): Añade un nuevo pedido a la base de datos con los datos proporcionados.
- modificarPedido($pedido, $id): Actualiza los detalles de un pedido existente identificado por su ID.
- eliminarPedido($id): Elimina un pedido de la base de datos basado en su ID.

## EndPoints de la API

- GET /orders: Lista todos los pedidos.
- GET /orders/{id}: Obtiene los detalles de un pedido específico.
- POST /orders: Crea un nuevo pedido.
- PUT /orders/{id}: Actualiza un pedido existente.
- DELETE /orders/{id}: Elimina un pedido.

## Frontend

El frontend deberá incluir las siguientes páginas y funcionalidades:

- Listado de Pedidos:
  - Muestra todos los pedidos con su customer_name, address, order_details, y status.
  - Incluye enlaces o botones para editar o eliminar cada pedido.
- Formulario de Creación de Pedidos:
  - Permite introducir los datos de un nuevo pedido: customer_name, address, y order_details.
  - Envía los datos a la API para crear un nuevo pedido.
- Formulario de Edición de Pedidos:
- Permite modificar los datos de un pedido existente.
- Carga los datos actuales del pedido y permite cambiar cualquier detalle.
- Envía los datos actualizados a la API para actualizar el pedido.
- Eliminar Pedidos:
  - Ofrece la opción de eliminar un pedido, ya sea desde el listado de pedidos con un botón de eliminar en cada fila o a través de una página de confirmación de eliminación.

## Implementaciones adicionales

- Validaciones: Asegúrate de validar los datos en el frontend antes de enviarlos a la API para evitar envíos de datos incorrectos o mal formados.
- Mensajes de Éxito/Error: Implementa notificaciones o mensajes para informar al usuario sobre el resultado de sus acciones (por ejemplo, si un pedido se ha creado o actualizado correctamente, o si ocurrió un error).
- Estilos CSS: Aunque el enfoque está en la funcionalidad, aplicar estilos básicos para mejorar la usabilidad y apariencia del frontend.