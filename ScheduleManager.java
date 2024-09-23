import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private TaskObserver observer;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observer = new TaskConflictObserver();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) {
        if (!isValidTimeFormat(task.getStartTime()) || !isValidTimeFormat(task.getEndTime())) {
            System.out.println("Error: Invalid time format.");
            return;
        }
        Task conflictingTask = getConflictingTask(task);
        if (conflictingTask != null) {
            observer.notifyConflict(task, conflictingTask);
            return;
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }

    private Task getConflictingTask(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 &&
                newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0) {
                return existingTask;
            }
        }
        return null;
    }

    private boolean isValidTimeFormat(String time) {
        return time.matches("^([01]\\d|2[0-3]):[0-5]\\d$");
    }
}
