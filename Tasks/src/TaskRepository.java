import java.io.*;
import java.util.*;

public class TaskRepository {

    private final File file;

    private final List<Task> tasks = new ArrayList<>();

    public TaskRepository(String path) {
        this.file = new File(path);
        load();
    }

    public void add(Task task) {
        tasks.add(task);
        save();
    }

    public Task getById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    public List<Task> listAll() {
        return new ArrayList<>(tasks);
    }

    public void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                save();
                return;
            }
        }
    }

    public void delete(int id) {
        tasks.removeIf(t -> t.getId() == id);
        save();
    }

    private void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(this.file))) {
            for (Task t : tasks) {
                pw.println(toJson(t));
            }
        } catch (Exception e) {
            System.out.println("save error: " + e.getMessage());
        }
    }

    private void load() {
        if (!file.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                Task t = fromJson(line);
                if (t != null) {
                    tasks.add(t);
                }
            }
        } catch (Exception e) {
            System.out.println("load error: " + e.getMessage());
        }
    }

    private String toJson(Task t) {
        return String.format(
                "{\"id\":%d,\"title\":\"%s\",\"description\":\"%s\",\"status\":\"%s\"}",
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getStatus().name()
        );
    }

    private Task fromJson(String json) {
        try {
            json = json.replace("{", "").replace("}", "");
            String[] parts = json.split(",");
            Map<String, String> map = new HashMap<>();

            for (String p : parts) {
                String[] kv = p.split(":");
                String key = kv[0].replace("\"", "").trim();
                String value = kv[1].replace("\"", "").trim();
                map.put(key, value);
            }

            Task t = new Task(
                    map.get("title"),
                    map.get("description"),
                    Status.valueOf(map.get("status"))
            );

            var field = Task.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(t, Integer.parseInt(map.get("id")));

            return t;
        } catch (Exception e) {
            return null;
        }
    }
}