public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priorityLevel;

    public Task(String description, String startTime, String endTime, String priorityLevel) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priorityLevel = priorityLevel;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priorityLevel + "]";
    }
}
