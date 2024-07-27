import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorImpl implements Manager {
    private final List<Tarea> tasks = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    @Override
    public void addTask(Tarea task) {
        lock.lock();
        try {
            tasks.add(task);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void modifyTask(int taskId, String newDescription, boolean isCompleted) {
        lock.lock();
        try {
            for (Tarea task : tasks) {
                if (task.getId() == taskId) {
                    task.setDescription(newDescription);
                    task.setCompleted(isCompleted);
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removeTask(int taskId) {
        lock.lock();
        try {
            tasks.removeIf(task -> task.getId() == taskId);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<Tarea> getPendingTasks() {
        lock.lock();
        try {
            List<Tarea> pendingTasks = new ArrayList<>();
            for (Tarea task : tasks) {
                if (!task.isCompleted()) {
                    pendingTasks.add(task);
                }
            }
            return pendingTasks;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public List<Tarea> getCompletedTasks() {
        lock.lock();
        try {
            List<Tarea> completedTasks = new ArrayList<>();
            for (Tarea task : tasks) {
                if (task.isCompleted()) {
                    completedTasks.add(task);
                }
            }
            return completedTasks;
        } finally {
            lock.unlock();
        }
    }
}


