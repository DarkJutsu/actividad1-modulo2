package entities;

import _interface.TaskRepository;

import java.util.List;

public class TaskManager {
    private TaskRepository repo;

    public TaskManager(TaskRepository repo) {
        this.repo = repo;
    }

    public void createTask(String name, String description, int priority) {
        Task newTask = new Task(name, description, priority);
        repo.addTask(newTask);
    }

    public void updateTask(String name, String newStatus) {
        for (Task task : repo.getAllTasks()) {
            if (task.getName().equals(name)) {
                task.setStatus(newStatus);
                System.out.println("El estado de la tarea " + name + " ha sido actualizado a " + newStatus);
                return;
            }
        }
        System.out.println("La tarea " + name + " no esxiste.");
    }

    public List<Task> getAllTasks() {
        return repo.getAllTasks();
    }
}
