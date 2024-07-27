import java.util.Scanner;

public class GestorDeTareasApp {
    public static void main(String[] args) {
        Manager taskManager = new GestorImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Añadir una nueva tarea");
            System.out.println("2. Modicicar tarea");
            System.out.println("3. Remover una tarea");
            System.out.println("4. Ver las tareas pendientes");
            System.out.println("5. Ver las tareas completadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione que dese hacer: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la tarea: ");
                    String description = scanner.nextLine();
                    Tarea task = new Tarea(taskManager.getPendingTasks().size() + 1, description);
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.print("ingrese el Id de la tarea: ");
                    int modifyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ingrese cual es la nueva descriocion: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("La tarea fue completada? (true/false): ");
                    boolean isCompleted = scanner.nextBoolean();
                    taskManager.modifyTask(modifyId, newDescription, isCompleted);
                    break;
                case 3:
                    System.out.print("Numero de la tarea que desea remover: ");
                    int removeId = scanner.nextInt();
                    taskManager.removeTask(removeId);
                    break;
                case 4:
                    System.out.println("Tarea pendiente:");
                    for (Tarea t : taskManager.getPendingTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.println("Tarea completada:");
                    for (Tarea t : taskManager.getCompletedTasks()) {
                        System.out.println(t);
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Codigo Invalido. vuelva a intentarlo.");
            }
        }
    }
}

