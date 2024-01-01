# [Solucion] Ejercicio MVC en JAVA

## Modelo: Task y TaskManager

~~~java
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Devuelve una copia de la lista para evitar modificaciones externas
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        }
    }
}
~~~

## Vista: ConsoleView

~~~java
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int getUserOption() {
        System.out.println("1. Añadir tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }

    public String getTaskDescription() {
        System.out.print("Ingresa la descripción de la tarea: ");
        scanner.nextLine(); // Consume la línea nueva
        return scanner.nextLine();
    }

    public void displayTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ": " + task.getDescription() + (task.isCompleted() ? " (Completada)" : ""));
        }
    }
}
~~~

## Controlador: TaskController

~~~java
public class TaskController {
    private TaskManager manager;
    private ConsoleView view;

    public TaskController(TaskManager manager, ConsoleView view) {
        this.manager = manager;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            int option = view.getUserOption();
            switch (option) {
                case 1:
                    String desc = view.getTaskDescription();
                    manager.addTask(desc);
                    break;
                case 2:
                    view.displayTasks(manager.getTasks());
                    break;
                case 3:
                    view.displayTasks(manager.getTasks());
                    System.out.print("Elige el número de la tarea a completar: ");
                    int index = new Scanner(System.in).nextInt() - 1;
                    manager.completeTask(index);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
~~~

## Principal

~~~java
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        ConsoleView view = new ConsoleView();
        TaskController controller = new TaskController(manager, view);

        controller.run();
    }
}
~~~