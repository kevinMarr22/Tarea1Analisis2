import java.util.List;

public interface Manager {
    void addTask(Tarea task);
    void modifyTask(int taskId, String newDescription, boolean isCompleted);
    void removeTask(int taskId);
    List<Tarea> getPendingTasks();
    List<Tarea> getCompletedTasks();
}


