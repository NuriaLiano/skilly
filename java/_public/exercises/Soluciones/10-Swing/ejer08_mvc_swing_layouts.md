# [Solución] Ejercicio: Aplicación de Lista de Tareas con layouts

## Modelo: Tarea

~~~java
public class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Método para marcar la tarea como completada
    public void completar() {
        this.completada = true;
    }

    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Representación en texto de la tarea, útil para mostrar en la lista
    @Override
    public String toString() {
        return (completada ? "[Completada] " : "[Pendiente] ") + descripcion;
    }
}
~~~

## Modelo: GestorTareas

~~~java
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    // Añadir una nueva tarea a la lista
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    // Eliminar una tarea de la lista
    public void eliminarTarea(Tarea tarea) {
        tareas.remove(tarea);
    }

    // Marcar una tarea como completada
    public void completarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).completar();
        }
    }

    // Obtener la lista de tareas
    public List<Tarea> getTareas() {
        return tareas;
    }

    // Método para obtener una representación de las tareas
    public String[] obtenerDescripcionTareas() {
        String[] descripcion = new String[tareas.size()];
        for (int i = 0; i < tareas.size(); i++) {
            descripcion[i] = tareas.get(i).toString();
        }
        return descripcion;
    }
}
~~~

## Vista: VistaTareas

~~~java
import javax.swing.*;
import java.awt.*;

public class VistaTareas extends JFrame {
    private JButton btnAgregar, btnEliminar, btnMarcar;
    private JTextField txtTarea;
    private JList<String> listaTareas;
    private DefaultListModel<String> modeloLista;

    public VistaTareas() {
        super("Lista de Tareas");

        // Inicialización de componentes
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnMarcar = new JButton("Marcar como Completada");
        txtTarea = new JTextField(20);
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);

        // Panel para entrada de tareas
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new FlowLayout());
        panelEntrada.add(txtTarea);
        panelEntrada.add(btnAgregar);

        // Panel para lista de tareas
        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.add(new JScrollPane(listaTareas));
        panelLista.add(btnMarcar);
        panelLista.add(btnEliminar);

        // Agregando paneles al JFrame
        setLayout(new BorderLayout());
        add(panelEntrada, BorderLayout.NORTH);
        add(panelLista, BorderLayout.CENTER);

        // Configuraciones adicionales del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    }

    // Getters para los componentes
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnMarcar() {
        return btnMarcar;
    }

    public JTextField getTxtTarea() {
        return txtTarea;
    }

    public JList<String> getListaTareas() {
        return listaTareas;
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    // Método para actualizar la lista de tareas en la UI
    public void actualizarListaTareas(String[] tareas) {
        modeloLista.clear();
        for (String tarea : tareas) {
            modeloLista.addElement(tarea);
        }
    }
}
~~~

## Controlador: ControladorTareas

~~~java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTareas {
    private VistaTareas vista;
    private GestorTareas modelo;

    public ControladorTareas(VistaTareas vista, GestorTareas modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Listeners para los botones
        this.vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });

        this.vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea();
            }
        });

        this.vista.getBtnMarcar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcarTarea();
            }
        });
    }

    private void agregarTarea() {
        String textoTarea = vista.getTxtTarea().getText();
        if (!textoTarea.isEmpty()) {
            Tarea nuevaTarea = new Tarea(textoTarea);
            modelo.agregarTarea(nuevaTarea);
            vista.getModeloLista().addElement(nuevaTarea.toString());
            vista.getTxtTarea().setText(""); // Limpiar el campo de texto
        }
    }

    private void eliminarTarea() {
        int indiceSeleccionado = vista.getListaTareas().getSelectedIndex();
        if (indiceSeleccionado != -1) {
            modelo.eliminarTarea(modelo.getTareas().get(indiceSeleccionado));
            vista.getModeloLista().remove(indiceSeleccionado);
        }
    }

    private void marcarTarea() {
        int indiceSeleccionado = vista.getListaTareas().getSelectedIndex();
        if (indiceSeleccionado != -1) {
            modelo.getTareas().get(indiceSeleccionado).completar();
            // Actualizar la lista para reflejar el cambio
            vista.actualizarListaTareas(modelo.obtenerDescripcionTareas());
        }
    }
}
~~~

## Clase Principal: AplicaciónTareas

~~~java
public class AplicacionTareas {

    public static void main(String[] args) {
        GestorTareas modelo = new GestorTareas();
        VistaTareas vista = new VistaTareas();
        ControladorTareas controlador = new ControladorTareas(vista, modelo);

        vista.setVisible(true);
    }
}
~~~
