public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priorityLevel) {
        return new Task(description, startTime, endTime, priorityLevel);
    }
}
