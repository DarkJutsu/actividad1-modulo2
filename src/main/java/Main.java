import _interface.TaskRepository;
import entities.DataTaskRepo;
import entities.Task;
import entities.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TaskRepository taskRepo = new DataTaskRepo();
        TaskManager taskM = new TaskManager(taskRepo);

        while (true) {
            menu();
            int opt = in.nextInt();
            in.nextLine();

            switch (opt) {
                case 1:
                    System.out.println("Nombre de la tarea:");
                    String name = in.nextLine();
                    System.out.println("Descripcion: ");
                    String descrip = in.nextLine();
                    System.out.println("Prioridad (1-5): ");
                    int priori = in.nextInt();
                    in.nextLine();
                    taskM.createTask(name, descrip, priori);
                    System.out.println("Tarea creada.");
                    break;
                case 2:
                    System.out.println("Nombre de la tarea para actualizar: ");
                    String taskUpdateName = in.nextLine();
                    menuUpdate();
                    int statusOpt = in.nextInt();
                    in.nextLine();
                    String newStatus;
                    switch (statusOpt) {
                        case 1:
                            newStatus = "Pendiente";
                            break;
                        case 2:
                            newStatus = "En progreso";
                            break;
                        case 3:
                            newStatus = "Completada";
                            break;
                        default:
                            newStatus = "Pendiente";
                            System.out.println("Estado no valido. Estado por defecto: Pendiente");
                    }
                    taskM.updateTask(taskUpdateName, newStatus);
                    break;
                case 3:
                    System.out.println("\nTareas: ");
                    for (Task task : taskM.getAllTasks()) {
                        System.out.println(task.getName() + " - " + task.getStatus());
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private static void menu() {
        System.out.println("***************** GESTOR DE TAREAS *****************");
        System.out.println("1. Crear tarea.");
        System.out.println("2. Actualizar tarea.");
        System.out.println("3. Mostrar todas las tareas.");
        System.out.println("4. Salir.");
        System.out.println("Seleccione una opcion: ");
    }

    private static void menuUpdate() {
        System.out.println("***************** Seleccione el nuevo estado: ");
        System.out.println("1. Pendiente.");
        System.out.println("2. En progreso.");
        System.out.println("3. Completada.");
    }
}
