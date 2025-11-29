
import java.io.*;
import java.util.*;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        TaskRepository repo = new TaskRepository("tasks.txt");
        TaskService service = new TaskService(repo);

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addTask(repo); break;
                case "2": markTaskDone(service); break;
                case "3": searchTasks(service); break;
                case "4": listSorted(service); break;
                case "5": listAll(repo); break;
                case "6": deleteTask(repo); break;
                case "0": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== TASK MENU ===");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as DONE");
        System.out.println("3. Search Tasks");
        System.out.println("4. List Tasks Sorted by Status");
        System.out.println("5. List All Tasks");
        System.out.println("6. Delete Task");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addTask(TaskRepository repo) {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        Task t = new Task(title, desc, Status.NEW);
        repo.add(t);

        System.out.println("Added.");
    }

    private static void markTaskDone(TaskService service) {
        System.out.print("Task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        service.markDone(id);
        System.out.println("Marked DONE.");
    }

    private static void searchTasks(TaskService service) {
        System.out.print("Search text: ");
        String text = scanner.nextLine();

        List<Task> results = service.search(text);
        printTasks(results);
    }

    private static void listSorted(TaskService service) {
        printTasks(service.listSortedByStatus());
    }

    private static void listAll(TaskRepository repo) {
        printTasks(repo.listAll());
    }

    private static void deleteTask(TaskRepository repo) {
        System.out.print("Task ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        repo.delete(id);
        System.out.println("Deleted.");
    }

    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task t : tasks) {
            System.out.println(
                    t.getId() + " | " +
                            t.getTitle() + " | " +
                            t.getDescription() + " | " +
                            t.getStatus()
            );
        }
    }

}
