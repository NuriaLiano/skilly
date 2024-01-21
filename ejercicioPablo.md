# Ejercicio de Cliente-Servidor en Java

## Objetivo
Desarrollar una aplicación en Java que implemente una comunicación básica cliente-servidor utilizando sockets TCP. El servidor deberá ser capaz de gestionar múltiples clientes simultáneamente.

## Especificaciones

### Servidor
- El servidor escuchará en un puerto específico (por ejemplo, 5000).
- Debe ser capaz de aceptar múltiples conexiones de clientes de manera concurrente.
- Cuando un cliente se conecte, el servidor recibirá un mensaje de texto y lo imprimirá en la consola.
- Tras recibir el mensaje, el servidor enviará una respuesta de confirmación al cliente.
- El servidor debe manejar excepciones adecuadamente, especialmente para casos de desconexión o errores de red.

### Cliente
- El cliente intentará conectarse al servidor usando la dirección IP del servidor y el puerto especificado.
- Una vez conectado, el cliente enviará un mensaje de texto al servidor.
- Después de enviar el mensaje, el cliente esperará una respuesta del servidor.
- Al recibir la respuesta del servidor, el cliente la imprimirá en la consola y luego cerrará la conexión.

## Tareas Adicionales (Opcionales)
1. Modificar el servidor para que responda con un mensaje diferente basado en el mensaje recibido.
2. Implementar una funcionalidad de "chat" donde el servidor y el cliente puedan intercambiar mensajes de manera continua hasta que uno de ellos envíe un comando de "salida".
3. Añadir la capacidad de transferir archivos desde el cliente al servidor.

## Consideraciones
- Utilizar hilos (Threads) en el servidor para manejar múltiples conexiones de clientes.
- Asegurarse de que tanto el cliente como el servidor manejen adecuadamente la desconexión y cierren los sockets y recursos asociados.
- Tratar de implementar una buena estructura de código y manejo de errores.

## Nota
Este ejercicio es una excelente oportunidad para entender los fundamentos de la programación de red en Java y la gestión de múltiples hilos de ejecución.