package codingon.spring_boot_default.IoCT;

public class OrderService {
  private Order order;

  private NotificationService notificationService;

  public OrderService(Order order, NotificationService notificationService) {
    this.order = order;
    this.notificationService = notificationService;
  }

  public void setNotificationService(NotificationService notify) {
    this.notificationService = notify;
  }

  public void processOrder(){
    System.out.println("Order process successfully");
  }

  public void sendingNotification(){
    notificationService.sendingNotification();
  }
}
