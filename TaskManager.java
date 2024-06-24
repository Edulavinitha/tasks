import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    // A class to represent a Task
    static class Task {
        private String description;

        public Task(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
    public static void main(String[] args) {
        // A list to store tasks
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Task Manager:");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. List tasks");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description : ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Task added.");
                    break;

                case 2:
                    System.out.println("Enter the number of the task to remove: ");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.remove(taskNumber - 1);
                        System.out.println("Task removed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3:
                    System.out.println("Task List:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Quitting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }
}

