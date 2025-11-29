import java.io.*;
import java.util.*;
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }


    public void markDone(int id) {
        Task t = repo.getById(id);
        if (t != null) {
            t.setStatus(Status.DONE);
            repo.update(t);
        }
    }

    public List<Task> search(String text) {
        List<Task> result = new ArrayList<>();
        String lower = text.toLowerCase();

        for (Task t : repo.listAll()) {
            if (t.getTitle().toLowerCase().contains(lower) ||
                    t.getDescription().toLowerCase().contains(lower)) {
                result.add(t);
            }
        }

        return result;
    }

    public List<Task> listSortedByStatus() {
        List<Task> list = repo.listAll();
        list.sort(Comparator.comparing(Task::getStatus));
        return list;
    }
}
