public class Main {
    public static void main(String[] args) {


        TaskRepository repo = new TaskRepository("tasks.txt");

        Task t1 = new Task("Task A", "Description A", Status.NEW);
        repo.add(t1);

        Task t2 = new Task("Task B", "Description B", Status.IN_PROGRESS);
        repo.add(t2);

        System.out.println("All tasks:");
        for (Task t : repo.listAll()) {
            System.out.println(t.getId() + " - " + t.getTitle());
        }

        Task t = repo.getById(1);
        if (t != null) {
            t.setStatus(Status.DONE);
            repo.update(t);
        }

        repo.delete(2);

        System.out.println("After changes:");
        for (Task task : repo.listAll()) {
            System.out.println(task.getId() + " - " + task.getTitle() + " [" + task.getStatus() + "]");
        }
    }

}
