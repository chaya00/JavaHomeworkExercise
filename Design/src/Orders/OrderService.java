package Orders;

public class OrderService {
    public Order createOrder(int customerId, double amount) { return new Order(); }
    public Order getOrder(int id) { return new Order(); }
    public void updateStatus(int id, Status status) {}
}