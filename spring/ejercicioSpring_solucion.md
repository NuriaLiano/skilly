## Solución: Sistema de Gestión de Relaciones para Empresas, Inversores y Afiliados con Spring

## Estructura del proyecto

- src
  - main
    - java
      - com
        - tuempresa
          - modelo
            - Empresa.java
            - Inversor.java
            - Afiliado.java
            - Inversion.java
            - Actividad.java
          - controlador
            - EmpresaController.java
            - InversorController.java
            - AfiliadoController.java
          - repositorio
            - EmpresaRepository.java
            - InversorRepository.java
            - AfiliadoRepository.java
          - servicio
            - EmpresaService.java
            - InversorService.java
            - AfiliadoService.java
          - almacenamiento
            - StorageService.java
    - resources
      - application.properties
  - test
    - java
      - com
        - tuempresa
          - ...

## Modelo (Empresa.java)

~~~java
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Getters y setters
}
~~~

## Modelo (Inversor.java)

~~~java
@Entity
@Table(name = "inversores")
public class Inversor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relaciones, constructores, getters y setters
}
~~~

## Modelo (Afiliado.java)

~~~java
@Entity
@Table(name = "afiliados")
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relaciones, constructores, getters y setters
}

~~~

## Modelo (Inversion.java)

~~~java
@Entity
@Table(name = "inversiones")
public class Inversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "inversor_id")
    private Inversor inversor;

    private LocalDate fechaInversion;

    // Constructores, getters y setters
}
~~~

## Modelo (Actividad.java)

~~~java
@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "afiliado_id")
    private Afiliado afiliado;

    private LocalDate fechaActividad;

    // Constructores, getters y setters
}
~~~

**NOTAS IMPORTANTES**

- Relaciones: Estos modelos pueden tener relaciones entre sí. Por ejemplo, Inversion puede estar relacionada con Empresa e Inversor. Estas relaciones se representan usando anotaciones como @ManyToOne y @JoinColumn.
- Atributos Adicionales: Puedes añadir más atributos a cada modelo según las necesidades de tu aplicación.
- Validaciones: Utiliza anotaciones como @NotNull, @Size, etc., para validar los campos.
- Fecha: Para las fechas, se usa LocalDate de Java 8, que es recomendado para nuevas aplicaciones.
- BigDecimal: Para representar cantidades de dinero o valores precisos, se utiliza BigDecimal.

## Controlador (EmpresaController.java)

~~~java
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerPorId(@PathVariable Long id) {
        return empresaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaService.guardarEmpresa(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaService.actualizarEmpresa(id, empresa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.ok().build();
    }
}

~~~

## Controlador (InversorController.java)

~~~java
@RestController
@RequestMapping("/inversores")
public class InversorController {

    @Autowired
    private InversorService inversorService;

    @GetMapping
    public List<Inversor> listarTodos() {
        return inversorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inversor> obtenerPorId(@PathVariable Long id) {
        return inversorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inversor crearInversor(@RequestBody Inversor inversor) {
        return inversorService.guardarInversor(inversor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inversor> actualizarInversor(@PathVariable Long id, @RequestBody Inversor inversor) {
        return inversorService.actualizarInversor(id, inversor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInversor(@PathVariable Long id) {
        inversorService.eliminarInversor(id);
        return ResponseEntity.ok().build();
    }
}
~~~

## Controlador (AfiliadoController.java)

~~~java
@RestController
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoService afiliadoService;

    @GetMapping
    public List<Afiliado> listarTodos() {
        return afiliadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Afiliado> obtenerPorId(@PathVariable Long id) {
        return afiliadoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Afiliado crearAfiliado(@RequestBody Afiliado afiliado) {
        return afiliadoService.guardarAfiliado(afiliado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Afiliado> actualizarAfiliado(@PathVariable Long id, @RequestBody Afiliado afiliado) {
        return afiliadoService.actualizarAfiliado(id, afiliado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAfiliado(@PathVariable Long id) {
        afiliadoService.eliminarAfiliado(id);
        return ResponseEntity.ok().build();
    }
}
~~~

**NOTAS IMPORTANTES**

- @Autowired: Se utiliza para inyectar dependencias de los servicios correspondientes.
- Métodos CRUD: Cada controlador contiene métodos para crear, leer, actualizar y eliminar entidades.
- ResponseEntity: Se utiliza para proporcionar respuestas HTTP más detalladas.
- @PathVariable y @RequestBody: Se usan para capturar parámetros de URL y cuerpos de solicitud, respectivamente.

## Repositorio (EmpresaRepository.java)

~~~java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuempresa.modelo.Empresa;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByNombreContaining(String nombre);
    List<Empresa> findByNombreStartingWith(String prefijo);
}
~~~

## Repositorio (InversorRepository.java)

~~~java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuempresa.modelo.Inversor;

import java.util.List;

@Repository
public interface InversorRepository extends JpaRepository<Inversor, Long> {
    List<Inversor> findByNombreContaining(String nombre);
    List<Inversor> findByApellido(String apellido);
}
~~~

## Repositorio (AfiliadoRepository.java)

~~~java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tuempresa.modelo.Afiliado;

import java.util.List;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {
    List<Afiliado> findByNombreContaining(String nombre);
    List<Afiliado> findByActividadReciente(boolean actividadReciente);
}
~~~

**EXPLICACIÓN DE LOS MÉTODOS**

- findByNombreContaining: Busca entidades cuyo nombre contenga un string específico. Por ejemplo, encontrar todas las empresas cuyo nombre contenga "tech".
- findByNombreStartingWith: Busca entidades cuyo nombre comience con un prefijo dado.
- findByApellido: Para el InversorRepository, este método busca inversores por su apellido.
- findByActividadReciente: Para el AfiliadoRepository, este método podría buscar afiliados basados en si han tenido una actividad reciente (esto supone que tienes un campo en Afiliado que indica actividad reciente).

**NOTAS IMPORTANTES**

- @Repository: Aunque no es estrictamente necesario anotar estas interfaces con @Repository debido a que JpaRepository ya está marcado con @NoRepositoryBean, es una buena práctica hacerlo para mejorar la claridad del código.
- Métodos Adicionales: Puedes definir métodos de búsqueda personalizados en estos repositorios según tus necesidades. Spring Data JPA permite definir consultas de manera intuitiva a través de nombres de métodos, o puedes usar la anotación @Query para consultas más complejas.
- Tipos Genéricos: JpaRepository<T, ID> requiere dos parámetros genéricos: el tipo de entidad y el tipo del ID de la entidad.

## Servicio (EmpresaService.java)

~~~java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tuempresa.modelo.Empresa;
import com.tuempresa.repositorio.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Transactional
    public Empresa guardarEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Transactional
    public Optional<Empresa> actualizarEmpresa(Long id, Empresa empresa) {
        return empresaRepository.findById(id).map(emp -> {
            emp.setNombre(empresa.getNombre());
            // Otros campos
            return empresaRepository.save(emp);
        });
    }

    @Transactional
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
~~~

## Servicio (InversorService.java)

~~~java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tuempresa.modelo.Inversor;
import com.tuempresa.repositorio.InversorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InversorService {

    @Autowired
    private InversorRepository inversorRepository;

    @Transactional(readOnly = true)
    public List<Inversor> listarTodos() {
        return inversorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Inversor> obtenerPorId(Long id) {
        return inversorRepository.findById(id);
    }

    @Transactional
    public Inversor guardarInversor(Inversor inversor) {
        return inversorRepository.save(inversor);
    }

    @Transactional
    public Optional<Inversor> actualizarInversor(Long id, Inversor inversor) {
        return inversorRepository.findById(id).map(inv -> {
            inv.setNombre(inversor.getNombre());
            // Otros campos
            return inversorRepository.save(inv);
        });
    }

    @Transactional
    public void eliminarInversor(Long id) {
        inversorRepository.deleteById(id);
    }
}
~~~

## Servicio (AfiliadoService.java)

~~~java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tuempresa.modelo.Afiliado;
import com.tuempresa.repositorio.AfiliadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoService {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Transactional(readOnly = true)
    public List<Afiliado> listarTodos() {
        return afiliadoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Afiliado> obtenerPorId(Long id) {
        return afiliadoRepository.findById(id);
    }

    @Transactional
    public Afiliado guardarAfiliado(Afiliado afiliado) {
        return afiliadoRepository.save(afiliado);
    }

    @Transactional
    public Optional<Afiliado> actualizarAfiliado(Long id, Afiliado afiliado) {
        return afiliadoRepository.findById(id).map(afil -> {
            afil.setNombre(afiliado.getNombre());
            // Otros campos
            return afiliadoRepository.save(afil);
        });
    }

    @Transactional
    public void eliminarAfiliado(Long id) {
        afiliadoRepository.deleteById(id);
    }
}
~~~

**NOTAS IMPORTANTES**

- @Transactional: La anotación @Transactional asegura la integridad de las transacciones, especialmente cuando se realizan modificaciones en la base de datos.
- Lógica de Negocio: La lógica específica de tu negocio debe ser implementada en estos servicios
- Inyección de Dependencias: Se utiliza @Autowired para inyectar los repositorios correspondientes en cada servicio.

## Almacenamiento (StorageService.java)

~~~java
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    private final Path rootLocation = Paths.get("upload-dir");

    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new RuntimeException(
                        "Cannot store file outside current directory.");
            }
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    // Aquí puedes agregar otros métodos, como delete, load, etc.
}
~~~

## Interfaz gráfica (index.html)

~~~java
<!-- src/main/resources/templates/empresas.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Gestión de Empresas</title>
</head>
<body>
    <h1>Empresas</h1>

    <div>
        <h2>Añadir Empresa</h2>
        <form action="#" th:action="@{/empresas}" th:object="${empresa}" method="post">
            <p>Nombre: <input type="text" th:field="*{nombre}" /></p>
            <!-- Otros campos de Empresa -->
            <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
        </form>
    </div>

    <div>
        <h2>Listado de Empresas</h2>
        <table>
            <tr>
                <th>Nombre</th>
                <!-- Otros encabezados de columna -->
            </tr>
            <tr th:each="empresa : ${empresas}">
                <td th:text="${empresa.nombre}">Nombre</td>
                <!-- Otros campos de Empresa -->
            </tr>
        </table>
    </div>
</body>
</html>

~~~