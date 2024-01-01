# Ejercicio: Sistema de Gestión de Relaciones para Empresas, Inversores y Afiliados con Spring

## Objetivo

Desarrollar una aplicación web para la gestión de relaciones entre empresas, inversores y afiliados, utilizando Spring Framework y aplicando el patrón Modelo-Vista-Controlador (MVC) y otras capas relacionadas.

## Descripción General

Crear una aplicación web que facilite a las empresas registrar y gestionar sus interacciones con inversores y afiliados. La aplicación debe ofrecer funcionalidades para el seguimiento de inversiones, actividades promocionales y comunicaciones.

## Requerimientos Funcionales

1. **Gestión de Empresas**:
   - Añadir, editar y eliminar información de empresas.
   - Gestionar la lista de inversores y afiliados asociados.

2. **Gestión de Inversores**:
   - Registrar nuevos inversores.
   - Gestionar detalles de inversiones (montos, fechas).

3. **Gestión de Afiliados**:
   - Registrar actividades promocionales o eventos.
   - Seguimiento de contribuciones de afiliados.

4. **Comunicaciones**:
   - Facilitar la comunicación entre empresas, inversores y afiliados.
   - Registrar el historial de comunicaciones.

## Requerimientos Técnicos

1. **Modelo**:
   - Crear entidades `Empresa`, `Inversor`, `Afiliado`, `Inversion`, `Actividad` con JPA.

2. **Controlador**:
   - Implementar controladores (`@Controller`/`@RestController`).

3. **Repositorios**:
   - Crear repositorios para entidades (`@Repository`, `JpaRepository`).

4. **Servicios**:
   - Desarrollar servicios con lógica de negocio (`@Service`, `@Transactional`).

5. **Interfaz de Usuario**:
   - Diseñar vistas (HTML, CSS, JavaScript).

6. **Almacenamiento**:
   - Sistema para documentos importantes (contratos, acuerdos).

