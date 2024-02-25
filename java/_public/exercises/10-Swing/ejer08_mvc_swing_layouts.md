# Ejercicio: Aplicación de Lista de Tareas con layouts

Objetivo: Desarrollar una aplicación de escritorio utilizando Java Swing para gestionar una lista de tareas, aplicando diferentes layouts y el patrón MVC.

## Descripción

La aplicación permitirá a los usuarios:

- Añadir nuevas tareas a una lista.
- Marcar tareas como completadas.
- Eliminar tareas de la lista.

## Componentes MVC

- **Modelo**: Representa la lista de tareas y su estado (completado/no completado).
- **Vista**: Interfaz de usuario con botones, campo de texto y visualización de la lista.
- **Controlador**: Lógica para añadir, marcar y eliminar tareas, conectando Vista y Modelo.

## Layouts

- **BorderLayout**: Para el diseño general de la ventana.
- **FlowLayout**: Para el panel de entrada de tareas.
- **BoxLayout**: Para organizar los componentes de la lista de tareas.

## Pasos

1. **Modelo**:
   - Crear clases `Tarea` y `GestorTareas`.
2. **Vista**:
   - Diseñar la interfaz de usuario con `JFrame`, `JPanel`, `JList`/`JTable` y botones.
3. **Controlador**:
   - Implementar la lógica de interacción entre la vista y el modelo.
4. **Pruebas**:
   - Verificar la funcionalidad de añadir, marcar y eliminar tareas.
   - Asegurar la correcta actualización de la interfaz de usuario.