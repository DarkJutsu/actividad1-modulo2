package entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String projectName;
    private final List<Task> tasks;

    public Project(String projectName) {
        this.projectName = projectName;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
