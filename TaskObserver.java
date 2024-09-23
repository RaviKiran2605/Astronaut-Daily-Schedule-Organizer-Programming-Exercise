public interface TaskObserver {
    void notifyConflict(Task newTask, Task conflictingTask);
}
