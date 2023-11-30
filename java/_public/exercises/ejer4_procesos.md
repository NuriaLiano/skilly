# Ejercicio de Comunicación y Sincronización entre Tres Procesos en Java

Desarrolla un programa en Java que realice las siguientes operaciones usando tres procesos:

- Primer Proceso (ls -l): Ejecutar un proceso que liste todos los archivos y directorios en el directorio actual con detalles (ls -l en sistemas Unix/Linux).
-Segundo Proceso (Filtrado con grep): El segundo proceso debe filtrar la salida del primer proceso para mostrar solo los archivos regulares (no directorios). Utiliza grep para esto.
- Tercer Proceso (Contar con wc): El tercer proceso debe contar cuántas líneas (archivos regulares) han sido filtradas por el segundo proceso. Usa el comando wc -l.
- Sincronización y Redirección: Asegúrate de que los procesos se ejecuten en el orden correcto, con la salida de uno sirviendo como entrada para el siguiente.
- Mostrar Resultado Final y Códigos de Salida: El programa debe imprimir en la consola el resultado final del tercer proceso y los códigos de salida de todos los procesos.