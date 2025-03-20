import java.util.*;

public class Main {
    // Create HashMap for storing tasks, unfortunately temporarily :(, maybe I will implement storing tasks locally later :)
    private static final HashMap<String, Task> tasks = new HashMap<>();

    public static void main(String[] args) {
        // Create scanner
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Welcome to BasicCLItodo, a command-line program for managing your tasks!");
            while (true) {
                System.out.println("What do you want to do?");
                System.out.println("0. Exit");
                System.out.println("1. View tasks");
                System.out.println("2. Add a task");
                System.out.println("3. Remove a task");
                System.out.println("4. Complete a task");
                // Get user input
                int userInput = scan.nextInt();
                scan.nextLine();
                switch (userInput) {
                    case 0 -> System.exit(0); // Exit the program
                    // List tasks
                    case 1 -> tasks.forEach((key, task) ->
                        System.out.println("Task: " + task.taskContent + " | Priority: " + task.priority + " | Completed: " + task.isCompleted));
                    case 2 -> {
                        // Add task
                        System.out.println("Task content:");
                        String userInput2 = scan.nextLine();
                        System.out.println("Task Priority (0 = low, 1 = medium, 2 = high)");
                        int userInput3 = scan.nextInt();
                        // if user puts a number higher than 2, it will be automatically put to 2 (high priority)
                        if (userInput3 > 2) {
                            System.out.println("Invalid number. Setting priority to high.");
                            userInput3 = 2;
                        }
                        // Create task
                        Task task = new Task(userInput2, false, userInput3);
                        // Put it to the hashmap
                        tasks.put(task.taskContent, task);
                    }
                    case 3 -> {
                        // Remove Task
                        System.out.println("Content of the task you want to remove?");
                        String userInput3 = scan.nextLine();
                        tasks.remove(userInput3);
                    }
                    case 4 -> {
                        // Complete Task
                        System.out.println("Content of the task you want to complete?");
                        String userInput3 = scan.nextLine();
                        Task task = tasks.get(userInput3);
                        if (task != null) {
                            task.isCompleted = true;
                            System.out.println("Task marked as completed.");
                        } else {
                            System.out.println("Task not found.");
                        }
                    }
                    default -> throw new InputMismatchException("Input invalid.");
                }
            }
        } catch (InputMismatchException e) {
            // Catch invalid input
            System.out.println("Input invalid.");
        }
    }
}