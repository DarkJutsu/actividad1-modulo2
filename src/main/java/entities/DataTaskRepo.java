package entities;

import _interface.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class DataTaskRepo implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }
    
    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }
}
