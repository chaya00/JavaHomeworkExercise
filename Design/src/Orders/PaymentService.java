package Orders;

public class PaymentService {
    private OrderService orderService;

    public Payment createPayment(int orderId, double amount, PaymentMethod method) {
        Order o = orderService.getOrder(orderId);
        if (o == null) throw new IllegalArgumentException("Order not found");
        if (o.getStatus() == Status.PAID) throw new IllegalStateException("Order already paid");
        orderService.updateStatus(orderId,Status.PAID);
        return new Payment();
    }
}
