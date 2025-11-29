public class Main {
    public static void main(String[] args) {

        // דוגמה לשימוש במחלקת Task
        Task t = new Task("Title", "Desc", Status.NEW);

        System.out.println(t.getId());
        System.out.println(t.getTitle());
    }
}
