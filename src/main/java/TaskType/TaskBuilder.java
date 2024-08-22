package TaskType;

import java.util.Objects;

public class TaskBuilder {
    private String description;
    private String taskType;
    private String by;
    private String from;
    private String to;

    public TaskBuilder(String description, String taskType) {
        this.description = description;
        this.taskType = taskType;
    }

    public TaskBuilder by(String by) {
        if (Objects.equals(by, "")) {
            System.out.println("by cannot be empty");
        }
        return this;
    }

    public TaskBuilder from(String from) {
        if (Objects.equals(from, "")) {
            System.out.println("from cannot be empty");
        }
        this.from = from;
        return this;
    }

    public TaskBuilder to(String to) {
        if (Objects.equals(to, "")) {
            System.out.println("to cannot be empty");
        }
        this.to = to;
        return this;
    }

    public Task build() {
        switch (taskType) {
            case "todo":
                if (!Objects.equals(description, "")) {
                    ToDo todo = new ToDo(description);
                    System.out.println(todo);
                    return todo;
                } else {
                    System.out.println("Todo requires a description!");
                    throw new IllegalArgumentException("Todo requires a description!");
                }
            case "deadline":
                if (by != null) {
                    Deadline deadline = new Deadline(description, by);
                    System.out.println(deadline);
                    return deadline;
                } else {
                    System.out.println("deadline requires a 'by' parameter man!");

                    throw new IllegalArgumentException("deadline requires a 'by' parameter man!");
                }
            case "event":
                if (from != null && to != null) {
                    Event event = new Event(description, from, to);
                    System.out.println(event);
                    return event;
                } else {
                    System.out.println("event requires 'from' and 'to' parameter");

                    throw new IllegalArgumentException("event requires 'from' and 'to' parameter");
                }
            default:
                throw new IllegalArgumentException("invalid task type.");
        }
    }
}
