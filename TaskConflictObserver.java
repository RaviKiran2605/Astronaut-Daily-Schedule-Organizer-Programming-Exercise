public class TaskConflictObserver implements TaskObserver {
    @Override
    public void notifyConflict(Task newTask, Task conflictingTask) {
        System.out.println("Conflict detected between tasks:");
        System.out.println("New Task: " + newTask.toString());
        System.out.println("Conflicting Task: " + conflictingTask.toString());
    }
}
