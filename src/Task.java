public class Task {
    public int priority;
    public boolean isCompleted;
    public String taskContent;

    Task(String taskContent, boolean isCompleted, int priority) {
        this.isCompleted = isCompleted;
        this.priority = priority;
        this.taskContent = taskContent;
    }
}
