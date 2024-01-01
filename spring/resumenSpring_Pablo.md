# Spring

## Anotaciones clave

| Capa          | Anotaciones Clave                                      | Descripción                                                        |
|---------------|--------------------------------------------------------|--------------------------------------------------------------------|
| Modelo        | `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column` | Utilizadas para definir entidades y sus mapeos a la base de datos. |
|               | `@ManyToOne`, `@OneToMany`, `@OneToOne`, `@ManyToMany`  | Definen relaciones entre entidades.                                |
| Controlador   | `@Controller`, `@RestController`                         | Marcan clases como controladores en Spring MVC o REST.             |
|               | `@RequestMapping`, `@GetMapping`, `@PostMapping`         | Mapean solicitudes HTTP a métodos del controlador.                 |
|               | `@PathVariable`, `@RequestParam`, `@RequestBody`         | Extraen datos de las solicitudes HTTP.                             |
| Repositorios  | `@Repository`                                           | Marcan interfaces como repositorios de Spring Data.                |
|               | `@Query`, `@Param`                                      | Se utilizan para definir consultas personalizadas.                 |
| Servicios     | `@Service`                                              | Marcan clases como servicios que contienen la lógica de negocio.   |
|               | `@Transactional`                                        | Indican que un método o clase debe ser ejecutado dentro de una transacción. |
| Storage       | -                                                        | No hay anotaciones específicas de Spring, pero se usan servicios y posiblemente `@Component`. |

## Patron de diseño

- **Modelo**:
    - Contiene las clases de dominio o entidades que representan la lógica y los datos de negocio.
    - En una aplicación Spring, estos suelen ser objetos Java simples (POJOs) que se mapean a una base de datos, por ejemplo, mediante JPA (Java Persistence API).

- **Controlador**:
    - Aquí se ubican las clases que manejan las solicitudes HTTP.
    - Estos controladores actúan como intermediarios entre la Vista (la interfaz de usuario o las solicitudes del cliente) y el modelo, procesando los datos antes de enviarlos al usuario o actualizar el modelo.

- **Repositorios**:
    - Esta capa abstrae el acceso a los datos, normalmente a través de interfaces que definen operaciones de base de datos.
    - En Spring, esto se hace a menudo utilizando Spring Data JPA o herramientas similares, proporcionando una manera sencilla y declarativa de interactuar con la base de datos.

- **Servicios**:
    - Contiene la lógica de negocio y las reglas de la aplicación.
    - Los servicios interactúan con los repositorios para recuperar datos y ejecutar operaciones de negocio, y son llamados por los controladores.

- **Storage**:
    - Esta carpeta podría estar dedicada a la gestión de archivos, como el almacenamiento y la recuperación de archivos multimedia, documentos, etc.
    - No es una parte estándar del patrón MVC, pero es una práctica común en aplicaciones que necesitan manejar almacenamiento de archivos.

## Modelos

Para definir modelos (o entidades) en Spring, generalmente usamos JPA (Java Persistence API). Aquí están las anotaciones y conceptos clave:

- **@Entity**:
    - Esta anotación marca una clase como una entidad JPA, lo que significa que está vinculada a una tabla de base de datos.
    - Ejemplo: `@Entity`

- **@Table**:
    - Especifica el nombre de la tabla en la base de datos que está mapeada a la entidad.
    - Ejemplo: `@Table(name = "usuarios")`

- **@Id**:
    - Marca un campo como la llave primaria de la entidad.
    - Ejemplo: `@Id`

- **@GeneratedValue**:
    - Especifica la estrategia de generación para los valores de la llave primaria.
    - Comúnmente usada con `@Id`.
    - Ejemplo: `@GeneratedValue(strategy = GenerationType.IDENTITY)`

- **@Column**:
    - Define propiedades específicas para una columna en la base de datos, como su nombre, longitud, etc.
    - Ejemplo: `@Column(name = "nombre", length = 50)`

- **@ManyToOne**, **@OneToMany**, **@OneToOne**, **@ManyToMany**:
    - Estas anotaciones definen las relaciones entre entidades (muchos a uno, uno a muchos, etc.).
    - Ejemplo: `@ManyToOne`

- **@Transient**:
    - Marca un campo para que no sea persistido en la base de datos.
    - Útil para campos calculados o temporales.

### Consideraciones Adicionales

- **Validaciones**: Spring soporta anotaciones de validación como `@NotNull`, `@Size`, etc., que pueden ser utilizadas para validar los datos antes de su persistencia.
- **Lombok**: Una biblioteca que reduce el código repetitivo mediante anotaciones como `@Data`, `@AllArgsConstructor`, etc., generando automáticamente getters, setters, y otros métodos comunes.
- **Relaciones**: Define las relaciones entre entidades cuidadosamente para reflejar correctamente la estructura y relaciones de tu base de datos.

### Ejemplo Básico de Entidad

```java
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    // Otros campos, getters y setters
}
```

## Controladores

Los controladores en Spring son clases que manejan las solicitudes entrantes. A continuación, se presentan las anotaciones y prácticas clave:

- **@Controller**:
    - Utilizada para marcar una clase como controlador en Spring MVC.
    - Utilizada típicamente cuando las respuestas son vistas (JSP, Thymeleaf, etc.).
    - Ejemplo: `@Controller`

- **@RestController**:
    - Una especialización de `@Controller` que agrega `@ResponseBody` a todos los métodos.
    - Utilizada para servicios RESTful, donde las respuestas son generalmente JSON o XML.
    - Ejemplo: `@RestController`

- **@RequestMapping** (y variantes como `@GetMapping`, `@PostMapping`, etc.):
    - Define la URL y el método HTTP para mapear solicitudes a métodos del controlador.
    - Las variantes ofrecen una forma más específica y concisa de mapear métodos HTTP.
    - Ejemplo: `@GetMapping("/usuarios")`

- **@PathVariable**:
    - Extrae valores de la URL.
    - Ejemplo: `public String obtenerUsuario(@PathVariable("id") Long id)`

- **@RequestParam**:
    - Se usa para acceder a los parámetros de consulta de la solicitud.
    - Ejemplo: `public String obtenerUsuariosPorNombre(@RequestParam("nombre") String nombre)`

- **@RequestBody**:
    - Se usa para convertir el cuerpo de la solicitud HTTP a un objeto Java.
    - Comúnmente utilizado en APIs REST.
    - Ejemplo: `public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario)`

- **@ResponseBody**:
    - Indica que el valor de retorno del método se serializa directamente al cuerpo de la respuesta HTTP.
    - Automáticamente aplicado en clases anotadas con `@RestController`.
    - Ejemplo: `@ResponseBody @GetMapping("/usuarios/{id}")`

- **@ResponseStatus**:
    - Permite especificar el código de estado HTTP de la respuesta.
    - Ejemplo: `@ResponseStatus(HttpStatus.CREATED)`

### Consideraciones Adicionales

- **Inyección de Dependencias**: Los controladores suelen inyectar servicios para acceder a la lógica de negocio y los datos.
- **Manejo de Excepciones**: Utiliza `@ExceptionHandler` para manejar excepciones de forma elegante en los controladores.
- **Validación**: Usa anotaciones de validación en los parámetros de los métodos del controlador para validar la entrada.

### Ejemplo Básico de Controlador

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    // Otros métodos del controlador
}
```

## Repositorios

Los repositorios en Spring son interfaces que proporcionan una capa de abstracción sobre la lógica de acceso a datos. Aquí están las anotaciones y conceptos clave:

- **@Repository**:
    - Marca una clase como repositorio, que es un mecanismo de almacenamiento, recuperación y búsqueda de datos.
    - Generalmente no es necesario en interfaces que extienden de repositorios de Spring Data, ya que se incluye implícitamente.
    - Ejemplo: `@Repository`

- **Spring Data Repositories**:
    - Spring Data proporciona varias interfaces de repositorio como `JpaRepository`, `CrudRepository`, `PagingAndSortingRepository`.
    - Estas interfaces incluyen métodos CRUD (Crear, Leer, Actualizar, Eliminar) y más.
    - Ejemplo: `public interface UsuarioRepository extends JpaRepository<Usuario, Long>`

- **Métodos de Consulta Derivados**:
    - Spring Data permite definir métodos de consulta personalizados mediante convenciones de nomenclatura.
    - Ejemplo: `List<Usuario> findByNombre(String nombre);`

- **@Query**:
    - Permite definir una consulta personalizada utilizando JPQL (Java Persistence Query Language) o SQL nativo.
    - Ejemplo: `@Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")`

### Consideraciones Adicionales

- **Consultas Personalizadas**: Además de los métodos proporcionados por Spring Data, puedes escribir consultas personalizadas utilizando `@Query`.
- **Transaccionalidad**: Maneja la transaccionalidad a nivel de servicio preferiblemente, pero puedes utilizar `@Transactional` en repositorios para operaciones específicas.
- **Relaciones y Lazy Loading**: Entiende cómo manejar relaciones entre entidades, especialmente el comportamiento de carga perezosa (lazy loading) versus carga ansiosa (eager loading).

### Ejemplo Básico de Repositorio

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByApellido(String apellido);

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    List<Usuario> buscarPorNombre(@Param("nombre") String nombre);
}
```

## Servicios

Los servicios en Spring son clases que contienen la lógica de negocio y las reglas de la aplicación. Aquí están las anotaciones y conceptos clave:

- **@Service**:
    - Marca una clase como un servicio en Spring, que contiene la lógica de negocio.
    - Indica que la clase es un "Bean" de Spring y puede ser gestionado automáticamente (por ejemplo, inyección de dependencias).
    - Ejemplo: `@Service`

- **Inyección de Dependencias**:
    - Spring gestiona los servicios como beans y permite inyectar dependencias, como repositorios, utilizando `@Autowired` o constructores.
    - Ejemplo: `@Autowired private UsuarioRepository usuarioRepository;`

- **Transaccionalidad**:
    - La anotación `@Transactional` se utiliza para manejar transacciones a nivel de servicio.
    - Asegura la consistencia de los datos, manejando automáticamente el commit y rollback de las transacciones.
    - Ejemplo: `@Transactional`

### Consideraciones Adicionales

- **Separación de Responsabilidades**: Los servicios deben enfocarse en la lógica de negocio, mientras que el acceso a datos es responsabilidad de los repositorios.
- **Pruebas Unitarias**: Los servicios son un punto clave para implementar pruebas unitarias, asegurando que la lógica de negocio funcione como se espera.
- **Manejo de Excepciones**: Implementa un manejo de excepciones adecuado en los servicios para lidiar con situaciones inesperadas o errores de los repositorios.

## Ejemplo Básico de Servicio

```java
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica para crear un usuario
        return usuarioRepository.save(usuario);
    }

    // Otros métodos de servicio
}
```

## Creación de una Capa de Almacenamiento (Storage) en Spring

La capa de almacenamiento en una aplicación Spring se utiliza para gestionar archivos y otros recursos. A continuación se presentan conceptos y prácticas clave:

- **Servicio de Almacenamiento**:
    - Crea un servicio dedicado para manejar operaciones de almacenamiento.
    - Este servicio puede encargarse de cargar, almacenar y recuperar archivos.
    - Ejemplo: `public class StorageService { ... }`

- **Manejo de Archivos**:
    - Utiliza clases de Java como `File` y `Path` para manejar operaciones de archivos.
    - Ejemplo: `Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);`

- **Integración con Spring MVC**:
    - Integra el servicio de almacenamiento con los controladores de Spring MVC para manejar la carga y descarga de archivos.
    - Ejemplo: `@PostMapping("/upload") public String handleFileUpload(@RequestParam("file") MultipartFile file) { ... }`

### Consideraciones Adicionales

- **Seguridad**: Asegúrate de implementar medidas de seguridad adecuadas, como la validación de tipos de archivo y el manejo de permisos.
- **Gestión de Errores**: Implementa un manejo de errores robusto para lidiar con posibles problemas de IO o validación.
- **Configuración**: Configura adecuadamente las rutas de almacenamiento y otras propiedades relacionadas.

### Ejemplo Básico de Servicio de Almacenamiento

```java
@Service
public class StorageService {

    private final Path rootLocation;

    @Autowired
    public StorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    public void store(MultipartFile file) {
        // Lógica para almacenar el archivo
    }

    // Otros métodos de almacenamiento
}
