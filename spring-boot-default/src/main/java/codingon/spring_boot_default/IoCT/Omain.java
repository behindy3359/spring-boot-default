package codingon.spring_boot_default.IoCT;

public class Omain {
  public static void main(String[] args) {
    Order order = new Order();
    EmailNotificationService emailNotify = new EmailNotificationService();
    SMSNotificationService smsNotify = new SMSNotificationService();

    OrderService orderService = new OrderService(order, emailNotify);
    orderService.processOrder();
    orderService.sendingNotification();

    System.out.println("---");
    orderService.setNotificationService(smsNotify);
    orderService.processOrder();
    orderService.sendingNotification();
  }
}
