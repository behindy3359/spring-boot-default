package codingon.spring_boot_default.IoCT;

public class EmailNotificationService implements NotificationService{
  @Override
  public void sendingNotification() {
    System.out.println("Sending E-mail Notification : your order has been processed");
  }
}
